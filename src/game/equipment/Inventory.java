package game.equipment;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private ArrayList<Item> itemList;
    private Weapon activeWeapon;
    private Armor activeArmor;
    private Mount activeMount;
    
    public Inventory() {
        itemList = new ArrayList<>();
        activeWeapon = null;
        activeArmor = null;
        activeMount = null;
    }

    public ArrayList<Item> getItems() {
        return itemList;
    }

    public void addItem(Item item) {
        itemList.add(item);

        if (item instanceof Weapon && activeWeapon == null) {
            activeWeapon = (Weapon) item;
        }
        else if (item instanceof Armor && activeArmor == null) {
            activeArmor = (Armor) item;
        }
        else if (item instanceof Mount && activeMount == null) {
            activeMount = (Mount) item;
        }
    }

    public void removeItem(Item item) {
        itemList.remove(item);

        inventoryCheck(item);
    }

    private void removeItemIfNotValid(Item item) {
        if (!item.isValid()) {
            removeItem(item);
        }

        inventoryCheck(item);
    }

    public void removeEachItemIfNotValid() {
        for (var item : itemList) {
            removeItemIfNotValid(item);

            inventoryCheck(item);
        }
    }

    private void inventoryCheck(Item item) {
        if (item.equals(activeWeapon)) {
            activeWeapon = null;
            setActiveWeapon();
        }
        else if (item.equals(activeArmor)) {
            activeArmor = null;
            setActiveArmor();
        }
        else if (item.equals(activeMount)) {
            activeMount = null;
            setActiveMount();
        }
    }

    private void setActiveWeapon() {
        for (Item item : itemList) {
            if (item instanceof Weapon) {
                activeWeapon = (Weapon) item;
                break;
            }
        }
    }

    public void setActiveWeapon(Weapon weapon) {
        if (itemList.contains(weapon)) {
            activeWeapon = weapon;
        }
    }

    private void setActiveArmor() {
        for (Item item : itemList) {
            if (item instanceof Armor) {
                activeArmor = (Armor) item;
                break;
            }
        }
    }

    public void setActiveArmor(Armor armor) {
        if (itemList.contains(armor)) {
            activeArmor = armor;
        }
    }

    private void setActiveMount() {
        for (Item item : itemList) {
            if (item instanceof Mount) {
                activeMount = (Mount) item;
                break;
            }
        }
    }

    public void setActiveMount(Mount mount) {
        if (itemList.contains(mount)) {
            activeMount = mount;
        }
    }
}
