package game.equipment.examples;

import game.creature.Character;
import game.equipment.DisposableItem;
import game.interfaceWarhammer.EffectEnum;

public class JustNormalWater extends DisposableItem {
    private Character user;

    public JustNormalWater(int usageCount, Character user) {
        super(usageCount);
        this.user=user;

        description = "Like the name JUST NORMAL WATER! You can use it to stop fire or sth";
    }

    @Override
    public void use() {
        super.use();

        user.getStatistics().getEffect(EffectEnum.IN_FIRE).decreaseLength();
    }
}
