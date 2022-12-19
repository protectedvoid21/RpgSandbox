package game.creature;

import game.equipment.Inventory;
import game.interfaces.Statistics;
import game.interfaceWarhammer.WarhammerStatisticsBuilder;

public abstract class Creature {
    protected Statistics statistics;
    protected Inventory inventory;

    public Creature() {
        statistics = new WarhammerStatisticsBuilder().getStats();//this can be also removed, what about creating new builder which creates required creature for given RPG game, then stats will be created by this builder class.
    }

    public Statistics getStatistics() {
        return statistics;
    }
    
    public Inventory getInventory() {
        return inventory;
    }
}
