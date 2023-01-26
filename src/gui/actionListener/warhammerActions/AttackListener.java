package gui.actionListener.warhammerActions;

import game.board.RoundManager;
import game.generals.Vector2;
import gui.actionListener.turnOffButtons;
import gui.views.gamePanel.MainPanelGame;
import game.interfaceWarhammer.AttributeEnum.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static game.interfaceWarhammer.ActionsEnum.*;
import static game.interfaceWarhammer.AttributeEnum.HEALTH_POINTS_NOW;

public class AttackListener implements ActionListener {

    RoundManager roundManager;
    MainPanelGame mainPanelGame;

    public AttackListener(RoundManager roundManager, MainPanelGame mainPanelGame) {
        this.roundManager = roundManager;
        this.mainPanelGame = mainPanelGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        Vector2 point = mainPanelGame.getGamePanel().getCurrentClickedIndexes();

        Vector2 point = roundManager.getGameObjectWithTurnPosition();
        ArrayList<String> popUp = new ArrayList<>();
        roundManager.getActions().doAction(ATTACK, roundManager.getGameObjectWithTurn().getCreature(),
                roundManager.getBoard().getPlace(point).getGameObject().getCreature(), popUp);

        mainPanelGame.getGamePanel().setInformationPanelText(popUp);
        turnOffButtons.turnOff(roundManager, mainPanelGame, 0, 2);

    }
}
