package gui.actionListener.warhammer;

import game.board.RoundManager;
import game.creature.Creature;
import game.generals.Vector2;
import gui.views.Point;
import gui.views.gamePanel.gamePanels.BaseGamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveListener implements ActionListener {

    RoundManager roundManager;
    BaseGamePanel baseGamePanel;

    public MoveListener(RoundManager roundManager, BaseGamePanel baseGamePanel) {
        this.roundManager = roundManager;
        this.baseGamePanel = baseGamePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Point point = baseGamePanel.getCurrentClickedIndexes();
        Creature you = roundManager.getGameObjectWithTurn().getCreature();
        Vector2 vector2 = null;
        
        boolean founded = false;
        for(int i = 0; i<roundManager.getBoard().getHeigt();i++){
            for(int j = 0; j<roundManager.getBoard().getWidth();i++){
                if(roundManager.getBoard().getPlace(new Vector2(j,i)).getGameObject().getCreature().equals(you)){
                    vector2 = new Vector2(j,i);
                }
            }
        }
        
        
        roundManager.getBoard().move(vector2,new Vector2(point.x, point.y));

    }
}

