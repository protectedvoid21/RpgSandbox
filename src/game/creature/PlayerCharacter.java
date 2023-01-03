package game.creature;

import game.interfaceWarhammer.WarhammerStatisticsBuilder;
import game.interfaces.IStatistics;
import game.interfaces.Statistics;

import game.equipment.Inventory;

public class PlayerCharacter extends Character {
    public PlayerCharacter(IStatistics statistics, Inventory inventory, Position position, Experience experience) {
        super(statistics, inventory, position, experience);
    }
}
