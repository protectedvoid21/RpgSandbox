package game.utils.seeders;

import game.equipment.Armor;
import game.equipment.Mount;
import game.equipment.Weapon;
import game.filehandle.EntityManager;

public class ItemSeeder implements Seeder {
    @Override
    public void seed() {
        Weapon weapon1 = new Weapon("Sword of Death", 20, 2);
        Weapon weapon2 = new Weapon("Noob bow", 15, 4);
        Weapon weapon3 = new Weapon("Sniper Rifle", 50, 6);

        Armor armor1 = new Armor("Thornmail", 5);
        Armor armor2 = new Armor("Leather Chestplate", 2);
        Armor armor3 = new Armor("Golden Helmet", 4);

        Mount mount1 = new Mount("Horse", 3);
        Mount mount2 = new Mount("Car", 5);
        Mount mount3 = new Mount("Pig", 1);

        EntityManager.getInstance().addItem(weapon1);
        EntityManager.getInstance().addItem(weapon2);
        EntityManager.getInstance().addItem(weapon3);
        
        EntityManager.getInstance().addItem(armor1);
        EntityManager.getInstance().addItem(armor2);
        EntityManager.getInstance().addItem(armor3);
        
        EntityManager.getInstance().addItem(mount1);
        EntityManager.getInstance().addItem(mount2);
        EntityManager.getInstance().addItem(mount3);
    }
}
