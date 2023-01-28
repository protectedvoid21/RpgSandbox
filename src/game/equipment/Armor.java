package game.equipment;

import game.interfaces.Statistics;
import gui.factories.WarhammerData;

public class Armor extends ManyUsageItem {
    private int defence;

    public Armor(String name, int defence) {
        super(name);
        this.defence=defence;
    }

    public int getDefence() {
        return defence;
    }
}
