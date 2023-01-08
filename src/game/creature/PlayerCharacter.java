package game.creature;

import game.equipment.Inventory;
import game.interfaces.IStatistics;

public class PlayerCharacter extends Character {
    public PlayerCharacter(IStatistics statistics, Inventory inventory, Experience experience) {
        super(statistics, inventory, experience, null);
    }
}
