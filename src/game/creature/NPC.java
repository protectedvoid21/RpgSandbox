package game.creature;

import game.equipment.Inventory;
import game.interfaces.IStatistics;
import game.interfaces.IStruggleStatistics;
import gui.data.WarhammerData;

public class NPC extends Character implements WarhammerData {
    public NPC(IStatistics statistics, Inventory inventory, Experience experience, IStruggleStatistics struggleStatistics) {
        super(statistics, inventory, experience, struggleStatistics);
    }
}
