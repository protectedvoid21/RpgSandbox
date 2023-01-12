package gui.views.gamePanel.gamePanels;

import gui.factories.IOverallFactory;
import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.AbstractCustomLabel;
import gui.customComponents.iconComponents.IconLabel;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;
import gui.views.Point;
import gui.views.gamePanel.optionsPanels.GameOptionsPanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GamePanel extends BaseGamePanel {

    private GameOptionsPanel gameOptionsPanel;
    public enum ActionsLabelsType {ATACK, DEFEND}
    private HashMap<ActionsLabelsType, IconLabel> actionsMap = new HashMap<>();
    public DefaultCustomMenuMenager<AbstractCustomLabel> managerActions =
            new DefaultCustomMenuMenager<AbstractCustomLabel>(ComponentsSeries.ComponentsDimension.HORIZONTAL,
                    ComponentsSeries.ComponentsDimension.VERTICAL);

    public GamePanel(IOverallFactory factory, int size) {
        super(factory, size);
    }
    public void setAttackArmorPathContent(String armorPath, String attackPath) {
        actionsMap.put(GamePanel.ActionsLabelsType.DEFEND, new IconLabel(armorPath));
        actionsMap.put(GamePanel.ActionsLabelsType.ATACK, new IconLabel(attackPath));
    }

    public void initializeOptionsPanelLabelData( ArrayList<String> optionsPanelLabelData){
        gameOptionsPanel.initializeLabelsData(optionsPanelLabelData);
    }
    @Override
    public void initialize() {
        super.initialize();
        setAttackArmorPathContent("src/gui/undoleft.png", "src/armor.png");
        for (int i = 0; i < maxIndex; i++) {
            managerActions.addMainComponent(5);
            for (int j = 0; j < maxIndex; j++) {
                managerActions.addMiddleComponent(new IconLabel(Card.EMPTY_DATA_CONTENT), i, 5);
                managerActions.getMiddleComponent(i, j).addSpace(5);
            }
        }
    }

    @Override
    protected void addPanels() {
        panel.add(managerActions.getCmp());
        super.addPanels();
    }

    @Override
    public void createOptionsPanel() {
        var opt = new GameOptionsPanel(factory.getFactory(), 5);
        gameOptionsPanel=opt;
        optionsPanel = opt;
        optionsPanel.initialize(weight);
        optionsPanel.setBorderColor(Color.RED);
    }

    public void removeActionsContent() {
        for (int i = 0; i < maxIndex; i++) {
            for (int j = 0; j < maxIndex; j++) {
                managerActions.getMiddleComponent(i, j).getComponent().setContent(Card.EMPTY_DATA_CONTENT);

            }
        }
    }

    public void applyDefendActionsContent(Point position) {
        helpMethodActionsChangeContent(position, ActionsLabelsType.DEFEND);
    }

    public void applyAttackActionsContent(Point position) {
        helpMethodActionsChangeContent(position, ActionsLabelsType.ATACK);
    }

    private void helpMethodActionsChangeContent(Point position, ActionsLabelsType type) {
        if (!position.isOutOfRange(maxIndex, maxIndex)) {
            var pos = managerActions.getMiddleComponent(position.x, position.y);
            var label = pos.getComponent();
            pos.changeContent(actionsMap.get(type));
            var t = new javax.swing.Timer(1500, e -> pos.changeContent(label));
            t.start();
        }

    }
}
