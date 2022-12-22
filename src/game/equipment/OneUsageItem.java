package game.equipment;

import game.interfaces.Statistics;

public abstract class OneUsageItem extends Item {

    private boolean validation = true;

    public OneUsageItem(Statistics stats) {
        super(stats);
    }

    @Override
    public boolean isValid() {
        return validation;
    }

    @Override
    public void use() {
        validation = false;
    }
}
