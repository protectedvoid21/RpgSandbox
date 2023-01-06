package game.interfaceWarhammer.struggleWarhammer;
import game.creature.Creature;
import game.struggle.Action;
import game.struggle.Dice;
import game.struggle.Test;

import static game.interfaceWarhammer.AttributeEnum.*;
import static game.interfaceWarhammer.DependantEnum.TOUGHNESS_BONUS;
import static game.interfaceWarhammer.StruggleAtributeEnum.*;
import static game.interfaceWarhammer.DependantEnum.STRENGTH_BONUS;

public class CarefullAttack extends Action {

    public void doAction(Creature you, Creature enemy) {
        int dmg = 0;
        if (Test.test(you.getStatistics().getAttribute(WEAPON_SKILL).getValue(),-10)){
            if (enemy.getStruggleStatistics().getAttribute(IS_BLOKING).getValue() == 1){
                if(Test.test(you.getStatistics().getAttribute(WEAPON_SKILL).getValue(),you.getStruggleStatistics().getAttribute(IS_IN_DEFENSE_STAND).getValue() * 10)){
                    // Pudło
                } else {
                    dmg = Dice.roll(1,10) + you.getStatistics().getDependantAttrValue(STRENGTH_BONUS) - enemy.getStatistics().getDependantAttrValue(TOUGHNESS_BONUS);
                    if (dmg>0) {
                        enemy.getStatistics().getAttribute(HEALTH_POINTS_NOW).decreaseValue(dmg);
                    }                }

                enemy.getStruggleStatistics().getAttribute(IS_BLOKING).setValue(0);

            } else {
                dmg = Dice.roll(1,10) + you.getStatistics().getDependantAttrValue(STRENGTH_BONUS) - enemy.getStatistics().getDependantAttrValue(TOUGHNESS_BONUS);
                if (dmg>0) {
                    enemy.getStatistics().getAttribute(HEALTH_POINTS_NOW).decreaseValue(dmg);
                }
            }
        }

        you.getStruggleStatistics().getAttribute(IS_BLOKING).setValue(1);
        you.getStruggleStatistics().getAttribute(IS_IN_DEFENSE_STAND).setValue(1);
        you.getStruggleStatistics().getAttribute(ACTIONS_TO_DO).decreaseValue(2);
    }
}
