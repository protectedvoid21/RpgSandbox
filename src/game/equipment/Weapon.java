package game.equipment;

import game.interfaces.Statistics;

public class Weapon extends ManyUsageItem {

    public Weapon(Statistics stats) {
        super(stats);
    }

    @Override
    public void use() {
        //implementation of use method
    }
}
