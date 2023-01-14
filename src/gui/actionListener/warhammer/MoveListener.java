package gui.actionListener.warhammer;

import game.board.RoundManager;
import game.creature.Creature;
import game.generals.Vector2;
import gui.actionListener.turnOffButtons;
import gui.views.Point;
import gui.views.gamePanel.MainPanelGame;
import gui.views.gamePanel.gamePanels.BaseGamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static game.interfaceWarhammer.StruggleAtributeEnum.*;

public class MoveListener implements ActionListener {

    RoundManager roundManager;
    MainPanelGame mainPanelGame;

    public MoveListener(RoundManager roundManager, MainPanelGame mainPanelGame) {
        this.roundManager = roundManager;
        this.mainPanelGame = mainPanelGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Point point = mainPanelGame.getGamePanel().getCurrentClickedIndexes();
        Creature you = roundManager.getGameObjectWithTurn().getCreature();
        Vector2 vector2 = null;

        for(int i = 0; i<roundManager.getBoard().getHeigt();i++){
            for(int j = 0; j<roundManager.getBoard().getWidth();i++){
                if(roundManager.getBoard().getPlace(new Vector2(j,i)).getGameObject().getCreature().equals(you)){
                    vector2 = new Vector2(j,i);
                }
            }
        }
        
        
        roundManager.getBoard().move(vector2,new Vector2(point.x, point.y));
        roundManager.getGameObjectWithTurn().getCreature().getStruggleStatistics().getAttribute(ACTIONS_TO_DO).decreaseValue(1);

        turnOffButtons.turnOff(roundManager,mainPanelGame,0,0);
    }
}

