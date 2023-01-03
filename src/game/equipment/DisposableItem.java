package game.equipment;

import game.interfaces.Statistics;

public abstract class DisposableItem extends Item {
    private int usageCount;

    public DisposableItem(Statistics stats, int usageCount) {
        super(stats);
        if(usageCount < 1) {
            usageCount = 1;
        }
        this.usageCount = usageCount;
    }

    @Override
    public boolean isValid() {
        return usageCount > 0;
    }

    public void use() {
        usageCount--;
    }
}
