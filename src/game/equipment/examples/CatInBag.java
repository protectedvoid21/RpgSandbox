package game.equipment.examples;

import controllers.audio.WarhammerEnumAudio;
import game.creature.Creature;
import game.equipment.DisposableItem;
import game.generals.effects.BleedingEffect;
import game.interfaceWarhammer.EffectEnum;
import gui.data.WarhammerData;

import static game.interfaceWarhammer.AttributeEnum.HEALTH_POINTS_NOW;

public class CatInBag extends DisposableItem implements WarhammerData {
    private int range;
    public CatInBag(int usageCount) {
        super(usageCount);
        range=2;
        setItemPathPicture(bagPath);
        enumAudio = WarhammerEnumAudio.MIAU;
        workOnEnemy = true;

        description = "MEEEOOOOOOOOOOOOOOOOOOOOOOOOW!!!!!";
    }

    public int getRange() {
        return range;
    }

    public void use(Creature creature) {
        super.use(creature);

        creature.getStatistics().getAttribute(HEALTH_POINTS_NOW).decreaseValue(2);
        creature.getStatistics().getEffect(EffectEnum.BLEEDING).apply();
    }
}
