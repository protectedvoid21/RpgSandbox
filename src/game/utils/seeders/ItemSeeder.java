package game.utils.seeders;

import game.equipment.Armor;
import game.equipment.DisposableItem;
import game.equipment.Mount;
import game.equipment.Weapon;
import game.equipment.examples.Bandage;
import game.equipment.examples.HolyWater;
import game.equipment.examples.Sharpener;
import game.filehandle.EntityManager;

public class ItemSeeder implements Seeder {
    @Override
    public void seed() {
        Weapon weapon1 = new Weapon("Sword of Death", 20, 2);
        Weapon weapon2 = new Weapon("Noob bow", 15, 4);
        Weapon weapon3 = new Weapon("Sniper Rifle", 50, 6);
        Weapon weapon4 = new Weapon("Marakasas", 1, 1);
        Weapon weapon5 = new Weapon("WOLOLO", 1000, 1000);

        Armor armor1 = new Armor("Thornmail", 5);
        Armor armor2 = new Armor("Leather Chestplate", 2);
        Armor armor3 = new Armor("Golden Helmet", 4);
        Armor armor4 = new Armor("Bucket", 1);
        Armor armor5 = new Armor("T-rex suit", 7);

        Mount mount1 = new Mount("Horse", 3);
        Mount mount2 = new Mount("Car", 5);
        Mount mount3 = new Mount("Pig", 1);
        Mount mount4 = new Mount("Another player", 2);
        Mount mount5 = new Mount("Flying Pig", 5);

//        DisposableItem disposableItem1 = new HolyHandGrenadeofAntioch(1);
        DisposableItem disposableItem2 = new HolyWater( 3);
//        DisposableItem disposableItem3 = new HolyHandGrenadeofAntioch(2);

        EntityManager.getInstance().addItem(weapon1);
        EntityManager.getInstance().addItem(weapon2);
        EntityManager.getInstance().addItem(weapon3);
        EntityManager.getInstance().addItem(weapon4);
        EntityManager.getInstance().addItem(weapon5);
        
        EntityManager.getInstance().addItem(armor1);
        EntityManager.getInstance().addItem(armor2);
        EntityManager.getInstance().addItem(armor3);
        EntityManager.getInstance().addItem(armor4);
        EntityManager.getInstance().addItem(armor5);
        
        EntityManager.getInstance().addItem(mount1);
        EntityManager.getInstance().addItem(mount2);
        EntityManager.getInstance().addItem(mount3);
        EntityManager.getInstance().addItem(mount4);
        EntityManager.getInstance().addItem(mount5);

//        EntityManager.getInstance().addItem(disposableItem1);
        EntityManager.getInstance().addItem(disposableItem2);
//        EntityManager.getInstance().addItem(disposableItem3);
    }
}
