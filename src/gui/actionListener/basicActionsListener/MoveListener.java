package gui.actionListener.basicActionsListener;

import game.board.RoundManager;
import game.creature.Creature;
import game.generals.Vector2;
import gui.actionListener.ListenerBaseData;
import gui.actionListener.turnOffButtons;
import gui.views.gamePanel.MainPanelGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static game.interfaceWarhammer.StruggleAtributeEnum.*;

public class MoveListener implements ActionListener {

//   private RoundManager roundManager;
//    MainPanelGame mainPanelGame;
    private ListenerBaseData listenerBaseData;

    public MoveListener(ListenerBaseData listenerBaseData) {
//        this.roundManager = roundManager;
//        this.mainPanelGame = mainPanelGame;
        this.listenerBaseData = listenerBaseData;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Vector2 point = listenerBaseData.mainPanelGame.getGamePanel().getCurrentClickedIndexes();
        Creature you = listenerBaseData.roundManager.getGameObjectWithTurn().getCreature();
        Vector2 vector2 = listenerBaseData.roundManager.getGameObjectWithTurnPosition();

        
        listenerBaseData.roundManager.getBoard().move(vector2,point);
        listenerBaseData.roundManager.getGameObjectWithTurn().getCreature().getStruggleStatistics().getAttribute(ACTIONS_TO_DO).decreaseValue(1);

        turnOffButtons.turnOff(listenerBaseData.roundManager,listenerBaseData.mainPanelGame,0,0);
    }
}

