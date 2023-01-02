package game.interfaceWarhammer.struggleWarhammer;

import game.creature.Creature;
import game.struggle.Action;

import static game.interfaceWarhammer.AttributeEnum.*;

public class DefenseStand extends Action {

    @Override
    public  void doAction(Creature you, Creature enemy) {
        if (you.getStatistics().getAttribute(ACTIONS_TO_DO).getValue() == 2) {
            you.getStatistics().getAttribute(IS_BLOKING).setValue(1);
            you.getStatistics().getAttribute(IS_IN_DEFENSE_STAND).setValue(1);
            you.getStatistics().getAttribute(ACTIONS_TO_DO).setValue(0);
        }
    }

}
