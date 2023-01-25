package gui.views.menuViews;

import gui.customComponents.booleanComponents.CustomBooleanButton;
import gui.views.BackgroundView;
import gui.card.SharedCmpsFont;
import gui.customComponents.AbstractCustomButton;
import gui.customUI.customUIStyles.borderStrategies.DefaultBorderStrategy;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;
import gui.views.PanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuView extends BackgroundView implements PanelContainer {
    private GuiFactory factory;
    private ArrayList<AbstractCustomButton> buttons = new ArrayList<>();
    private CustomBooleanButton audioButton;
    private DefaultCustomMenuMenager<JComponent> manager =
            new DefaultCustomMenuMenager<>(ComponentsSeries.ComponentsDimension.VERTICAL,
                    ComponentsSeries.ComponentsDimension.HORIZONTAL);

    public MenuView(GuiFactory factory) {
        this.factory = factory;
        manager.getCmp().addSpace(2, ComponentPanelMenager.Side.BOTTOM, ComponentPanelMenager.Side.TOP);
        manager.getCmp().addSpace(2, ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.LEFT);
        manager.addMainComponent(14);
        factory.setLabelType(GuiFactory.LabelType.NORMAL);
        manager.addMiddleComponent(factory.createLabel("RPG ENGINE"), 0, 1);
        manager.getMiddleComponent(0, 0).addSpace(3, ComponentPanelMenager.Side.BOTTOM);
        createButton("NEW GAME", 1, false);
        createButton("ITEMS", 2, false);
        createButton("CREATURES", 3, false);
        createButton("SCENARIO", 4, false);
        createButton(null, 5, true);
        createButton("EXIT", 6, false);
        SharedCmpsFont.setUniformFont(buttons);
    }

    public void setAudioButtonsListener(ActionListener on, ActionListener off) {
        audioButton.setListeners(on, off);
    }

    private void createButton(String name, int index, boolean boolValue) {
        factory.setButtonType(!boolValue ? GuiFactory.ButtonType.NORMAL : GuiFactory.ButtonType.DOUBLE);
        AbstractCustomButton button;
        if (!boolValue) {
            button = factory.createButton(name, null);
        } else {
            audioButton = factory.createButton("SOUND ON", "SOUND OFF", false);
            button = audioButton;
        }
        buttons.add(button);
        manager.addMainComponent(10);
        manager.addMiddleComponent(button, index, 10);
        manager.getMiddleComponent(index, 0).addSpace(2, ComponentPanelMenager.Side.TOP,
                ComponentPanelMenager.Side.BOTTOM);
        manager.getMiddleComponent(index, 0).addSpace(1, ComponentPanelMenager.Side.RIGHT,
                ComponentPanelMenager.Side.LEFT);
    }

    public ComponentPanelMenager getPanel() {
        return manager.getCmp();
    }

    public JButton getNewGameButton() {
        return buttons.get(0);
    }

    public JButton getItemsButton() {
        return buttons.get(1);
    }

    public JButton getCreaturesButton() {
        return buttons.get(2);
    }

    public JButton getScenarioButton() {
        return buttons.get(3);
    }

    public JButton getExitButton() {
        return buttons.get(5);
    }

    @Override
    protected DefaultCustomMenuMenager<JComponent> getMenager() {
        return manager;
    }
}
