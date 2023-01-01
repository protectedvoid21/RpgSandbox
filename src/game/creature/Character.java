package game.creature;

import game.equipment.Inventory;
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
}