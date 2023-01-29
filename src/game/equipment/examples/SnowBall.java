package game.equipment.examples;

import controllers.audio.WarhammerEnumAudio;
import game.creature.Creature;
import game.equipment.DisposableItem;
import game.interfaceWarhammer.EffectEnum;
import gui.data.WarhammerData;

import static game.interfaceWarhammer.AttributeEnum.HEALTH_POINTS_NOW;

public class SnowBall extends DisposableItem implements WarhammerData {
    private int range;
    public SnowBall(int usageCount) {
        super(usageCount);
        range=2;
        setItemPathPicture(snowBall);
        enumAudio = WarhammerEnumAudio.PTSZ;
        workOnEnemy = true;

        description = "It's snowing!!! Let's use it and put some snow under someone's jacket";
    }

    public int getRange() {
        return range;
    }

    public void use(Creature creature) {
        super.use(creature);

        creature.getStatistics().getAttribute(HEALTH_POINTS_NOW).decreaseValue(1);
        creature.getStatistics().getEffect(EffectEnum.FREEZING).apply();
    }
}
