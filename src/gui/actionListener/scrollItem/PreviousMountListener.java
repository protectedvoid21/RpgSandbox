package gui.actionListener.scrollItem;

import game.board.RoundManager;
import game.creature.Character;
import gui.views.pickers.CustomLambdaExpression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreviousMountListener implements CustomLambdaExpression {

    RoundManager roundManager;

    public PreviousMountListener(RoundManager roundManager){
        this.roundManager = roundManager;
    }

    @Override
    public void apply() {
        if (roundManager.getGameObjectWithTurn().getCreature() instanceof Character){
            ((Character) roundManager.getGameObjectWithTurn().getCreature()).getInventory().previousMount();
        }
    }
}
