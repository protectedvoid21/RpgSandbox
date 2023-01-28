package game.equipment.examples;

import controllers.audio.WarhammerEnumAudio;
import game.creature.Character;
import game.creature.Creature;
import game.equipment.DisposableItem;
import gui.data.WarhammerData;

public class Sharpener extends DisposableItem implements WarhammerData {
//    private Character user;
    public Sharpener(int usageCount) {
        super(usageCount);
//        this.user = user;
        setItemPathPicture(sharper);enumAudio = WarhammerEnumAudio.BONECRACK;

        workOnEnemy = false;
        description = "Your big sword will become big and sharp (YES IT WILL MAKE MORE DAMAGE)";
    }

    @Override
    public void use(Creature creature) {
        super.use(creature);

        if (creature instanceof Character) {
            var user = (Character)creature;
            int damage = user.getInventory().getActiveWeapon().getDamage();
            int bleeding = user.getInventory().getActiveWeapon().getChanceForBleeding();
            int poison = user.getInventory().getActiveWeapon().getChanceForPoison();
            int fire = user.getInventory().getActiveWeapon().getChanceForFire();
            int freezing = user.getInventory().getActiveWeapon().getChanceForFreezing();

            damage += 3;

            user.getInventory().getActiveWeapon().upgrade(damage, bleeding, poison, fire, freezing);
        }
    }
}
