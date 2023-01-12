package gui.actionListener.warhammer;

import game.board.RoundManager;
import game.creature.Creature;
import game.interfaceWarhammer.struggleWarhammer.ChangeEquipment;
import gui.views.Point;
import gui.views.gamePanel.gamePanels.BaseGamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static game.interfaceWarhammer.ActionsEnum.*;
public class ChangeEquipmentListener implements ActionListener {

    RoundManager roundManager;
    BaseGamePanel baseGamePanel;

    public ChangeEquipmentListener(RoundManager roundManager, BaseGamePanel baseGamePanel) {
        this.roundManager = roundManager;
        this.baseGamePanel = baseGamePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Point point = baseGamePanel.getCurrentClickedIndexes();
        Creature you = roundManager.getGameObjectWithTurn().getCreature();

    }
}
