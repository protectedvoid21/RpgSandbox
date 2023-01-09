package game.creature;

import game.equipment.Inventory;
import game.interfaces.IStatistics;
import game.interfaces.IStruggleStatistics;

public class NPC extends Character {
    public NPC(IStatistics statistics, Inventory inventory, Experience experience, IStruggleStatistics struggleStatistics) {
        super(statistics, inventory, experience, struggleStatistics);
    }
}
