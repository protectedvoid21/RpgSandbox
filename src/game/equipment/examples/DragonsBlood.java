package game.equipment.examples;

import game.creature.Character;
import game.equipment.DisposableItem;

public class DragonsBlood extends DisposableItem {
    private Character user;

    public DragonsBlood(int usageCount, Character user) {
        super(usageCount);
        this.user=user;
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
        poison = (int) (poison*1.5);

        user.getInventory().getActiveWeapon().upgrade(damage, bleeding,poison,fire,freezing);
    }
}
