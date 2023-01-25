package game.equipment.examples;

import game.creature.Character;
import game.equipment.DisposableItem;
import game.interfaceWarhammer.EffectEnum;
import gui.factories.WarhammerData;

import static game.interfaceWarhammer.AttributeEnum.HEALTH_POINTS_MAX;
import static game.interfaceWarhammer.AttributeEnum.HEALTH_POINTS_NOW;

public class ChickenLeg extends DisposableItem implements WarhammerData {
    private Character user;
    boolean onEnemy = false;

    public ChickenLeg(String name, int usageCount, Character user) {
        super(name, usageCount);
        this.user=user;setItemPathPicture(chickenPath);

        description = "Traveller! Stop in our tavern and eat some chicken. It will help to restore your health";
    }

    @Override
    public void use() {
        super.use();

        user.getStatistics().getAttribute(HEALTH_POINTS_NOW).increaseValue(5);

        if(user.getStatistics().getAttribute(HEALTH_POINTS_NOW).getValue()>user.getStatistics().getAttribute(HEALTH_POINTS_MAX).getValue())
        {
            user.getStatistics().getAttribute(HEALTH_POINTS_NOW).setValue(user.getStatistics().getAttribute(HEALTH_POINTS_MAX).getValue());
        }
    }
}
