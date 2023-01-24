package gui.actionListener.scrollItem;

import game.board.RoundManager;
import game.creature.Character;
import gui.views.pickers.CustomLambdaExpression;

public class NextActiveListener implements CustomLambdaExpression {

    RoundManager roundManager;

    public NextActiveListener(RoundManager roundManager){
        this.roundManager = roundManager;
    }

    @Override
    public void apply() {
        if (roundManager.getGameObjectWithTurn().getCreature() instanceof Character){
            ((Character) roundManager.getGameObjectWithTurn().getCreature()).getInventory().nextDisposableItem();
        }
    }
}
