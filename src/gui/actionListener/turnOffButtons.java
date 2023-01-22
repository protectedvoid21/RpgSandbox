package gui.actionListener;

import game.board.RoundManager;
import game.interfaces.ITurnOffButtons;
import gui.actionListener.warhammerActions.TurnOffWarhammer;
import gui.views.gamePanel.MainPanelGame;

import static game.interfaceWarhammer.StruggleAtributeEnum.ACTIONS_TO_DO;

public class turnOffButtons {
    public static void turnOff(RoundManager roundManager, MainPanelGame mainPanelGame, Integer parametr, Integer usedIndex){
        ITurnOffButtons offButton = new TurnOffWarhammer();
        offButton.turnOff(roundManager,mainPanelGame,parametr,usedIndex);
        mainPanelGame.getGamePanel().disableOptionsPanel();
        mainPanelGame.setMovesNumber(roundManager.getGameObjectWithTurn().getCreature().getStruggleStatistics().getAttribute(ACTIONS_TO_DO).getValue());
        roundManager.removeDead();
        mainPanelGame.getGamePanel().applyContent(roundManager.boardToList());
        mainPanelGame.getGamePanel().colorButtons(roundManager.getGameObjectWithTurnPosition());
    }
}
