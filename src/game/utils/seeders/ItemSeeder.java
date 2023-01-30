package game.utils.seeders;

import game.equipment.Armor;
import game.equipment.DisposableItem;
import game.equipment.Mount;
import game.equipment.Weapon;
import game.equipment.examples.Bandage;
//import game.equipment.examples.HolyWater;
import game.equipment.examples.Sharpener;
import game.filehandle.EntityManager;
import gui.data.WarhammerData;

public class ItemSeeder implements Seeder, WarhammerData {
    @Override
    public void seed() {
        Weapon weapon1 = new Weapon("Sword of Death", 20, 2);
        weapon1.setItemPathPicture(smallSward1);
        Weapon weapon2 = new Weapon("Noob bow", 15, 4);
        weapon2.setItemPathPicture(smallSward3);
        Weapon weapon3 = new Weapon("Sniper Rifle", 50, 6);
        weapon3.setItemPathPicture(fastAttactOpt);
        Weapon weapon4 = new Weapon("Marakasas", 1, 1);
        weapon4.setItemPathPicture(weaponPath);
        Weapon weapon5 = new Weapon("WOLOLO", 1000, 1000);
        weapon5.setItemPathPicture(carefullattackOpt);

        Armor armor1 = new Armor("Thornmail", 5);
        armor1.setItemPathPicture(armorPath);
        Armor armor2 = new Armor("Leather Chestplate", 2);
        armor2.setItemPathPicture(ratPaht);
        Armor armor3 = new Armor("Golden Helmet", 4);
        armor3.setItemPathPicture(armorPath);
        Armor armor4 = new Armor("Bucket", 1);
        armor4.setItemPathPicture(armorBasicPath);
        Armor armor5 = new Armor("T-rex suit", 7);
        armor5.setItemPathPicture(armorBasicPath);

        Mount mount1 = new Mount("Horse", 3);
        mount1.setItemPathPicture(horsePath);
        Mount mount2 = new Mount("Car", 5);
        mount2.setItemPathPicture(chickenPath);
        Mount mount3 = new Mount("Pig", 1);
        mount3.setItemPathPicture(ratPaht);
        Mount mount4 = new Mount("Another player", 2);
        mount4.setItemPathPicture(playerImagePath);
        Mount mount5 = new Mount("Flying Pig", 5);
        mount5.setItemPathPicture(dragonPath);

//        DisposableItem disposableItem1 = new HolyHandGrenadeofAntioch(1);
//        DisposableItem disposableItem2 = new HolyWater( 3);
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

        for(var player : EntityManager.getInstance().getPlayerCharacterList()){
            player.getInventory().addItem(weapon1);
            player.getInventory().addItem(weapon2);
            player.getInventory().addItem(weapon5);
            player.getInventory().addItem(armor1);
            player.getInventory().addItem(armor2);
            player.getInventory().addItem(armor5);
            player.getInventory().addItem(mount3);
            player.getInventory().addItem(mount5);
            player.getInventory().addItem(mount4);
        }
        for(var player : EntityManager.getInstance().getNPCList()){
            player.getInventory().addItem(weapon3);
            player.getInventory().addItem(armor5);
            player.getInventory().addItem(armor4);
        }

//        EntityManager.getInstance().addItem(disposableItem1);
//        EntityManager.getInstance().addItem(disposableItem2);
//        EntityManager.getInstance().addItem(disposableItem3);
    }
}
