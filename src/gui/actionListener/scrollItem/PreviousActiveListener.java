package gui.actionListener.scrollItem;

import game.board.RoundManager;
import game.creature.Character;
import gui.actionListener.ListenerBaseData;
import gui.actionListener.ValidatorItemListener;
import gui.views.pickers.CustomLambdaExpression;

public class PreviousActiveListener implements CustomLambdaExpression {

    private ListenerBaseData listenerBaseData;

    public PreviousActiveListener(ListenerBaseData listenerBaseData) {
        this.listenerBaseData = listenerBaseData;
    }

    @Override
    public void apply() {
        if (listenerBaseData.roundManager.getGameObjectWithTurn().getCreature() instanceof Character character) {
            character.getInventory().previousDisposableItem();
            ValidatorItemListener.setValid(character, listenerBaseData);
        }
    }
}
