package gui.actionListener.warhammerActions;

import game.board.RoundManager;
import game.generals.Vector2;
import gui.actionListener.turnOffButtons;
import gui.views.gamePanel.MainPanelGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.interfaceWarhammer.ActionsEnum.*;

public class AttackListener implements ActionListener {

    RoundManager roundManager;
    MainPanelGame mainPanelGame;
    public AttackListener(RoundManager roundManager, MainPanelGame mainPanelGame) {
        this.roundManager = roundManager;
        this.mainPanelGame = mainPanelGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Vector2 point = mainPanelGame.getGamePanel().getCurrentClickedIndexes();
        roundManager.getActions().doAction(ATTACK,roundManager.getGameObjectWithTurn().getCreature(),roundManager.getBoard().getPlace(point).getGameObject().getCreature());

        turnOffButtons.turnOff(roundManager,mainPanelGame,0,2);

    }
}
