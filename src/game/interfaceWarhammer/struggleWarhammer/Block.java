package game.interfaceWarhammer.struggleWarhammer;

import game.creature.Creature;
import game.struggle.Action;
import static game.interfaceWarhammer.StruggleAtributeEnum.*;

public class Block extends Action {

    @Override
    public void doAction(Creature you) {
            you.getStruggleStatistics().getAttribute(IS_BLOKING).setValue(1);
            you.getStruggleStatistics().getAttribute(ACTIONS_TO_DO).decreaseValue(1);


    }
}
