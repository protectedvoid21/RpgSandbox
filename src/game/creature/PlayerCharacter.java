package game.creature;

import game.interfaces.IStatistics;
import game.interfaces.Statistics;

import game.equipment.Inventory;

public class PlayerCharacter extends Character {
    public PlayerCharacter(IStatistics statistics) {
        super(statistics);
    }
}
