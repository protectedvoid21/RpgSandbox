package gui.views.gamePanel.gamePanels;

import game.generals.Vector2;
import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.AbstractCustomLabel;
import gui.customComponents.iconComponents.IconLabel;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;
import gui.views.PanelContainer;
import java.util.HashMap;
import java.util.Map;

public class DefendAttackActionsPanel implements PanelContainer {
    private final HashMap<GamePanel.ActionsLabelsType, ActionsData> actionsMap = new HashMap<>();
    private final DefaultCustomMenuMenager<ComponentsSeries<ComponentPanelMenager<AbstractCustomLabel>>> managerActions =
            new DefaultCustomMenuMenager<>(ComponentsSeries.ComponentsDimension.HORIZONTAL,
                    ComponentsSeries.ComponentsDimension.VERTICAL);
    private final HashMap<GamePanel.ActionsLabelsType, Integer> indexesMap =
            new HashMap<>(Map.of(GamePanel.ActionsLabelsType.ATACK, 0, GamePanel.ActionsLabelsType.DEFEND, 1));
    private final int maxIndex;

    public DefendAttackActionsPanel(int maxIndex) {
        this.maxIndex = maxIndex;
        actionsMap.put(GamePanel.ActionsLabelsType.DEFEND, new ActionsData());
        actionsMap.put(GamePanel.ActionsLabelsType.ATACK, new ActionsData());
    }

    public void setAttackArmorPathContent(String armorPath, String attackPath) {
        actionsMap.get(GamePanel.ActionsLabelsType.DEFEND).setPath(armorPath);
        actionsMap.get(GamePanel.ActionsLabelsType.ATACK).setPath(attackPath);
    }

    public void initialize() {
        for (int i = 0; i < maxIndex; i++) {
            managerActions.addMainComponent(5);
            for (int j = 0; j < maxIndex; j++) {
                var cmp = new ComponentsSeries<ComponentPanelMenager<AbstractCustomLabel>>(ComponentsSeries.ComponentsDimension.HORIZONTAL);
                var cmp1 = new ComponentPanelMenager<AbstractCustomLabel>(new IconLabel(Card.EMPTY_DATA_CONTENT, true));
                cmp1.setVisible(false);
                var cmp2 = new ComponentPanelMenager<AbstractCustomLabel>(new IconLabel(Card.EMPTY_DATA_CONTENT, true));
                cmp2.setVisible(false);
                cmp.addOption(cmp1, 10);
                cmp.addOption(cmp2, 10);
                managerActions.addMiddleComponent(cmp, i, 5);
                setrelevantSpace(new Vector2(i, j));
            }
        }
    }

    public ComponentPanelMenager getPanel() {
        return managerActions.getCmp();
    }

    public void setVisibilityFullActionContent(boolean value) {
        managerActions.getCmp().setVisible(value);
    }

    public void applyDefendActionsContent(Vector2 position) {
        helpMethodActionsChangeContent(position, GamePanel.ActionsLabelsType.DEFEND);
    }

    public void applyAttackActionsContent(Vector2 position) {
        helpMethodActionsChangeContent(position, GamePanel.ActionsLabelsType.ATACK);
    }

    public void removeActionContent(Vector2 position, GamePanel.ActionsLabelsType type) {
        actionsMap.get(type).removeObject(managerActions.getMiddleComponent(position.x,
                position.y).getComponent().getOption(indexesMap.get(type)).getComponent());
        managerActions.getMiddleComponent(position.x,
                position.y).getComponent().getOption(indexesMap.get(type)).setVisible(false);
        setrelevantSpace(position);
    }

    private void helpMethodActionsChangeContent(Vector2 position, GamePanel.ActionsLabelsType type) {
        if (!position.isOutOfRange(maxIndex, maxIndex)) {
            managerActions.getMiddleComponent(position.x, position.y).getComponent().getOption(indexesMap.get(type)).changeContent(actionsMap.get(type).getNextObject());
            managerActions.getMiddleComponent(position.x,
                    position.y).getComponent().getOption(indexesMap.get(type)).setVisible(true);
            setrelevantSpace(position);
        }

    }

    private void setrelevantSpace(Vector2 position) {
        int space = 0;
        for (var item : managerActions.getMiddleComponent(position.x,
                position.y).getComponent().getComponentsList()) {
            if (item.isVisible()) {
                space++;
            }
        }
        managerActions.getMiddleComponent(position.x,
                position.y).addSpace(Math.max(6 - space * 2, 0));
    }

}


