package game.struggle;

import game.creature.Character;
import game.creature.Creature;

import static game.interfaceWarhammer.AttributeEnum.HEALTH_POINTS_NOW;
import static game.interfaceWarhammer.DependantEnum.STRENGTH_BONUS;
import static game.interfaceWarhammer.DependantEnum.TOUGHNESS_BONUS;

public class DmgCalculator {

    public static int dealDMG(Creature you, Creature enemy){

        int dmg = Dice.roll(1,10) + you.getStatistics().getDependantAttrValue(STRENGTH_BONUS) - enemy.getStatistics().getDependantAttrValue(TOUGHNESS_BONUS);

        if(you instanceof Character){
            dmg += ((Character) you).getInventory().getActiveWeapon().getDamage();
        }

        if(enemy instanceof  Character){
            dmg -= ((Character) enemy).getInventory().getActiveArmor().getDefence();
        }

        if (dmg>0) {
            enemy.getStatistics().getAttribute(HEALTH_POINTS_NOW).decreaseValue(dmg);
        }

        if(you instanceof Character){
            ((Character) you).getInventory().getActiveWeapon().effected(enemy);
        }

        return dmg;
    }

}
