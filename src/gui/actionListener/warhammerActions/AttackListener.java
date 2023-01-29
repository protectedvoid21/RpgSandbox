package gui.actionListener.warhammerActions;

import game.board.RoundManager;
import game.generals.Vector2;
import game.interfaceWarhammer.StruggleAtributeEnum;
import gui.actionListener.ListenerBaseData;
import gui.actionListener.turnOffButtons;
import gui.views.gamePanel.MainPanelGame;
import game.interfaceWarhammer.AttributeEnum.*;
import gui.views.gamePanel.gamePanels.GamePanel;

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
        Vector2 point = listenerBaseData.mainPanelGame.getGamePanel().getCurrentClickedIndexes();
        ArrayList<String> popUp = new ArrayList<>();
        var roundManager = listenerBaseData.roundManager;
        var enemy = roundManager.getBoard().getPlace(point).getGameObject().getCreature();
        roundManager.getActions().doAction(ATTACK, roundManager.getGameObjectWithTurn().getCreature(),
                enemy, popUp);

        if(enemy.getStruggleStatistics().getAttribute(StruggleAtributeEnum.IS_BLOKING).getValue()==0){
            listenerBaseData.mainPanelGame.getGamePanel().removeActionContent(point, GamePanel.ActionsLabelsType.DEFEND);
        }

        listenerBaseData.mainPanelGame.getGamePanel().setInformationPanelText(popUp);
        turnOffButtons.turnOff(roundManager, listenerBaseData.mainPanelGame, 0, 2);

    }
}
