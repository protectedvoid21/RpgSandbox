package game.equipment.examples;

import game.creature.Character;
import game.equipment.DisposableItem;
import game.interfaceWarhammer.AttributeEnum;

import java.util.Random;

public class MagicPotion extends DisposableItem {
    private AttributeEnum what;
    private Character user;

    public MagicPotion(String name, Character user)
    {
        super(name, new Random().nextInt(4)+1);
        Random rand = new Random();

        AttributeEnum[] values = AttributeEnum.values();

        what=values[rand.nextInt(values.length)];
        this.user=user;
    }

    @Override
    public void use() {
        super.use();

        user.getStatistics().getAttribute(what).increaseValue(1);
    }
}
