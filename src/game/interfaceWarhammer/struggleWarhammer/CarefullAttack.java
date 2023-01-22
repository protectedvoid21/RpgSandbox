package game.interfaceWarhammer.struggleWarhammer;
import game.creature.Creature;
import game.struggle.Action;
import game.struggle.Dice;
import game.struggle.DmgCalculator;
import game.struggle.Test;

import java.util.ArrayList;

import static game.interfaceWarhammer.AttributeEnum.*;
import static game.interfaceWarhammer.DependantEnum.TOUGHNESS_BONUS;
import static game.interfaceWarhammer.StruggleAtributeEnum.*;
import static game.interfaceWarhammer.DependantEnum.STRENGTH_BONUS;

public class CarefullAttack extends Action {

    private  int actionCost = 2;
    private boolean effectOnEnemy = true;
    private boolean needBeCharacter = false;

    public void doAction(Creature you, Creature enemy, ArrayList<String> popUp) {
        int dmg;
        if (Test.test(you.getStatistics().getAttribute(WEAPON_SKILL).getValue(),-10)){

            if (enemy.getStruggleStatistics().getAttribute(IS_BLOKING).getValue() == 1){
                if(Test.test(enemy.getStatistics().getAttribute(WEAPON_SKILL).getValue(),enemy.getStruggleStatistics().getAttribute(IS_IN_DEFENSE_STAND).getValue() * 10)){
                    popUp.add("Enemy Blocked");
                } else {
                    DmgCalculator.dealDMG(you,enemy,popUp);

                }

                enemy.getStruggleStatistics().getAttribute(IS_BLOKING).setValue(0);

            } else {
                DmgCalculator.dealDMG(you,enemy,popUp);

                }
            } else {
            popUp.add("You missed");
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
