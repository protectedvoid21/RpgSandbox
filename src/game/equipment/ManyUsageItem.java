package game.equipment;

import game.interfaces.Statistics;

public abstract class ManyUsageItem extends Item{
    public ManyUsageItem(Statistics stats) {
       super(stats);
    }
    
    @Override
    public boolean isValid() {
        return true;
    }
}
