package game.equipment.examples;

import game.creature.Creature;
import game.equipment.DisposableItem;
import game.interfaceWarhammer.EffectEnum;
import game.creature.Character;
import gui.factories.WarhammerData;

public class Bandage extends DisposableItem implements WarhammerData {
    public Bandage(int usageCount) {
        super(usageCount);
        setItemPathPicture(plasterPath);


        description = "Bandage is great way to stop the bleeding! And yes! We have also kids version with dragons and warriors on it!";
    }

    @Override
    public void use(Creature creature) {
        super.use(creature);

        creature.getStatistics().getEffect(EffectEnum.BLEEDING).decreaseLength();
    }

}
