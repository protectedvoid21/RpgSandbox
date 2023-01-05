package game.interfaceWarhammer.struggleWarhammer;

import game.creature.Creature;
import game.struggle.Action;
import static game.interfaceWarhammer.AttributeEnum.*;
import static game.interfaceWarhammer.StruggleAtributeEnum.*;

public class MultipleAttack extends Attack {

    @Override
    public void doAction(Creature you, Creature enemy) {
        for (int i = 0; i < you.getStatistics().getAttribute(ATTACKS).getValue(); i++){
            super.doAction(you, enemy);
        }

        you.getStruggleStatistics().getAttribute(ACTIONS_TO_DO).setValue(0);
    }
}
