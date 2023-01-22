package gui.actionListener.warhammerActions;

import game.board.RoundManager;
import game.generals.Vector2;
import gui.actionListener.turnOffButtons;
import gui.views.gamePanel.MainPanelGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
        ArrayList<String> popUp = new ArrayList<>();
        roundManager.getActions().doAction(MULTIPLE_ATTACK, roundManager.getGameObjectWithTurn().getCreature(),
                roundManager.getBoard().getPlace(point).getGameObject().getCreature(),popUp);

        mainPanelGame.getGamePanel().setInformationPanelText(popUp);
        turnOffButtons.turnOff(roundManager,mainPanelGame,0,4);

    }
}
