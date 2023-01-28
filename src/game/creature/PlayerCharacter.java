package game.creature;

import game.equipment.Inventory;
import game.interfaces.IStatistics;
import game.interfaces.IStruggleStatistics;
import gui.factories.WarhammerData;

public class PlayerCharacter extends Character {
    public PlayerCharacter(IStatistics statistics, Inventory inventory, Experience experience, IStruggleStatistics struggleStatistics) {
        super(statistics, inventory, experience, struggleStatistics);
    }
}
