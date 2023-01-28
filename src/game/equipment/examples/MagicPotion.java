package game.equipment.examples;

import controllers.audio.WarhammerEnumAudio;
import game.creature.Creature;
import game.equipment.DisposableItem;
import game.interfaceWarhammer.AttributeEnum;
import gui.data.WarhammerData;

import java.util.Random;

public class MagicPotion extends DisposableItem implements WarhammerData {
    private AttributeEnum what;
    public MagicPotion() {
        super(new Random().nextInt(4) + 1);
        Random rand = new Random();
        setItemPathPicture(potionPath);
        enumAudio = WarhammerEnumAudio.POTION;
        AttributeEnum[] values = AttributeEnum.values();
        workOnEnemy = false;
        what = values[rand.nextInt(values.length)];
        description = "Even the inventor don't know what it do. Just use it and try... MUHAHAHAHAHAHAHAAH";
    }

    @Override
    public void use(Creature creature) {
        super.use(creature);

        creature.getStatistics().getAttribute(what).increaseValue(1);
    }
}
