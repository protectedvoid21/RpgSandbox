package gui.actionListener.warhammerActions;

import game.board.RoundManager;
import game.creature.Creature;
import gui.actionListener.ListenerBaseData;
import gui.actionListener.turnOffButtons;
import gui.views.gamePanel.MainPanelGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.interfaceWarhammer.ActionsEnum.BLOCK;
import static game.interfaceWarhammer.ActionsEnum.DEFENSE_STAND;

public class DefenseStandListener implements ActionListener {

    private ListenerBaseData listenerBaseData;

    public DefenseStandListener(ListenerBaseData listenerBaseData) {
        this.listenerBaseData = listenerBaseData;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var mainPanelGame = listenerBaseData.mainPanelGame;
        var roundManager = listenerBaseData.roundManager;

        Creature you = roundManager.getGameObjectWithTurn().getCreature();
        roundManager.getActions().doAction(BLOCK, you);
        mainPanelGame.getGamePanel().applyDefendActionsContent(roundManager.getGameObjectWithTurnPosition());

        turnOffButtons.turnOff(roundManager, mainPanelGame, 1, 2);

    }
}