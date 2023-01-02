package game.interfaceWarhammer.struggleWarhammer;

import game.creature.Creature;
import game.struggle.Action;
import game.struggle.Dice;
import game.struggle.Test;

import static game.interfaceWarhammer.AttributeEnum.*;
import static game.interfaceWarhammer.DependantEnum.*;
public class Attack extends Action {

    @Override
    public void doAction(Creature you, Creature enemy) {
        if (Test.test(you.getStatistics().getAttribute(WEAPON_SKILL).getValue(),you.getStatistics().getAttribute(IS_AIMING).getValue()*10)){
            if (enemy.getStatistics().getAttribute(IS_BLOKING).getValue() == 1){
                if(Test.test(you.getStatistics().getAttribute(WEAPON_SKILL).getValue(),you.getStatistics().getAttribute(IS_IN_DEFENSE_STAND).getValue() * 10)){
                   // Pudło
                } else {
                    enemy.getStatistics().getAttribute(HEALTH_POINTS_NOW).decreaseValue(Dice.roll(1,10) + you.getStatistics().getDependantAttrValue(STRENGTH_BONUS)/* + Bonus broni*/);
                }

                enemy.getStatistics().getAttribute(IS_BLOKING).setValue(0);

            } else {
                enemy.getStatistics().getAttribute(HEALTH_POINTS_NOW).decreaseValue(Dice.roll(1,10) + you.getStatistics().getDependantAttrValue(STRENGTH_BONUS)/* + Bonus broni*/);
            }
        }

        you.getStatistics().getAttribute(IS_AIMING).setValue(0);
        you.getStatistics().getAttribute(ACTIONS_TO_DO).decreaseValue(1);
    }
}
