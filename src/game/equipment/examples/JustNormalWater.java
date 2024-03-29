package game.equipment.examples;

import controllers.audio.WarhammerEnumAudio;
import game.creature.Creature;
import game.equipment.DisposableItem;
import game.interfaceWarhammer.EffectEnum;
import gui.data.WarhammerData;

public class JustNormalWater extends DisposableItem implements WarhammerData {

    public JustNormalWater(int usageCount) {
        super(usageCount);
        setItemPathPicture(waterPath);
        enumAudio = WarhammerEnumAudio.WATER;
        workOnEnemy = false;
        description = "Like the name JUST NORMAL WATER! You can use it to stop fire or sth";
    }

    @Override
    public void use(Creature creature) {
        super.use(creature);

        creature.getStatistics().getEffect(EffectEnum.IN_FIRE).decreaseLength();
    }
}
