package game.creature;

import game.interfaces.IStatistics;
import game.interfaces.RoundListener;

public abstract class Creature implements RoundListener {
    protected IStatistics statistics;
    protected String name;
    protected Experience experience;
    
    public Creature(IStatistics statistics, Experience experience) {
        this.statistics = statistics;
        this.experience = experience;
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
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Experience getExperience() {
        return experience;
    }
}
