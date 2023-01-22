package game.equipment.examples;

import game.equipment.DisposableItem;
import game.interfaceWarhammer.EffectEnum;
import game.creature.Character;

public class Bandage extends DisposableItem {
    private Character user;

    public Bandage(String name, Character user, int usageCount) {
        super(name, usageCount);
        this.user=user;

        description = "Bandage is great way to stop the bleeding! And yes! We have also kids version with dragons and warriors on it!";
    }

    @Override
    public void use() {
        super.use();

        user.getStatistics().getEffect(EffectEnum.BLEEDING).decreaseLength();
    }
}
