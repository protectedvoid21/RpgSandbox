package game.interfaceWarhammer.struggleWarhammer;

import game.creature.Creature;
import game.struggle.Action;

import static game.interfaceWarhammer.StruggleAtributeEnum.*;

public class DefenseStand extends Action {

    @Override
    public  void doAction(Creature you, Creature enemy) {
        if (you.getStruggleStatistics().getAttribute(ACTIONS_TO_DO).getValue() == 2) {
            you.getStruggleStatistics().getAttribute(IS_BLOKING).setValue(1);
            you.getStruggleStatistics().getAttribute(IS_IN_DEFENSE_STAND).setValue(1);
            you.getStruggleStatistics().getAttribute(ACTIONS_TO_DO).setValue(0);
        }
    }

}
