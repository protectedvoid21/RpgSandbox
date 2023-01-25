package tests;

import game.equipment.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    
    @Test
    void switchToNextWeaponShouldBeVisible() {
        inventory.nextWeapon();
        
        Assertions.assertEquals(weaponList.get(1), inventory.getActiveWeapon());
    }

    @Test
    void switchToNextArmorShouldBeVisible() {
        inventory.nextArmor();

        Assertions.assertEquals(armorList.get(1), inventory.getActiveArmor());
    }

    @Test
    void switchToNextMountShouldBeVisible() {
        inventory.nextMount();

        Assertions.assertEquals(mountList.get(1), inventory.getActiveMount());
    }
    
    @Test
    void switchToItemShouldBeVisible() {
        inventory.setActiveWeapon(weaponList.get(2));
        
        Assertions.assertEquals(weaponList.get(2), inventory.getActiveWeapon());
        
        inventory.nextWeapon();
        
        Assertions.assertEquals(weaponList.get(0), inventory.getActiveWeapon());
    }
}
