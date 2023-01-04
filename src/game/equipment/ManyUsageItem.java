package game.equipment;

import game.interfaces.Statistics;

public abstract class ManyUsageItem extends Item{
    private String name;

    public ManyUsageItem(String name) {
        this.name=name;
    }
    
    @Override
    public boolean isValid() {
        return true;
    }
}
