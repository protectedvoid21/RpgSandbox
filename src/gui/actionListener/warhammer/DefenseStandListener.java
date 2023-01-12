package gui.actionListener.warhammer;

import game.board.RoundManager;
import game.creature.Creature;
import gui.views.Point;
import gui.views.gamePanel.gamePanels.BaseGamePanel;
import gui.views.gamePanel.gamePanels.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.interfaceWarhammer.ActionsEnum.BLOCK;
import static game.interfaceWarhammer.ActionsEnum.DEFENSE_STAND;

public class DefenseStandListener implements ActionListener {

    RoundManager roundManager;
    BaseGamePanel baseGamePanel;

    public DefenseStandListener(RoundManager roundManager, BaseGamePanel baseGamePanel) {
        this.roundManager = roundManager;
        this.baseGamePanel = baseGamePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Point point = baseGamePanel.getCurrentClickedIndexes();
        Creature you = roundManager.getGameObjectWithTurn().getCreature();
        roundManager.getActions().doAction(DEFENSE_STAND, you);
        if (baseGamePanel instanceof GamePanel) {
            ((GamePanel) baseGamePanel).applyDefendActionsContent(point);
        }
    }
}