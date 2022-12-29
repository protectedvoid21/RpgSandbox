package game.creature;

import game.equipment.Inventory;
import game.interfaces.IStatistics;
import game.interfaces.Statistics;

public abstract class Character extends Creature {
    protected Inventory inventory;
    public Character(IStatistics statistics) {
        super(statistics);
        inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }
}