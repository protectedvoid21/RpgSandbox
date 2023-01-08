package game.creature;

import game.equipment.Inventory;
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
}