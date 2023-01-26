package game.equipment.examples;

import game.creature.Character;
import game.equipment.DisposableItem;
import gui.factories.WarhammerData;

public class DragonsBlood extends DisposableItem implements WarhammerData {
    private Character user;

    public DragonsBlood( int usageCount, Character user) {
        super( usageCount);
        this.user=user;setItemPathPicture(bloodPaht);

        description = "Dragon blood is poisoning sooooooo......when you put it on your sword your enemies will DIE IN VERY PAINFUL WAY";
    }

    @Override
    public void use() {
        super.use();

        int damage = user.getInventory().getActiveWeapon().getDamage();
        int bleeding = user.getInventory().getActiveWeapon().getChanceForBleeding();
        int poison = user.getInventory().getActiveWeapon().getChanceForPoison();
        int fire = user.getInventory().getActiveWeapon().getChanceForFire();
        int freezing = user.getInventory().getActiveWeapon().getChanceForFreezing();

        damage += 2;
        poison = (int) (poison+ 25);

        user.getInventory().getActiveWeapon().upgrade(damage, bleeding,poison,fire,freezing);
    }
}
