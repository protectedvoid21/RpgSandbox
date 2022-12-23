package game.creature;

import game.interfaces.Statistics;

import game.equipment.Inventory;

public class PlayerCharacter extends Character {
    protected Inventory inventory;
    
    public PlayerCharacter(Statistics creatureStats) {
      super(creatureStats);
        inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }
}
