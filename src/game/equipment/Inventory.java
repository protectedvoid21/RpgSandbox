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
        activeWeapon = noWeapon();
        activeArmor = noArmor();
        activeMount = noMount();
    }

    public ArrayList<Item> getItems() {
        return itemList;
    }

    public void addItem(Item item) {
        itemList.add(item);

        if (item instanceof Weapon && activeWeapon.getName().equals("none")) {
            activeWeapon = (Weapon) item;
        }
        else if (item instanceof Armor && activeArmor.getName().equals("none")) {
            activeArmor = (Armor) item;
        }
        else if (item instanceof Mount && activeMount.getName().equals("none")) {
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
            activeWeapon = noWeapon();
            setActiveWeapon();
        }
        else if (item.equals(activeArmor)) {
            activeArmor = noArmor();
            setActiveArmor();
        }
        else if (item.equals(activeMount)) {
            activeMount = noMount();
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

    public Weapon getActiveWeapon() {
        return activeWeapon;
    }

    public Armor getActiveArmor() {
        return activeArmor;
    }

    public Mount getActiveMount() {
        return activeMount;
    }

    private Weapon noWeapon() {
        return new Weapon("none", 0, 0, 0, 0, 0, 0);
    }

    private Armor noArmor() {
        return new Armor("none", 0);
    }

    private Mount noMount() {
        return new Mount("none", 0);
    }
}
