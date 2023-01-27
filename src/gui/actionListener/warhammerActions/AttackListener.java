package gui.actionListener.warhammerActions;

import game.board.RoundManager;
import game.generals.Vector2;
import gui.actionListener.ListenerBaseData;
import gui.actionListener.turnOffButtons;
import gui.views.gamePanel.MainPanelGame;
import game.interfaceWarhammer.AttributeEnum.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static game.interfaceWarhammer.ActionsEnum.*;
import static game.interfaceWarhammer.AttributeEnum.HEALTH_POINTS_NOW;

public class AttackListener implements ActionListener {
    private final ListenerBaseData listenerBaseData;

    public AttackListener(ListenerBaseData listenerBaseData) {
        this.listenerBaseData = listenerBaseData;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Vector2 point = listenerBaseData.roundManager.getGameObjectWithTurnPosition();
        ArrayList<String> popUp = new ArrayList<>();
        var roundManager = listenerBaseData.roundManager;
        roundManager.getActions().doAction(ATTACK, roundManager.getGameObjectWithTurn().getCreature(),
                roundManager.getBoard().getPlace(point).getGameObject().getCreature(), popUp);

        listenerBaseData.mainPanelGame.getGamePanel().setInformationPanelText(popUp);
        turnOffButtons.turnOff(roundManager, listenerBaseData.mainPanelGame, 0, 2);

    }
}
