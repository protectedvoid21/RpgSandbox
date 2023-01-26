package gui.actionListener.basicActionsListener;

import game.board.RoundManager;

import gui.actionListener.ListenerBaseData;
import gui.actionListener.warhammerActions.turnOffUseItem;
import gui.views.gamePanel.MainPanelGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TurnOnEnemySelecting implements ActionListener {

    //    RoundManager roundManager;
//    MainPanelGame mainPanelGame;
    private ListenerBaseData listenerBaseData;

    public TurnOnEnemySelecting(ListenerBaseData listenerBaseData) {
//        this.roundManager = roundManager;
//        this.mainPanelGame = mainPanelGame;
        this.listenerBaseData = listenerBaseData;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

       listenerBaseData.mainPanelGame.getGamePanel().changeActiveOptionsPanel();

    }
}
