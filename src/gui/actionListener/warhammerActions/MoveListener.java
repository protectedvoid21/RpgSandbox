package gui.actionListener.warhammerActions;

import game.board.RoundManager;
import game.creature.Creature;
import game.generals.Vector2;
import gui.actionListener.turnOffButtons;
import gui.views.gamePanel.MainPanelGame;

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

        Vector2 point = mainPanelGame.getGamePanel().getCurrentClickedIndexes();
        Creature you = roundManager.getGameObjectWithTurn().getCreature();
        Vector2 vector2 = roundManager.getGameObjectWithTurnPosition();

        
        roundManager.getBoard().move(vector2,point);
        roundManager.getGameObjectWithTurn().getCreature().getStruggleStatistics().getAttribute(ACTIONS_TO_DO).decreaseValue(1);

        turnOffButtons.turnOff(roundManager,mainPanelGame,0,0);
    }
}

