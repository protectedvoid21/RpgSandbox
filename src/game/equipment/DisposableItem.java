package game.equipment;

import game.creature.Creature;
import game.interfaces.Statistics;

public abstract class DisposableItem extends Item {
    private int usageCount;
    protected String description;
    private int onEnemy = 0;

    public DisposableItem( int usageCount) {
        super("");
        setName(getClass().getSimpleName());
        if(usageCount < 1) {
            usageCount = 1;
        }
        this.usageCount = usageCount;
    }

    @Override
    public boolean isValid() {
        return usageCount > 0;
    }

//    public void use() {
//        usageCount--;
//    }
    public void use(Creature creature) {
        usageCount--;
    }

    public String getDescription()
    {
        return description;
    }

    public int isOnEnemy() {
        return onEnemy;
    }
    public void setOnEnemy(int parametr){
        onEnemy = parametr;
    }
}
