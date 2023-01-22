package gui.views.gamePanel.gamePanels;

import game.generals.Vector2;
import gui.factories.IOverallFactory;
import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.AbstractCustomLabel;
import gui.customComponents.iconComponents.IconLabel;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;
import gui.views.gamePanel.optionsPanels.GameOptionsPanel;
import gui.views.gamePanel.optionsPanels.MultipleGameOptionsPanel;
import gui.views.gamePanel.optionsPanels.OptionsPanelData;

import java.awt.*;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GamePanel extends BaseGamePanel {

    private MultipleGameOptionsPanel gameOptionsPanel;

    public enum ActionsLabelsType {ATACK, DEFEND}
    private DefendAttackActionsPanel defendAttackActionsPanel;
    private InformationPanel informationPanel;


    public GamePanel(IOverallFactory factory, int size) {
        super(factory, size);
        informationPanel = new InformationPanel(factory.getFactory());
        informationPanel.getPanel().addSpace(10);
        defendAttackActionsPanel = new DefendAttackActionsPanel(size);
    }

    public void setActionsVisibility(boolean value){
        defendAttackActionsPanel.getPanel().setVisible(value);
    }

    public void setOptionsDisabledIndexes(Vector2 point, ArrayList<Integer> indexes) {
        gameOptionsPanel.setDisabledIndexes(point, indexes);
    }

    public void setOptionsDisabledIndexes(Vector2 point, Integer... indexes) {
        gameOptionsPanel.setDisabledIndexes(point, indexes);
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
        setAttackArmorPathContent("src/armor.png","src/gui/undoleft.png");
        defendAttackActionsPanel.initialize();
    }

    @Override
    public void setBorder(Color color, int value) {
        super.setBorder(color, value);
        informationPanel.setBorder(color, value*2);
    }

    public void removeActionContent(Vector2 pos, ActionsLabelsType type){
        defendAttackActionsPanel.removeActionContent(pos, type);
    }

    @Override
    protected void addPanels() {
        panel.add(informationPanel.getPanel());
        panel.add(optionsPanel.getPanel());
        panel.add(defendAttackActionsPanel.getPanel());
        panel.add(manager.getCmp());
    }

    @Override
    public void createOptionsPanel() {
        var opt = new MultipleGameOptionsPanel(factory.getFactory(), 5);
        gameOptionsPanel = opt;
        optionsPanel = opt;
        optionsPanel.initialize(weight);
    }

    public void applyDefendActionsContent(Vector2 position) {
        this.defendAttackActionsPanel.applyDefendActionsContent(position);
    }

    public void applyAttackActionsContent(Vector2 position) {
        this.defendAttackActionsPanel.applyAttackActionsContent(position);
    }

    public void setInformationPanelText(ArrayList<String> content){
        informationPanel.setNewLabelContent(content);
    }
}
