package gui.views.gamePanel;

import com.kitfox.svg.A;
import game.equipment.Item;
import gui.card.IOverallFactory;
import gui.customComponents.AbstractCustomButton;
import gui.customComponents.AbstractCustomLabel;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;
import gui.views.gamePanel.gamePanels.GamePanel;
import gui.views.gamePanel.optionsPanels.GameOptionsPanel;
import gui.views.gamePanel.optionsPanels.OptionsPanel;
import gui.views.objectViews.ItemPicker;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MainPanelGame {
    private DefaultCustomMenuMenager menager =
            new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.VERTICAL,
                    ComponentsSeries.ComponentsDimension.HORIZONTAL);
    private GamePanel gamePanel;
    private ArrayList<ItemPicker> pickers = new ArrayList<>();
    private AbstractCustomButton exitButton;
    private AbstractCustomButton nextPlayerButton;
    private GameOptionsPanel activityOptionsPanel;
    private Dice dice;

    private AbstractCustomLabel remainingMoves;
    private ComponentsSeries<ComponentPanelMenager> seriesPanel =
            new ComponentsSeries(ComponentsSeries.ComponentsDimension.VERTICAL);
    private ComponentsSeries<JComponent> pickersSeriesPanel =
            new ComponentsSeries(ComponentsSeries.ComponentsDimension.VERTICAL);
    private IOverallFactory factory;

    public MainPanelGame(IOverallFactory factory) {
        this.factory = factory;
        gamePanel = new GamePanel(factory, 10);
        dice = new Dice(factory.getFactory());
        gamePanel.initialize();
        factory.getFactory().setButtonType(GuiFactory.ButtonType.NORMAL);
        factory.getFactory().setLabelType(GuiFactory.LabelType.NORMAL);
        remainingMoves = factory.getFactory().createLabel("0");
        exitButton = factory.getFactory().createButton("EXIT", null);
        nextPlayerButton = factory.getFactory().createButton("NEXT", null);
        activityOptionsPanel = new GameOptionsPanel(factory.getFactory(), 7);
        activityOptionsPanel.initialize(10);
        activityOptionsPanel.getPanel().setVisible(true);
        activityOptionsPanel.setUniqueColor(false);
        initialize();
        menager.getCmp().setHasUniqueColor(true);
        menager.getCmp().setBackground(new Color(0x56A6A6));


    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public JPanel getPanel() {
        return menager.getCmp();
    }

    public ItemPicker getPicker(int index) {
        return pickers.get(index);
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

    public void initialize() {
        menager.addMainComponent(15);
        menager.addMainComponent(2);
        menager.addMiddleComponent(gamePanel.getPanel(), 0, 10);
        menager.addMiddleComponent(seriesPanel, 0, 1);
        menager.getMiddleComponent(0, 1).addSpace(1);
        var pickerseries = new ComponentPanelMenager<>(pickersSeriesPanel);
        pickerseries.addSpace(10, ComponentPanelMenager.Side.TOP, ComponentPanelMenager.Side.BOTTOM);
        seriesPanel.addOption(pickerseries, 10);
        createPicker();
//        var movesLabel = factory.getFactory().createLabel("MOVES");
        for (var component : Arrays.asList(remainingMoves, nextPlayerButton, exitButton, dice.getDice())) {
            var cmp = new ComponentPanelMenager<>(component);
            cmp.addSpace(component == dice.getDice() ? 0 : 1);
            seriesPanel.addOption(cmp, 2);
        }
        menager.addMiddleComponent(activityOptionsPanel.getPanel(), 1, 10);
        activityOptionsPanel.getPanel().addSpace(2);
        activityOptionsPanel.initializeButtonsData(new ArrayList<>(Arrays.asList("xx", "dd", "ffff", "Fsd", "FDsf",
                "Fsf")));
        activityOptionsPanel.initializeLabelsData(new ArrayList<>(Arrays.asList("1", "2", "3", "1", "1", "1")));
    }

    public void createPicker() {
        var picker = new ItemPicker(factory.getFactory());
        pickersSeriesPanel.addOption(picker.getPanel(), 10);
        picker.uploadData(new ArrayList<>(Arrays.asList("src/gui/ave.jpg", "src/gui/ave22.png", "src/gui/aveeee.jpg")));

    }

    public void setMovesNumber(int val) {
        remainingMoves.setContent(Integer.toString(val));
    }
}
