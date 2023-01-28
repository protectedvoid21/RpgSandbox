package game.equipment;

import controllers.audio.ICustomEnumAudio;
import controllers.audio.WarhammerEnumAudio;
import game.creature.Creature;
import game.interfaces.Statistics;

public abstract class DisposableItem extends Item {
    private int usageCount;
    protected String description;
    protected boolean workOnEnemy = false;
    public ICustomEnumAudio enumAudio;

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

    public boolean getWorkOnEnemy(){
        return workOnEnemy;
    }

    public void use(Creature creature) {
        usageCount--;
    }

    public String getDescription()
    {
        return description;
    }
}
