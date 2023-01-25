package gui.views.gamePanel.gamePanels;

import game.generals.Vector2;
import gui.factories.IOverallFactory;
import gui.utils.StringAdapter;
import gui.views.gamePanel.optionsPanels.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GamePanel extends BaseGamePanel {

    private LabelMultipleGameOptionsPanel gameOptionsPanel;
    private MultipleGameOptionsPanel maxioItemsOptionsPanel;

    public enum ActionsLabelsType {ATACK, DEFEND}

    private DefendAttackActionsPanel defendAttackActionsPanel;
    private InformationPanel informationPanel;

//    private MultipleGameOptionsPanel activeOptionsPanel = null;


    public GamePanel(IOverallFactory factory, int size) {
        super(factory, size);
        informationPanel = new InformationPanel(factory.getFactory());
        informationPanel.getPanel().addSpace(10);
        defendAttackActionsPanel = new DefendAttackActionsPanel(size);
        maxioItemsOptionsPanel.applyUnivibilityAfterClicked();
    }

    public void changeActiveOptionsPanel() {
        optionsPanel = optionsPanel == maxioItemsOptionsPanel ? gameOptionsPanel : maxioItemsOptionsPanel;
//        optionsPanel = activeOptionsPanel;
    }

    public void setActionsVisibility(boolean value) {
        defendAttackActionsPanel.getPanel().setVisible(value);
    }

    public void setOptionsDisabledIndexes(Vector2 point, ArrayList<Integer> indexes) {
        (optionsPanel == gameOptionsPanel ? gameOptionsPanel : maxioItemsOptionsPanel).setDisabledIndexes(point,
                indexes);
    }

    public void setOptionsDisabledIndexes(Vector2 point, Integer... indexes) {
//        activeOptionsPanel.setDisabledIndexes(point, indexes);
        setOptionsDisabledIndexes(point, new ArrayList<>(Arrays.asList(indexes)));
    }

    public void setAttackArmorPathContent(String armorPath, String attackPath) {
        defendAttackActionsPanel.setAttackArmorPathContent(armorPath, attackPath);
    }

    public void initializeOptionsPanelLabelData(ArrayList<String> optionsPanelLabelData) {
        gameOptionsPanel.initializeLabelsData(optionsPanelLabelData);
    }

    @Override
    public void initialize() {
        super.initialize();
        setAttackArmorPathContent(StringAdapter.getRelativePath("armor.png"), StringAdapter.getRelativePath(
                "knivesOpt.png"));
        defendAttackActionsPanel.initialize();
    }

    @Override
    public void setBorder(Color color, int value) {
        super.setBorder(color, value);
        informationPanel.setBorder(color, value * 2);
        maxioItemsOptionsPanel.setBorder(color, value);
    }

    public void removeActionContent(Vector2 pos, ActionsLabelsType type) {
        defendAttackActionsPanel.removeActionContent(pos, type);
    }

    @Override
    protected void addPanels() {
        panel.add(informationPanel.getPanel());
        panel.add(maxioItemsOptionsPanel.getPanel());
        panel.add(optionsPanel.getPanel());
        panel.add(defendAttackActionsPanel.getPanel());
        panel.add(manager.getCmp());
    }


    @Override
    public void createOptionsPanel() {
        var opt = new LabelMultipleGameOptionsPanel(factory.getFactory(), 5);
        gameOptionsPanel = opt;
        optionsPanel = opt;
        optionsPanel.initialize(weight);
        maxioItemsOptionsPanel = new MultipleGameOptionsPanel(factory.getFactory(), 2);
//        activeOptionsPanel = gameOptionsPanel;
        maxioItemsOptionsPanel.initialize(weight);
    }

    public void applyDefendActionsContent(Vector2 position) {
        this.defendAttackActionsPanel.applyDefendActionsContent(position);
    }

    public void applyAttackActionsContent(Vector2 position) {
        this.defendAttackActionsPanel.applyAttackActionsContent(position);
    }

    public void setInformationPanelText(ArrayList<String> content) {
        informationPanel.setNewLabelContent(content);
    }
}
