package game.equipment.examples;

import game.creature.Character;
import game.equipment.DisposableItem;
import game.interfaceWarhammer.EffectEnum;

public class WarmSocksFromGrandma extends DisposableItem {
    private Character user;

    public WarmSocksFromGrandma(String name, int usageCount, Character user) {
        super(name, usageCount);
        this.user=user;

        description = "When you found them under christmas tree you said: \"MEEEEH\", but then you found out that they protect from freezing effect";
    }

    @Override
    public void use() {
        super.use();

        user.getStatistics().getEffect(EffectEnum.FREEZING).decreaseLength();
    }
}
