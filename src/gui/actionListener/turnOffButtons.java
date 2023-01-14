package gui.actionListener;

import game.board.RoundManager;
import game.interfaces.ITurnOffButtons;
import gui.actionListener.warhammer.TurnOffWarhammer;
import gui.views.gamePanel.MainPanelGame;

public class turnOffButtons {
    public static void turnOff(RoundManager roundManager, MainPanelGame mainPanelGame, Integer parametr, Integer usedIndex){
        ITurnOffButtons offButon = new TurnOffWarhammer();
        offButon.turnOff(roundManager,mainPanelGame,parametr,usedIndex);
    }
}
