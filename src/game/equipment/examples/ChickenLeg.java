package game.equipment.examples;

import game.creature.Character;
import game.equipment.DisposableItem;
import game.interfaceWarhammer.EffectEnum;

import static game.interfaceWarhammer.AttributeEnum.HEALTH_POINTS_MAX;
import static game.interfaceWarhammer.AttributeEnum.HEALTH_POINTS_NOW;

public class ChickenLeg extends DisposableItem {
    private Character user;

    public ChickenLeg(String name, int usageCount, Character user) {
        super(name, usageCount);
        this.user=user;
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
