package game.equipment.examples;

import game.equipment.DisposableItem;
import game.interfaceWarhammer.EffectEnum;
import game.interfaces.Statistics;
import game.creature.Character;

public class Bandage extends DisposableItem {
    private Character user;

    public Bandage(int usageCount, Character user) {
        super(usageCount);
        this.user=user;

        description = "Bandage is great way to stop the bleeding! And yes! We have also kids version with dragons and warriors on it!";
    }

    @Override
    public void use() {
        super.use();

        user.getStatistics().getEffect(EffectEnum.BLEEDING).decreaseLength();
    }
}
