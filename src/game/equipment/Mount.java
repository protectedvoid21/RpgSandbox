package game.equipment;

import game.interfaces.Statistics;

public class Mount extends ManyUsageItem{
    private int speeeeed;

    public Mount(String name, int speed) {
        super(name);
        speeeeed=speed;
    }

    public int getSpeeeeed() {
        return speeeeed;
    }
}
