package gui.actionListener.warhammerActions;

import game.board.RoundManager;
import game.creature.Creature;
import game.generals.Vector2;
import gui.actionListener.ListenerBaseData;
import gui.actionListener.turnOffButtons;
import gui.views.gamePanel.MainPanelGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.interfaceWarhammer.ActionsEnum.*;

public class AimingListener implements ActionListener {
    private final ListenerBaseData listenerBaseData;

    public AimingListener(ListenerBaseData listenerBaseData) {
        this.listenerBaseData = listenerBaseData;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Creature you = listenerBaseData.roundManager.getGameObjectWithTurn().getCreature();
        listenerBaseData.roundManager.getActions().doAction(AIMING, you);
        turnOffButtons.turnOff(listenerBaseData.roundManager, listenerBaseData.mainPanelGame, 1, 0);
    }
}
