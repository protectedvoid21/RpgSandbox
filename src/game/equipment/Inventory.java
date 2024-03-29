package game.equipment;

import game.equipment.examples.DeadRat;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Weapon> weapons;
    private List<Armor> armors;
    private List<Mount> mounts;
    private List<DisposableItem> disposableItems;
    private Weapon activeWeapon;
    private Armor activeArmor;
    private Mount activeMount;
    private DisposableItem selectedDisposableItem;

    public Inventory() {
        weapons = new ArrayList<>();
        armors = new ArrayList<>();
        mounts = new ArrayList<>();
        disposableItems = new ArrayList<>();
        activeWeapon = noWeapon();
        activeArmor = noArmor();
        activeMount = noMount();
    }
    
    public Inventory(Weapon activeWeapon, Armor activeArmor, Mount activeMount) {
        this();
        this.activeWeapon = activeWeapon;
        this.activeArmor = activeArmor;
        this.activeMount = activeMount;
    }

    public Inventory(List<Weapon> weapons, List<Armor> armors, List<Mount> mounts, List<DisposableItem> disposableItems) {
        this.weapons = weapons;
        this.armors = armors;
        this.mounts = mounts;
        this.disposableItems = disposableItems;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }
    public List<Armor> getArmors() {
        return armors;
    }
    public List<Mount> getMounts() {
        return mounts;
    }
    public List<DisposableItem> getDisposableItems() {
        return disposableItems;
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
        else if(item instanceof DisposableItem)
        {
            disposableItems.add((DisposableItem) item);

            if(selectedDisposableItem instanceof DeadRat) {
                selectedDisposableItem = (DisposableItem) item;
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
        else if(item instanceof DisposableItem)
        {
            disposableItems.remove((DisposableItem) item);
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
        for(var item : disposableItems)
        {
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
        else if(item.equals(selectedDisposableItem))
        {
            selectedDisposableItem = noDisposableItem();
            setSelectedDisposableItem();
        }
    }

    private void setSelectedDisposableItem() {
        if (!disposableItems.isEmpty())
        {
            selectedDisposableItem=disposableItems.get(0);
        }
    }

    private void setSelectedDisposableItem(DisposableItem disposableItem) {
        if (disposableItems.contains(disposableItem))
        {
            selectedDisposableItem=disposableItem;
        }
    }

    public void nextDisposableItem()
    {
        int i = disposableItems.indexOf(selectedDisposableItem)+1;

        if(i==disposableItems.size())
        {
            i=0;
        }

        setSelectedDisposableItem(disposableItems.get(i));
    }

    public void previousDisposableItem()
    {
        int i = disposableItems.indexOf(selectedDisposableItem)-1;

        if(i<0)
        {
            i= disposableItems.size()-1;
        }

        setSelectedDisposableItem(disposableItems.get(i));
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
    public DisposableItem getSelectedDisposableItem(){
        return selectedDisposableItem;
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
    private DisposableItem noDisposableItem()
    {
        return new DeadRat(0);
    }
}
