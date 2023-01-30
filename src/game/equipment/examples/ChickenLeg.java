package game.equipment.examples;

import controllers.audio.WarhammerEnumAudio;
import game.creature.Creature;
import game.equipment.DisposableItem;
import gui.data.WarhammerData;

import static game.interfaceWarhammer.AttributeEnum.HEALTH_POINTS_MAX;
import static game.interfaceWarhammer.AttributeEnum.HEALTH_POINTS_NOW;

public class ChickenLeg extends DisposableItem implements WarhammerData {
    public ChickenLeg(int usageCount) {
        super(usageCount);
        setItemPathPicture(chickenPath);
        enumAudio = WarhammerEnumAudio.EATING;
        workOnEnemy = false;

        description = "Traveller! Stop in our tavern and eat some chicken. It will help to restore your health";
    }

    @Override
    public void use(Creature creature) {
        super.use(creature);

        creature.getStatistics().getAttribute(HEALTH_POINTS_NOW).increaseValue(5);

        if (creature.getStatistics().getAttribute(HEALTH_POINTS_NOW).getValue() > creature.getStatistics().getAttribute(HEALTH_POINTS_MAX).getValue()) {
            creature.getStatistics().getAttribute(HEALTH_POINTS_NOW).setValue(creature.getStatistics().getAttribute(HEALTH_POINTS_MAX).getValue());
        }
    }
}
