package game.interfaceWarhammer.struggleWarhammer;

import game.creature.Creature;
import game.struggle.Action;
import game.struggle.Dice;
import game.struggle.Test;

import static game.interfaceWarhammer.AttributeEnum.*;
import static game.interfaceWarhammer.DependantEnum.*;
import static game.interfaceWarhammer.StruggleAtributeEnum.*;
public class Attack extends Action {

    @Override
    public void doAction(Creature you, Creature enemy) {
        int dmg = 0;
        if (Test.test(you.getStatistics().getAttribute(WEAPON_SKILL).getValue(),you.getStruggleStatistics().getAttribute(IS_AIMING).getValue()*10)){
            if (enemy.getStruggleStatistics().getAttribute(IS_BLOKING).getValue() == 1){
                if(Test.test(you.getStatistics().getAttribute(WEAPON_SKILL).getValue(),you.getStruggleStatistics().getAttribute(IS_IN_DEFENSE_STAND).getValue() * 10)){
                   // Pudło
                } else {
                    dmg = Dice.roll(1,10) + you.getStatistics().getDependantAttrValue(STRENGTH_BONUS) - enemy.getStatistics().getDependantAttrValue(TOUGHNESS_BONUS);
                    if (dmg>0) {
                        enemy.getStatistics().getAttribute(HEALTH_POINTS_NOW).decreaseValue(dmg);
                    }
                }

                enemy.getStruggleStatistics().getAttribute(IS_BLOKING).setValue(0);

            } else {
                dmg = Dice.roll(1,10) + you.getStatistics().getDependantAttrValue(STRENGTH_BONUS) - enemy.getStatistics().getDependantAttrValue(TOUGHNESS_BONUS);
                if (dmg>0) {
                    enemy.getStatistics().getAttribute(HEALTH_POINTS_NOW).decreaseValue(dmg);
                }
            }
        }

        you.getStruggleStatistics().getAttribute(IS_AIMING).setValue(0);
        you.getStruggleStatistics().getAttribute(ACTIONS_TO_DO).decreaseValue(1);
    }
}
