package gui.actionListener.warhammerActions;

import game.board.RoundManager;
import game.generals.Vector2;
import gui.views.gamePanel.MainPanelGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.interfaceWarhammer.ActionsEnum.MULTIPLE_ATTACK;
import static game.interfaceWarhammer.AttributeEnum.*;

public class MultipleAttackListener implements ActionListener {

    RoundManager roundManager;
    MainPanelGame mainPanelGame;

    public MultipleAttackListener(RoundManager roundManager, MainPanelGame mainPanelGame) {
        this.roundManager = roundManager;
        this.mainPanelGame = mainPanelGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Vector2 point = mainPanelGame.getGamePanel().getCurrentClickedIndexes();
        roundManager.getActions().doAction(MULTIPLE_ATTACK, roundManager.getGameObjectWithTurn().getCreature(),
                roundManager.getBoard().getPlace(point).getGameObject().getCreature());

        for (int i = 0; i < roundManager.getGameObjectWithTurn().getCreature().getStatistics().getAttribute(ATTACKS).getValue(); i++) {
            mainPanelGame.getGamePanel().applyAttackActionsContent(point);
        }


    }
}
