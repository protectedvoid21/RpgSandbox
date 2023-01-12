package gui.actionListener.warhammer;

import game.board.RoundManager;
import game.creature.Creature;
import gui.views.Point;
import gui.views.gamePanel.gamePanels.BaseGamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static game.interfaceWarhammer.ActionsEnum.*;

public class AimingListener implements ActionListener {

    RoundManager roundManager;
    BaseGamePanel baseGamePanel;

    public AimingListener(RoundManager roundManager, BaseGamePanel baseGamePanel) {
        this.roundManager = roundManager;
        this.baseGamePanel = baseGamePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Point point = baseGamePanel.getCurrentClickedIndexes();
        Creature you = roundManager.getGameObjectWithTurn().getCreature();
        roundManager.getActions().doAction(AIMING,you);

    }
}
