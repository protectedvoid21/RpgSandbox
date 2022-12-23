package game.creature;

import game.equipment.Inventory;

public class PlayerCharacter extends Character {
    protected Inventory inventory;
    
    public PlayerCharacter() {
        inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }
}
