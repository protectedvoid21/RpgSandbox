package game.equipment.examples;

import game.equipment.DisposableItem;
import game.interfaceWarhammer.EffectEnum;
import game.interfaces.Statistics;
import game.creature.Character;

public class Bandage extends DisposableItem {
    private Character user;

    public Bandage(Statistics stats, int usageCount, Character user) {
        super(usageCount);
        this.user=user;
    }

    @Override
    public void use() {
        super.use();

        user.getStatistics().getEffect(EffectEnum.BLEEDING).decreaseLength();
    }
}
