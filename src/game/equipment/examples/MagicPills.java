package game.equipment.examples;

import game.creature.Character;
import game.equipment.DisposableItem;
import game.interfaceWarhammer.EffectEnum;

public class MagicPills extends DisposableItem {
    private Character user;

    public MagicPills(int usageCount, Character user) {
        super(usageCount);
        this.user=user;

        description = "9/10 dentists says that they will remove poison effects from your blood";
    }

    @Override
    public void use() {
        super.use();

        user.getStatistics().getEffect(EffectEnum.POISON).decreaseLength();
    }
}
