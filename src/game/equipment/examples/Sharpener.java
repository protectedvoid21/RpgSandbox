package game.equipment.examples;

import game.creature.Character;
import game.equipment.DisposableItem;
import gui.factories.WarhammerData;

public class Sharpener extends DisposableItem implements WarhammerData {
    private Character user;
    boolean onEnemy = false;

    public Sharpener(String name, int usageCount, Character user) {
        super(name, usageCount);
        this.user = user;
        setItemPathPicture(sharper);

        description = "Your big sword will become big and sharp (YES IT WILL MAKE MORE DAMAGE)";
    }

    @Override
    public void use() {
        super.use();

        int damage = user.getInventory().getActiveWeapon().getDamage();
        int bleeding = user.getInventory().getActiveWeapon().getChanceForBleeding();
        int poison = user.getInventory().getActiveWeapon().getChanceForPoison();
        int fire = user.getInventory().getActiveWeapon().getChanceForFire();
        int freezing = user.getInventory().getActiveWeapon().getChanceForFreezing();

        damage += 3;

        user.getInventory().getActiveWeapon().upgrade(damage, bleeding, poison, fire, freezing);
    }
}
