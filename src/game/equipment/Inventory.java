package game.equipment;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private ArrayList<Weapon> weapons;
    private ArrayList<Armor> armors;
    private ArrayList<Mount> mounts;
    private Weapon activeWeapon;
    private Armor activeArmor;
    private Mount activeMount;

    public Inventory() {
        weapons = new ArrayList<>();
        armors = new ArrayList<>();
        mounts = new ArrayList<>();
        activeWeapon = noWeapon();
        activeArmor = noArmor();
        activeMount = noMount();
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }
    public ArrayList<Armor> getArmors() {
        return armors;
    }
    public ArrayList<Mount> getMounts() {
        return mounts;
    }

    public void addItem(Item item) {
        if (item instanceof Weapon) {
            weapons.add((Weapon) item);

            if(activeWeapon.getName().equals("none")) {
                activeWeapon = (Weapon) item;
            }
        }
        else if (item instanceof Armor) {
            armors.add((Armor) item);

            if(activeArmor.getName().equals("none")) {
                activeArmor = (Armor) item;
            }
        }
        else if (item instanceof Mount) {
            mounts.add((Mount) item);

            if(activeMount.getName().equals("none")) {
                activeMount = (Mount) item;
            }
        }
    }

    public void removeItem(Item item) {
        if (item instanceof Weapon) {
            weapons.remove((Weapon) item);
        }
        else if (item instanceof Armor) {
            armors.remove((Armor) item);
        }
        else if (item instanceof Mount) {
            mounts.remove((Mount) item);
        }

        inventoryCheck(item);
    }

    private void removeItemIfNotValid(Item item) {
        if (!item.isValid()) {
            removeItem(item);
        }

        inventoryCheck(item);
    }

    public void removeEachItemIfNotValid() {
        for (var item : weapons) {
            removeItemIfNotValid(item);

            inventoryCheck(item);
        }
        for (var item : armors) {
            removeItemIfNotValid(item);

            inventoryCheck(item);
        }
        for (var item : mounts) {
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
        if (!weapons.isEmpty())
        {
            activeWeapon=weapons.get(0);
        }
    }

    public void setActiveWeapon(Weapon weapon) {
        if (weapons.contains(weapon)) {
            activeWeapon = weapon;
        }
    }

    public void nextWeapon()
    {
        int i = weapons.indexOf(activeWeapon)+1;

        if(i==weapons.size())
        {
            i=0;
        }

        setActiveWeapon(weapons.get(i));
    }

    public void previousWeapon()
    {
        int i = weapons.indexOf(activeWeapon)-1;

        if(i<0)
        {
            i= weapons.size()-1;
        }

        setActiveWeapon(weapons.get(i));
    }

    private void setActiveArmor() {
        if (!armors.isEmpty())
        {
            activeArmor=armors.get(0);
        }
    }

    public void setActiveArmor(Armor armor) {
        if (armors.contains(armor)) {
            activeArmor = armor;
        }
    }

    public void nextArmor()
    {
        int i = armors.indexOf(activeArmor)+1;

        if(i==armors.size())
        {
            i=0;
        }

        setActiveArmor(armors.get(i));
    }

    public void previousArmor()
    {
        int i = armors.indexOf(activeArmor)-1;

        if(i<0)
        {
            i= armors.size()-1;
        }

        setActiveArmor(armors.get(i));
    }

    private void setActiveMount() {
        if (!mounts.isEmpty())
        {
            activeMount=mounts.get(0);
        }
    }

    public void setActiveMount(Mount mount) {
        if (mounts.contains(mount)) {
            activeMount = mount;
        }
    }

    public void nextMount()
    {
        int i = mounts.indexOf(activeMount)+1;

        if(i==mounts.size())
        {
            i=0;
        }

        setActiveMount(mounts.get(i));
    }

    public void previousMount()
    {
        int i = mounts.indexOf(activeMount)-1;

        if(i<0)
        {
            i= mounts.size()-1;
        }

        setActiveMount(mounts.get(i));
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
