package gui.actionListener.warhammer;

import game.board.RoundManager;
import game.creature.Creature;
import gui.views.Point;
import gui.views.gamePanel.gamePanels.BaseGamePanel;
import gui.views.gamePanel.gamePanels.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static game.interfaceWarhammer.ActionsEnum.*;
import static game.interfaceWarhammer.AttributeEnum.ATTACKS;

public class BlockListener implements ActionListener {

    RoundManager roundManager;
    BaseGamePanel baseGamePanel;

    public BlockListener(RoundManager roundManager, BaseGamePanel baseGamePanel) {
        this.roundManager = roundManager;
        this.baseGamePanel = baseGamePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Point point = baseGamePanel.getCurrentClickedIndexes();
        Creature you = roundManager.getGameObjectWithTurn().getCreature();
        roundManager.getActions().doAction(BLOCK, you);
        if (baseGamePanel instanceof GamePanel) {
                ((GamePanel) baseGamePanel).applyDefendActionsContent(point);

        }
    }
}