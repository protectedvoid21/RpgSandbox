package game.equipment;

import game.creature.Creature;
import game.interfaces.Statistics;

public abstract class DisposableItem extends Item {
    private int usageCount;
    protected String description;

    public DisposableItem(String name, int usageCount) {
        super(name);
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
    public void use(Creature creature) {
        usageCount--;
    }

    public String getDescription()
    {
        return description;
    }
}
