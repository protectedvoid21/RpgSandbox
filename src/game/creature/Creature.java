package game.creature;

import game.interfaces.IStatistics;

/**So far it doesn't look really nice but in the future we will have some kind of director whose task will be creation of new Creature instance.
 * He creates stats and apply them to this class instance
 * (probably this director will be also able to create equipment so using one factory (builder) class there will be possibility of creating whole object.)*/
public abstract class Creature {
    protected IStatistics statistics;
    protected String name = "Adam";
    
    public Creature(IStatistics statistics) {
        this.statistics = statistics;//this can be also removed, what about creating new builder which creates required creature for given RPG game, then stats will be created by this builder class.
    }
    
    public void setStatistics(IStatistics statistics) {
        this.statistics = statistics;
    }
    
    public IStatistics getStatistics() {
        return statistics;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public abstract int getDamage();
    public abstract int getDefense();
    public abstract int getSpeed();
}
