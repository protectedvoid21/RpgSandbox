package game.interfaceWarhammer.struggleWarhammer;
import game.creature.Creature;
import game.struggle.Action;
import game.struggle.Dice;
import game.struggle.DmgCalculator;
import game.struggle.Test;

import static game.interfaceWarhammer.AttributeEnum.*;
import static game.interfaceWarhammer.DependantEnum.TOUGHNESS_BONUS;
import static game.interfaceWarhammer.StruggleAtributeEnum.*;
import static game.interfaceWarhammer.DependantEnum.STRENGTH_BONUS;

public class CarefullAttack extends Action {

    private  int actionCost = 2;
    private boolean effectOnEnemy = true;
    private boolean needBeCharacter = false;

    public void doAction(Creature you, Creature enemy) {
        int dmg = 0;
        if (Test.test(you.getStatistics().getAttribute(WEAPON_SKILL).getValue(),-10)){
            if (enemy.getStruggleStatistics().getAttribute(IS_BLOKING).getValue() == 1){
                if(Test.test(you.getStatistics().getAttribute(WEAPON_SKILL).getValue(),you.getStruggleStatistics().getAttribute(IS_IN_DEFENSE_STAND).getValue() * 10)){
                    // Pudło
                } else {
                    DmgCalculator.dealDMG(you,enemy);
                }

                enemy.getStruggleStatistics().getAttribute(IS_BLOKING).setValue(0);

            } else {
               DmgCalculator.dealDMG(you,enemy);
                }
            }

        you.getStruggleStatistics().getAttribute(IS_BLOKING).setValue(1);
        you.getStruggleStatistics().getAttribute(IS_IN_DEFENSE_STAND).setValue(1);
        you.getStruggleStatistics().getAttribute(ACTIONS_TO_DO).decreaseValue(actionCost);
    }


    public int getActionCost() {
        return actionCost;
    }

    public boolean isEffectOnEnemy() {
        return effectOnEnemy;
    }

    public boolean isNeedBeCharacter() {
        return needBeCharacter;
    }
}
