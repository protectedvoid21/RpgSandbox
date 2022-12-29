package game.creature;

import game.equipment.Inventory;
import game.interfaces.Statistics;

public class NPC extends Character {
    public NPC(Statistics creatureStats, Inventory inventory) {
        super(creatureStats, inventory);
    }
}
