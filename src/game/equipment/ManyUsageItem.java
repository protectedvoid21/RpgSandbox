package game.equipment;

import game.interfaces.Statistics;

public abstract class ManyUsageItem extends Item{
    //maybe some counter of "use" method execution

    public ManyUsageItem(Statistics stats) {
       super(stats);
    }


    public boolean isValid() {
        return false;//i dont know what you really want here, but also hope that my idea is clear
    }

}
