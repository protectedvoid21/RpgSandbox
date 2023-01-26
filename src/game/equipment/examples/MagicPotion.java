package game.equipment.examples;

import game.creature.Character;
import game.creature.Creature;
import game.equipment.DisposableItem;
import game.interfaceWarhammer.AttributeEnum;
import gui.factories.WarhammerData;

import java.util.Random;

public class MagicPotion extends DisposableItem implements WarhammerData {
    private AttributeEnum what;
//    private Character user;

    public MagicPotion()
    {
        super(new Random().nextInt(4)+1);
        Random rand = new Random();setItemPathPicture(potionPath);

        AttributeEnum[] values = AttributeEnum.values();

        what=values[rand.nextInt(values.length)];
//        this.user=user;

        description = "Even the inventor don't know what it do. Just use it and try... MUHAHAHAHAHAHAHAAH";
    }

    @Override
    public void use(Creature creature) {
        super.use(creature);

        creature.getStatistics().getAttribute(what).increaseValue(1);
    }
}
