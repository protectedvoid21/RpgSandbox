package gui.actionListener.warhammerActions;

import game.board.RoundManager;
import game.creature.Creature;
import gui.actionListener.turnOffButtons;
import gui.views.gamePanel.MainPanelGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.interfaceWarhammer.ActionsEnum.BLOCK;
import static game.interfaceWarhammer.ActionsEnum.DEFENSE_STAND;

public class DefenseStandListener implements ActionListener {

    RoundManager roundManager;
    MainPanelGame mainPanelGame;

    public DefenseStandListener(RoundManager roundManager, MainPanelGame mainPanelGame) {
        this.roundManager = roundManager;
        this.mainPanelGame = mainPanelGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Creature you = roundManager.getGameObjectWithTurn().getCreature();
        roundManager.getActions().doAction(BLOCK, you);
        mainPanelGame.getGamePanel().applyDefendActionsContent(mainPanelGame.getGamePanel().getCurrentClickedIndexes());

        turnOffButtons.turnOff(roundManager,mainPanelGame,1,2);

    }
}