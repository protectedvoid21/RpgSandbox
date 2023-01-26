package gui.actionListener.warhammerActions;

import game.board.RoundManager;
import game.generals.Vector2;
import gui.actionListener.ListenerBaseData;
import gui.actionListener.turnOffButtons;
import gui.views.gamePanel.MainPanelGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static game.interfaceWarhammer.ActionsEnum.*;

public class CarefullListener implements ActionListener {

    private ListenerBaseData listenerBaseData;

    public CarefullListener(ListenerBaseData listenerBaseData) {
//        this.roundManager = roundManager;
//        this.mainPanelGame = mainPanelGame;
        this.listenerBaseData = listenerBaseData;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var mainPanelGame = listenerBaseData.mainPanelGame;
        var roundManager = listenerBaseData.roundManager;

        Vector2 point = mainPanelGame.getGamePanel().getCurrentClickedIndexes();
        ArrayList<String> popUp = new ArrayList<>();
        roundManager.getActions().doAction(CAREFULL_ATTACK, roundManager.getGameObjectWithTurn().getCreature(),
                roundManager.getBoard().getPlace(point).getGameObject().getCreature(), popUp);
        mainPanelGame.getGamePanel().setInformationPanelText(popUp);
        turnOffButtons.turnOff(roundManager, mainPanelGame, 0, 3);
    }
}
