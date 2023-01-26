package game.equipment.examples;

import game.creature.Character;
import game.equipment.DisposableItem;
import game.interfaceWarhammer.EffectEnum;
import gui.factories.WarhammerData;

public class WarmSocksFromGrandma extends DisposableItem implements WarhammerData {
    private Character user;

    public WarmSocksFromGrandma(int usageCount, Character user) {
        super( usageCount);
        this.user = user;
        setItemPathPicture(socksPath);

        description = "When you found them under christmas tree you said: \"MEEEEH\", but then you found out that " +
                "they protect from freezing effect";
    }

    @Override
    public void use() {
        super.use();

        user.getStatistics().getEffect(EffectEnum.FREEZING).decreaseLength();
    }
}
