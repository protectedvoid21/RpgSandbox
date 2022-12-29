package game.creature;

import game.interfaces.Statistics;

import game.equipment.Inventory;

public class PlayerCharacter extends Character {
    
    public PlayerCharacter(Statistics creatureStats, Inventory inventory) {
        super(creatureStats, inventory);
    }

}
