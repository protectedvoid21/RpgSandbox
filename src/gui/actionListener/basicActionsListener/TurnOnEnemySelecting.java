package gui.actionListener.basicActionsListener;

import game.board.RoundManager;

import gui.actionListener.warhammerActions.turnOffUseItem;
import gui.views.gamePanel.MainPanelGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TurnOnEnemySelecting implements ActionListener {

    RoundManager roundManager;
    MainPanelGame mainPanelGame;

    public TurnOnEnemySelecting(RoundManager roundManager, MainPanelGame mainPanelGame) {
        this.roundManager = roundManager;
        this.mainPanelGame = mainPanelGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        mainPanelGame.getGamePanel().changeActiveOptionsPanel();

    }
}
