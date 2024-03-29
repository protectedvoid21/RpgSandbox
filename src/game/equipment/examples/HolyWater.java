package game.equipment.examples;

import static game.interfaceWarhammer.AttributeEnum.HEALTH_POINTS_NOW;

import controllers.audio.WarhammerEnumAudio;
import game.creature.Creature;
import game.creature.Monster;
import game.equipment.DisposableItem;
import gui.data.WarhammerData;

public class HolyWater extends DisposableItem implements WarhammerData {

    public HolyWater(int usageCount) {
        super(usageCount);
        setItemPathPicture(holyWaterPath);
        enumAudio = WarhammerEnumAudio.HOLY;

        description = "Paladyn Edward claims that it works against monsters";
        workOnEnemy = true;

    }

    public void use(Creature enemy) {
        super.use(enemy);

        if (enemy instanceof Monster) {
            enemy.getStatistics().getAttribute(HEALTH_POINTS_NOW).decreaseValue(3);
        }
    }
}
