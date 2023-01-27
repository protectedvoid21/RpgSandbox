package game.equipment.examples;

import controllers.audio.WarhammerEnumAudio;
import game.creature.Character;
import game.creature.Creature;
import game.equipment.DisposableItem;
import game.interfaceWarhammer.EffectEnum;
import gui.factories.WarhammerData;

import static game.interfaceWarhammer.AttributeEnum.HEALTH_POINTS_MAX;
import static game.interfaceWarhammer.AttributeEnum.HEALTH_POINTS_NOW;

public class ChickenLeg extends DisposableItem implements WarhammerData {
    //    private Character user;
    public ChickenLeg(int usageCount) {
        super(usageCount);
//        this.user = user;
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
