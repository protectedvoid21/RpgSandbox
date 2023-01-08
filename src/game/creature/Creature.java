package game.creature;

import game.interfaces.IStatistics;
import game.interfaces.RoundListener;
import game.interfaces.IStruggleStatistics;

public abstract class Creature implements RoundListener {
    protected IStatistics statistics;
    protected IStruggleStatistics struggleStatistics;
    protected String name;
    protected Experience experience;
    
    public Creature(IStatistics statistics, Experience experience, IStruggleStatistics struggleStatistics) {
        this.statistics = statistics;
        this.experience = experience;
        this.struggleStatistics = struggleStatistics;
    }
    
    public void applyNewRound() {
        statistics.applyNewRound();
    }
    
    public IStatistics getStatistics() {
        return statistics;
    }
    
    public String getName() {
        return name;
    }
    
    public IStruggleStatistics getStruggleStatistics() {
        return struggleStatistics;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Experience getExperience() {
        return experience;
    }
}
