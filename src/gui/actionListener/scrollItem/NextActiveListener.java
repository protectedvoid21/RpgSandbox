package gui.actionListener.scrollItem;

import game.board.RoundManager;
import game.creature.Character;
import gui.actionListener.ListenerBaseData;
import gui.actionListener.ValidatorItemListener;
import gui.views.pickers.CustomLambdaExpression;

public class NextActiveListener implements CustomLambdaExpression {

    ListenerBaseData data;

    public NextActiveListener(ListenerBaseData data){
        this.data = data;
    }

    @Override
    public void apply() {
        if (data.roundManager.getGameObjectWithTurn().getCreature() instanceof Character creature){
            creature.getInventory().nextDisposableItem();
            ValidatorItemListener.setValid(creature, data);
        }
    }
}
