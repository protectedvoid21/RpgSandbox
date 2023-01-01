package game.creature;

import game.equipment.Inventory;
import game.interfaces.IStatistics;
import game.interfaces.Statistics;

public class NPC extends Character {
    public NPC(IStatistics creatureStats, Inventory inventory) {
        super(creatureStats, inventory);
    }
}
