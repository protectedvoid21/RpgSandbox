package game.creature;

import game.equipment.Inventory;
import game.interfaceWarhammer.AttributeEnum;
import game.interfaces.IStatistics;

public abstract class Character extends Creature {
    protected Inventory inventory;
    
    public Character(IStatistics statistics, Inventory inventory) {
        super(statistics);
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
        return inventory.getActiveMount().getSpeeeeed()+statistics.getAttribute(AttributeEnum.MOVEMENT).getValue();
    }
}