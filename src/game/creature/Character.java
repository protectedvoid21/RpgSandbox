package game.creature;

import game.equipment.Inventory;
import game.interfaces.IStatistics;

public abstract class Character extends Creature {
    protected Inventory inventory;
    
    public Character(IStatistics statistics, Inventory inventory, Position position, Experience experience) {
        super(statistics, position, experience);
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }
}