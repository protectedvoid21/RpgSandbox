package game.creature;

import game.equipment.Inventory;
import game.interfaces.Statistics;

public abstract class Character extends Creature{
    protected Inventory inventory;
    public Character(Statistics creatureStats, Inventory inventory) {
        super(creatureStats);
        this.inventory = inventory;
    }
    public Inventory getInventory() {
        return inventory;
    }
}