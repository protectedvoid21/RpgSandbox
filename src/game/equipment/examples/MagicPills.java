package game.equipment.examples;

import controllers.audio.WarhammerEnumAudio;
import game.creature.Creature;
import game.equipment.DisposableItem;
import game.interfaceWarhammer.EffectEnum;
import gui.data.WarhammerData;

public class MagicPills extends DisposableItem implements WarhammerData {
    public MagicPills( int usageCount) {
        super(usageCount);
        setItemPathPicture(mortarPath);
        enumAudio = WarhammerEnumAudio.PILL;

        workOnEnemy = false;
        description = "9/10 dentists says that they will remove poison effects from your blood";
    }

    @Override
    public void use(Creature creature) {
        super.use(creature);

        creature.getStatistics().getEffect(EffectEnum.POISON).decreaseLength();
    }
}
