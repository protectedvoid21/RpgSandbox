package gui.actionListener.warhammer;

import game.board.RoundManager;
import game.creature.Creature;
import game.generals.Vector2;
import gui.views.Point;
import gui.views.gamePanel.gamePanels.BaseGamePanel;
import gui.views.gamePanel.gamePanels.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.interfaceWarhammer.ActionsEnum.*;
import static game.interfaceWarhammer.AttributeEnum.*;
public class CarefullListener implements ActionListener {

    RoundManager roundManager;
    BaseGamePanel baseGamePanel;

    public CarefullListener(RoundManager roundManager, BaseGamePanel baseGamePanel) {
        this.roundManager = roundManager;
        this.baseGamePanel = baseGamePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Point point = baseGamePanel.getCurrentClickedIndexes();
        roundManager.getActions().doAction(CAREFULL_ATTACK, roundManager.getGameObjectWithTurn().getCreature(), roundManager.getBoard().getPlace(new Vector2(point.x, point.y)).getGameObject().getCreature());
        if (baseGamePanel instanceof GamePanel) {
                ((GamePanel) baseGamePanel).applyAttackActionsContent(point);
        }
    }
}
