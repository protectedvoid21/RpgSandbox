package game.equipment.examples;

import controllers.audio.WarhammerEnumAudio;
import game.creature.Character;
import game.creature.Creature;
import game.equipment.DisposableItem;
import gui.data.WarhammerData;

public class DragonsBlood extends DisposableItem implements WarhammerData {
//    private Character user;
    public DragonsBlood(int usageCount) {
        super(usageCount);
//        this.user = user;
        setItemPathPicture(bloodPaht); enumAudio = WarhammerEnumAudio.DRAGON;
        workOnEnemy = false;

        description = "Dragon blood is poisoning sooooooo......when you put it on your sword your enemies will DIE IN" +
                " VERY PAINFUL WAY";
    }

    @Override
    public void use(Creature creature) {
        super.use(creature);
        if (creature instanceof Character) {
            var user = (Character) creature;

            int damage = user.getInventory().getActiveWeapon().getDamage();
            int bleeding = user.getInventory().getActiveWeapon().getChanceForBleeding();
            int poison = user.getInventory().getActiveWeapon().getChanceForPoison();
            int fire = user.getInventory().getActiveWeapon().getChanceForFire();
            int freezing = user.getInventory().getActiveWeapon().getChanceForFreezing();

            damage += 2;
            poison = (int) (poison + 25);

            user.getInventory().getActiveWeapon().upgrade(damage, bleeding, poison, fire, freezing);
        }
    }
}
