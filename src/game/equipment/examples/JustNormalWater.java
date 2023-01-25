package game.equipment.examples;

import game.creature.Character;
import game.equipment.DisposableItem;
import game.interfaceWarhammer.EffectEnum;
import gui.factories.WarhammerData;

public class JustNormalWater extends DisposableItem implements WarhammerData {
    private Character user;

    public JustNormalWater(String name, int usageCount, Character user) {
        super(name, usageCount);
        this.user=user;setItemPathPicture(waterPath);

        description = "Like the name JUST NORMAL WATER! You can use it to stop fire or sth";
    }

    @Override
    public void use() {
        super.use();

        user.getStatistics().getEffect(EffectEnum.IN_FIRE).decreaseLength();
    }
}
