package game.creature;

import game.interfaces.Statistics;
import game.interfaces.WarhammerStatisticsBuilder;

public class Creature {
    protected Statistics statistics;

    public Creature() {
        statistics = new WarhammerStatisticsBuilder().getStats();//this can be also removed, what about creating new builder which creates required creature for given RPG game, then stats will be created by this builder class.
    }
    

    public Statistics getStatistic() {
        return statistics;
    }
}
