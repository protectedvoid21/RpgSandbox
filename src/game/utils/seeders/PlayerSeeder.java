package game.utils.seeders;

import game.creature.Experience;
import game.creature.PlayerCharacter;
import game.equipment.Inventory;
import game.filehandle.EntityManager;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaceWarhammer.StruggleStatisticsWarhammer;
import gui.data.WarhammerData;

public class PlayerSeeder implements Seeder, WarhammerData {
    @Override
    public void seed() {
        PlayerCharacter playerCharacter1 = new PlayerCharacter(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
//        playerCharacter1.getInventory().addItem(EntityManager.getInstance().getMountList().get(0));
        playerCharacter1.setName("Michalik");
        playerCharacter1.setObjectPathPicture(person1Path);
        PlayerCharacter playerCharacter2 = new PlayerCharacter(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
        playerCharacter2.setName("Adamow");
        playerCharacter2.setObjectPathPicture(person3Path);
        PlayerCharacter playerCharacter3 = new PlayerCharacter(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
        playerCharacter3.setName("Iwaszkiewicz");
        playerCharacter3.setObjectPathPicture(person4Path);
        PlayerCharacter playerCharacter4 = new PlayerCharacter(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
        playerCharacter4.setName("Hawking");
        playerCharacter4.setObjectPathPicture(person5Path);
        PlayerCharacter playerCharacter5 = new PlayerCharacter(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
        playerCharacter5.setName("Lipton");
        playerCharacter5.setObjectPathPicture(person6Path);

        playerCharacter5.getInventory().addItem(EntityManager.getInstance().getDisposableItemList().get(3));
        playerCharacter5.getInventory().addItem(EntityManager.getInstance().getDisposableItemList().get(1));
        playerCharacter5.getInventory().addItem(EntityManager.getInstance().getDisposableItemList().get(6));
        playerCharacter5.getInventory().addItem(EntityManager.getInstance().getDisposableItemList().get(7));
        playerCharacter5.getInventory().addItem(EntityManager.getInstance().getDisposableItemList().get(4));

        playerCharacter4.getInventory().addItem(EntityManager.getInstance().getDisposableItemList().get(3));
        playerCharacter4.getInventory().addItem(EntityManager.getInstance().getDisposableItemList().get(1));
        playerCharacter4.getInventory().addItem(EntityManager.getInstance().getDisposableItemList().get(6));
        playerCharacter4.getInventory().addItem(EntityManager.getInstance().getDisposableItemList().get(7));
        playerCharacter4.getInventory().addItem(EntityManager.getInstance().getDisposableItemList().get(10));

        playerCharacter3.getInventory().addItem(EntityManager.getInstance().getDisposableItemList().get(3));
        playerCharacter3.getInventory().addItem(EntityManager.getInstance().getDisposableItemList().get(7));
        playerCharacter3.getInventory().addItem(EntityManager.getInstance().getDisposableItemList().get(4));

        playerCharacter1.getInventory().addItem(EntityManager.getInstance().getDisposableItemList().get(3));
        playerCharacter1.getInventory().addItem(EntityManager.getInstance().getDisposableItemList().get(6));
        playerCharacter1.getInventory().addItem(EntityManager.getInstance().getDisposableItemList().get(2));
        playerCharacter1.getInventory().addItem(EntityManager.getInstance().getDisposableItemList().get(1));
        EntityManager.getInstance().addCreature(playerCharacter1);
        EntityManager.getInstance().addCreature(playerCharacter2);
        EntityManager.getInstance().addCreature(playerCharacter3);
        EntityManager.getInstance().addCreature(playerCharacter4);
        EntityManager.getInstance().addCreature(playerCharacter5);
    }
}
