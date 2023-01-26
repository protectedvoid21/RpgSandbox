package game.equipment.examples;

import game.creature.Character;
import game.creature.Creature;
import game.equipment.DisposableItem;
import game.interfaceWarhammer.EffectEnum;
import gui.factories.WarhammerData;

public class JustNormalWater extends DisposableItem implements WarhammerData {
//    private Character user;

    public JustNormalWater(int usageCount) {
        super(usageCount);
//        this.user = user;
        setItemPathPicture(waterPath);

        workOnEnemy = false;
        description = "Like the name JUST NORMAL WATER! You can use it to stop fire or sth";
    }

    @Override
    public void use(Creature creature) {
        super.use(creature);

        creature.getStatistics().getEffect(EffectEnum.IN_FIRE).decreaseLength();
    }
}
