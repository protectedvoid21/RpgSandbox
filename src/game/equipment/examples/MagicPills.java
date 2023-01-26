package game.equipment.examples;

import game.creature.Character;
import game.creature.Creature;
import game.equipment.DisposableItem;
import game.interfaceWarhammer.EffectEnum;
import gui.factories.WarhammerData;

public class MagicPills extends DisposableItem implements WarhammerData {
//    private Character user;

    public MagicPills( int usageCount) {
        super(usageCount);
//        this.user=user;
        setItemPathPicture(mortarPath);

        workOnEnemy = false;
        description = "9/10 dentists says that they will remove poison effects from your blood";
    }

    @Override
    public void use(Creature creature) {
        super.use(creature);

        creature.getStatistics().getEffect(EffectEnum.POISON).decreaseLength();
    }
}
