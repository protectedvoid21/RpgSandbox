package game.equipment;

import game.interfaces.Statistics;

public abstract class ManyUsageItem extends Item {
    public ManyUsageItem(String name) {
        super(name);
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
