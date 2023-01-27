package gui.actionListener.basicActionsListener;

import game.creature.Creature;
import game.generals.Vector2;
import gui.actionListener.ListenerBaseData;
import gui.actionListener.turnOffButtons;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.interfaceWarhammer.StruggleAtributeEnum.ACTIONS_TO_DO;

public class MoveListener implements ActionListener {
    private final ListenerBaseData listenerBaseData;

    public MoveListener(ListenerBaseData listenerBaseData) {
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

