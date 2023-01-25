package gui.actionListener.basicActionsListener;

import game.board.RoundManager;
import gui.actionListener.turnOffButtons;
import gui.views.gamePanel.MainPanelGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndTurnListener implements ActionListener {

    RoundManager roundManager;
    MainPanelGame mainPanelGame;

    public EndTurnListener(RoundManager roundManager, MainPanelGame mainPanelGame) {
        this.roundManager = roundManager;
        this.mainPanelGame = mainPanelGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        roundManager.moveToNextObject();
        mainPanelGame.getGamePanel().colorButtons(roundManager.getGameObjectWithTurnPosition());
        turnOffButtons.turnOff(roundManager,mainPanelGame,2,0);
    }
}
