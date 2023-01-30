package gui.actionListener.warhammerActions;

import game.generals.Vector2;
import game.interfaceWarhammer.StruggleAtributeEnum;
import gui.actionListener.ListenerBaseData;
import gui.actionListener.turnOffButtons;
import gui.views.gamePanel.gamePanels.GamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static game.interfaceWarhammer.ActionsEnum.MULTIPLE_ATTACK;

public class MultipleAttackListener extends BaseAttackAction implements ActionListener {

    private final ListenerBaseData listenerBaseData;

    public MultipleAttackListener(ListenerBaseData listenerBaseData) {
        this.listenerBaseData = listenerBaseData;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var mainPanelGame = listenerBaseData.mainPanelGame;
        var roundManager = listenerBaseData.roundManager;

        Vector2 point = mainPanelGame.getGamePanel().getCurrentClickedIndexes();
        ArrayList<String> popUp = new ArrayList<>();
        var enemy = roundManager.getBoard().getPlace(point).getGameObject().getCreature();
        roundManager.getActions().doAction(MULTIPLE_ATTACK, roundManager.getGameObjectWithTurn().getCreature(),
                roundManager.getBoard().getPlace(point).getGameObject().getCreature(), popUp);
        listenerBaseData.mainPanelGame.getGamePanel().applyAttackActionsContent(point);

        if (enemy.getStruggleStatistics().getAttribute(StruggleAtributeEnum.IS_BLOKING).getValue() == 0) {
            dotTimeActivity(1500, e1 -> listenerBaseData.mainPanelGame.getGamePanel().removeActionContent(point,
                    GamePanel.ActionsLabelsType.DEFEND));
        }
        dotTimeActivity(1000, e1 -> listenerBaseData.mainPanelGame.getGamePanel().removeActionContent(point,
                GamePanel.ActionsLabelsType.ATACK));
        mainPanelGame.getGamePanel().setInformationPanelText(popUp);
        turnOffButtons.turnOff(roundManager, mainPanelGame, 0, 4);

    }
}
