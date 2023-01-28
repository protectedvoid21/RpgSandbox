package game.equipment;

import game.interfaces.Statistics;
import gui.factories.WarhammerData;

public class Armor extends ManyUsageItem implements WarhammerData {
    private int defence;

    public Armor(String name, int defence) {
        super(name);
        this.defence=defence;

        setItemPathPicture(armorBasicPath);
    }

    public int getDefence() {
        return defence;
    }
}
