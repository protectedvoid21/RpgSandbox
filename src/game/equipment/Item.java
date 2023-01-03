package game.equipment;

import game.interfaces.IStatistics;
import game.interfaces.Statistics;

public abstract class Item {
    protected IStatistics statistics;

    public Item(IStatistics statistics) {
        this.statistics = statistics;
    }

    public abstract boolean isValid();
}
