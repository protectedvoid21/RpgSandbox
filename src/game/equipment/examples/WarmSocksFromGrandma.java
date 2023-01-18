package game.equipment.examples;

import game.creature.Character;
import game.equipment.DisposableItem;
import game.interfaceWarhammer.EffectEnum;

public class WarmSocksFromGrandma extends DisposableItem {
    private Character user;

    public WarmSocksFromGrandma(int usageCount, Character user) {
        super(usageCount);
        this.user=user;
    }

    @Override
    public void use() {
        super.use();

        user.getStatistics().getEffect(EffectEnum.FREEZING).decreaseLength();
    }
}
