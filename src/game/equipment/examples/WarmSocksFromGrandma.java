package game.equipment.examples;

import controllers.audio.WarhammerEnumAudio;
import game.creature.Character;
import game.creature.Creature;
import game.equipment.DisposableItem;
import game.interfaceWarhammer.EffectEnum;
import gui.factories.WarhammerData;

public class WarmSocksFromGrandma extends DisposableItem implements WarhammerData {
//    private Character user;
    public WarmSocksFromGrandma(int usageCount) {
        super( usageCount);
//        this.user = user;
        workOnEnemy = false;enumAudio = WarhammerEnumAudio.DRINKING;
        setItemPathPicture(socksPath);

        description = "When you found them under christmas tree you said: \"MEEEEH\", but then you found out that " +
                "they protect from freezing effect";
    }

    @Override
    public void use(Creature creature) {
        super.use(creature);

        creature.getStatistics().getEffect(EffectEnum.FREEZING).decreaseLength();
    }
}
