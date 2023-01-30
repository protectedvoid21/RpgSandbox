package game.equipment.examples;

import controllers.audio.DefaultEnumAudio;
import controllers.audio.WarhammerEnumAudio;
import game.creature.Creature;
import game.equipment.DisposableItem;
import game.interfaceWarhammer.EffectEnum;
import gui.data.WarhammerData;

public class Bandage extends DisposableItem implements WarhammerData {
    public Bandage(int usageCount) {
        super(usageCount);
        setItemPathPicture(plasterPath);
        enumAudio = WarhammerEnumAudio.BANDAGE;
        workOnEnemy = false;


        description = "Bandage is great way to stop the bleeding! And yes! We have also kids version with dragons and" +
                " warriors on it!";
    }

    @Override
    public void use(Creature creature) {
        super.use(creature);

        creature.getStatistics().getEffect(EffectEnum.BLEEDING).decreaseLength();
    }

}
