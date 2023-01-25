package game.equipment.examples;

import static game.interfaceWarhammer.AttributeEnum.HEALTH_POINTS_NOW;

import game.creature.Creature;
import game.creature.Monster;
import game.equipment.DisposableItem;

public class HolyWater extends DisposableItem {

    public HolyWater(String name, int usageCount) {
        super(name, usageCount);
        
         description = "Paladyn Edward claims that it works against monsters";

    }

    public void use(Creature enemy) {
        super.use();

        if (enemy instanceof Monster) {
            enemy.getStatistics().getAttribute(HEALTH_POINTS_NOW).decreaseValue(3);
        }
    }
}
