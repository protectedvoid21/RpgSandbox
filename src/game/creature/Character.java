package game.creature;

import game.equipment.Inventory;
import game.interfaceWarhammer.AttributeEnum;
import game.interfaces.IStatistics;
import game.interfaces.IStruggleStatistics;

public abstract class Character extends Creature {
    protected Inventory inventory;
    
    public Character(IStatistics statistics, Inventory inventory, Experience experience, IStruggleStatistics struggleStatistics) {
        super(statistics, experience, struggleStatistics);
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public int getDamage() {
        return inventory.getActiveWeapon().getDamage()+statistics.getAttribute(AttributeEnum.STRENGTH).getValue();
    }

    @Override
    public int getDefense() {
        return inventory.getActiveArmor().getDefence()+statistics.getAttribute(AttributeEnum.STRENGTH).getValue();
    }

    @Override
    public int getSpeed() {
        return inventory.getActiveMount().getSpeed()+statistics.getAttribute(AttributeEnum.MOVEMENT).getValue();
    }
}