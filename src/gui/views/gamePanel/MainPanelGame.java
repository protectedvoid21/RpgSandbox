package gui.views.gamePanel;

import gui.factories.IOverallFactory;
import gui.card.SharedCmpsFont;
import gui.customComponents.AbstractCustomButton;
import gui.customComponents.AbstractCustomLabel;
import gui.factories.GuiFactory;
import gui.factories.TextData;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;
import gui.utils.StringAdapter;
import gui.views.gamePanel.gamePanels.GamePanel;
import gui.views.gamePanel.optionsPanels.GameOptionsPanel;
import gui.views.pickers.FullItemPicker;
import gui.views.pickers.ItemPicker;
import gui.views.pickers.MaxioItemPicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MainPanelGame implements TextData {
    private final DefaultCustomMenuMenager<JComponent> menager =
            new DefaultCustomMenuMenager<>(ComponentsSeries.ComponentsDimension.VERTICAL,
                    ComponentsSeries.ComponentsDimension.HORIZONTAL);
    private final GamePanel gamePanel;
    private final FullItemPicker picker;
    private final MaxioItemPicker itemsItemPicker;
    private final AbstractCustomButton exitButton;
    private final AbstractCustomButton nextPlayerButton;
    private final AbstractCustomButton actionsVisibilityButton;
    private final GameOptionsPanel activityOptionsPanel;
    private final AbstractCustomLabel remainingMoves;
    private final ComponentsSeries<ComponentPanelMenager<? extends JComponent>> seriesPanel =
            new ComponentsSeries<>(ComponentsSeries.ComponentsDimension.VERTICAL);

    public MainPanelGame(IOverallFactory factory) {
        itemsItemPicker = new MaxioItemPicker(factory.getFactory());
        gamePanel = new GamePanel(factory, 10);
//        dice = new Dice(factory.getFactory());
        gamePanel.initialize();
        picker = new FullItemPicker(factory.getFactory());
        factory.getFactory().setButtonType(GuiFactory.ButtonType.NORMAL);
        factory.getFactory().setLabelType(GuiFactory.LabelType.NORMAL);
        remainingMoves = factory.getFactory().createLabel("0");
        exitButton = factory.getFactory().createButton(exitText, null);
        nextPlayerButton = factory.getFactory().createButton(nextText, null);

        factory.getFactory().setButtonType(GuiFactory.ButtonType.ICON);
        actionsVisibilityButton = factory.getFactory().createButton(StringAdapter.getRelativePath("eye.png"), null);
        actionsVisibilityButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                actionMethod("hide.png", false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                actionMethod("eye.png", true);
            }
        });

        activityOptionsPanel = new GameOptionsPanel(factory.getFactory(), 7);
        activityOptionsPanel.initialize(10);
        activityOptionsPanel.getPanel().setVisible(true);
        activityOptionsPanel.setUniqueColor(false);
        initialize();
        menager.getCmp().setHasUniqueColor(true);
        menager.getCmp().setBackground(new Color(0x56A6A6));
        SharedCmpsFont.setUniformFont(new ArrayList<>(Arrays.asList(nextPlayerButton, exitButton)));
    }

    private void actionMethod(String path, boolean value) {
        gamePanel.setActionsVisibility(value);
        actionsVisibilityButton.setContent(StringAdapter.getRelativePath(path));
    }

    public void resizeGamePanel(boolean oversized) {
        menager.getMainComponent(1).setVisible(oversized);
        menager.getMiddleComponent(0, 1).setVisible(oversized);
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public JPanel getPanel() {
        return menager.getCmp();
    }

    public MaxioItemPicker getItemsItemPicker() {
        return itemsItemPicker;
    }

    public ItemPicker getPicker(FullItemPicker.LabelType type) {
        return picker.getPicker(type);
    }

    public AbstractCustomButton getExitButton() {
        return exitButton;
    }

    public AbstractCustomButton getNextPlayerButton() {
        return nextPlayerButton;
    }

    public GameOptionsPanel getActivityOptionsPanel() {
        return activityOptionsPanel;
    }

    public void setRightPickersVisibility(boolean value) {
        seriesPanel.getOption(0).setVisible(value);
        seriesPanel.getOption(1).setVisible(value);
        this.menager.getMiddleComponent(0, 1).addSpace(value ? 0 : 10, ComponentPanelMenager.Side.BOTTOM,
                ComponentPanelMenager.Side.TOP);
    }

    public void initialize() {
        menager.addMainComponent(15);
        menager.addMainComponent(2);
        menager.addMiddleComponent(gamePanel.getPanel(), 0, 8);
        menager.addMiddleComponent(seriesPanel, 0, 1, 20);
        menager.getMiddleComponent(0, 1).addSpace(1);
        var cmp1 = new ComponentPanelMenager<>(picker.getPanel());
        cmp1.addSpace(2, ComponentPanelMenager.Side.TOP, ComponentPanelMenager.Side.BOTTOM);
        var cmp2 = new ComponentPanelMenager<>(itemsItemPicker.getPanel());
        cmp2.addSpace(2, ComponentPanelMenager.Side.BOTTOM);
        seriesPanel.addOption(cmp1, 14);
        seriesPanel.addOption(cmp2, 6);
        for (var component : Arrays.asList(remainingMoves, nextPlayerButton, exitButton, actionsVisibilityButton)) {
            var cmp = new ComponentPanelMenager<>(component);
            cmp.addSpace(1);
            seriesPanel.addOption(cmp, 2);
        }
        menager.addMiddleComponent(activityOptionsPanel.getPanel(), 1, 10);
        activityOptionsPanel.getPanel().addSpace(2);
    }

    public void initializePicker(HashMap<FullItemPicker.LabelType, String> map) {
        picker.uploadMainPaths(map);
    }

    public void setMovesNumber(int val) {
        remainingMoves.setContent(Integer.toString(val));
    }
}
