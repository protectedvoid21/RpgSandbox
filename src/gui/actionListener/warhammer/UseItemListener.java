package gui.actionListener.warhammer;

import game.board.RoundManager;
import game.creature.Creature;
import game.generals.Vector2;
import gui.views.gamePanel.gamePanels.BaseGamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static game.interfaceWarhammer.ActionsEnum.*;
public class UseItemListener implements ActionListener {

    RoundManager roundManager;
    BaseGamePanel baseGamePanel;

    public UseItemListener(RoundManager roundManager, BaseGamePanel baseGamePanel) {
        this.roundManager = roundManager;
        this.baseGamePanel = baseGamePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Vector2 point = baseGamePanel.getCurrentClickedIndexes();
        Creature you = roundManager.getGameObjectWithTurn().getCreature();

    }
}
