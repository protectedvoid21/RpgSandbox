package game.struggle;

import game.creature.Character;
import game.creature.Creature;
import gui.bundle.CustomBundle;
import gui.data.WarhammerData;

import java.util.ArrayList;

import static game.interfaceWarhammer.AttributeEnum.HEALTH_POINTS_NOW;
import static game.interfaceWarhammer.DependantEnum.STRENGTH_BONUS;
import static game.interfaceWarhammer.DependantEnum.TOUGHNESS_BONUS;

public class DmgCalculator implements WarhammerData {

    public static int dealDMG(Creature you, Creature enemy, ArrayList<String> popUp){

        int dmg = Dice.roll(1,10) + you.getStatistics().getDependantAttrValue(STRENGTH_BONUS) - enemy.getStatistics().getDependantAttrValue(TOUGHNESS_BONUS);

        if(you instanceof Character){
            dmg += ((Character) you).getInventory().getActiveWeapon().getDamage();
        }

        if(enemy instanceof  Character){
            dmg -= ((Character) enemy).getInventory().getActiveArmor().getDefence();
        }

        if (dmg>0) {
            enemy.getStatistics().getAttribute(HEALTH_POINTS_NOW).decreaseValue(dmg);
            popUp.add(CustomBundle.getSpecificString(dealtInformation)+" " + dmg + " "+CustomBundle.getSpecificString(dmgInformation));
        } else {
            popUp.add("You dealt 0 Dmg");
        }


        if(you instanceof Character){
            ((Character) you).getInventory().getActiveWeapon().effected(enemy,popUp);
        }

        return dmg;
    }

}
