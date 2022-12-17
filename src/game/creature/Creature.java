package game.creature;

import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaces.Statistics;

public class Creature {
    protected Statistics statistics;

    public Creature() {
        statistics = new StatisticsWarhammer();
    }

    public Statistics getStatistic(){
        return statistics;
    }
}
