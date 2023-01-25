package tests;

import game.equipment.Armor;
import game.equipment.Inventory;
import game.equipment.Mount;
import game.equipment.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class InventoryTests {
    private Inventory inventory;
    
    private List<Weapon> weaponList;
    private List<Mount> mountList;
    private List<Armor> armorList;
    
    List<Weapon> getWeaponSeed() {
        Weapon weapon1 = new Weapon("CustomWeapon1", 10, 3);
        Weapon weapon2 = new Weapon("CustomWeapon2", 10, 2);
        Weapon weapon3 = new Weapon("CustomWeapon3", 10, 5);
        
        return List.of(weapon1, weapon2, weapon3);
    }
    
    List<Mount> getMountSeed() {
        Mount mount1 = new Mount("CustomMount1", 3);
        Mount mount2 = new Mount("CustomMount2", 5);
        
        return List.of(mount1, mount2);
    }
    
    List<Armor> getArmorSeed() {
        Armor armor1 = new Armor("CustomArmor1", 4);
        Armor armor2 = new Armor("CustomArmor2", 2);
        
        return List.of(armor1, armor2);
    }
    
    @BeforeEach
    void initialize() {
        weaponList = getWeaponSeed();
        mountList = getMountSeed();
        armorList = getArmorSeed();

        inventory = new Inventory(weaponList.get(0), armorList.get(0), mountList.get(0));
        
        for(var weapon : weaponList) {
            inventory.addItem(weapon);
        }
        for(var mount : mountList) {
            inventory.addItem(mount);
        }
        for(var armor : armorList) {
            inventory.addItem(armor);
        }
    }
    
    @Test
    void addedItemsShouldBeVisible() {
        Assertions.assertNotNull(inventory.getWeapons());
        Assertions.assertNotNull(inventory.getMounts());
        Assertions.assertNotNull(inventory.getArmors());
        
        Assertions.assertEquals(weaponList.size(), inventory.getWeapons().size());
        Assertions.assertEquals(armorList.size(), inventory.getArmors().size());
        Assertions.assertEquals(mountList.size(), inventory.getMounts().size());
    }
}
