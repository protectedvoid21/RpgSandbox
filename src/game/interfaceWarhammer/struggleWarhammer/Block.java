package game.interfaceWarhammer.struggleWarhammer;

import game.creature.Creature;
import game.struggle.Action;
import static game.interfaceWarhammer.AttributeEnum.*;

public class Block extends Action {

    @Override
    public void doAction(Creature you) {
            you.getStatistics().getAttribute(IS_BLOKING).setValue(1);
            you.getStatistics().getAttribute(ACTIONS_TO_DO).decreaseValue(1);


    }
}
