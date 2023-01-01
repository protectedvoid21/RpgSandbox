package game.interfaceWarhammer.struggleWarhammer;

import game.creature.Creature;
import game.struggle.Action;

import static game.interfaceWarhammer.AttributeEnum.*;

public class Aiming extends Action {

    @Override
    public  void doAction(Creature you) {
        if (0 == you.getStatistics().getAttribute(IS_AIMING).getValue()) {
            you.getStatistics().getAttribute(IS_AIMING).setValue(1);
            you.getStatistics().getAttribute(ACTIONS_TO_DO).decreaseValue(1);
        } // else do zrobienia w gui
    }
}
