package gui.actionListener.warhammerActions;

import game.creature.Creature;
import game.generals.Vector2;
import gui.actionListener.ListenerBaseData;
import gui.actionListener.turnOffButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.interfaceWarhammer.ActionsEnum.DEFENSE_STAND;

public class BlockListener implements ActionListener {

    private final ListenerBaseData listenerBaseData;

    public BlockListener(ListenerBaseData listenerBaseData) {
        this.listenerBaseData = listenerBaseData;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var roundManager = listenerBaseData.roundManager;
        Creature you = roundManager.getGameObjectWithTurn().getCreature();
        Vector2 point = roundManager.getGameObjectWithTurnPosition();
        roundManager.getActions().doAction(DEFENSE_STAND, you);
        listenerBaseData.mainPanelGame.getGamePanel().applyDefendActionsContent(point);
        turnOffButtons.turnOff(roundManager,listenerBaseData.mainPanelGame,1,1);
    }
}