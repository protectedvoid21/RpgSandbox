package game.creature;

import game.interfaces.IStatistics;
import game.interfaces.RoundListener;
import game.interfaces.IStruggleStatistics;
import gui.utils.StringAdapter;

public abstract class Creature implements RoundListener {
    protected IStatistics statistics;
    protected IStruggleStatistics struggleStatistics;
    protected String name = "";
    protected Experience experience;
    private String objectPathPicture = "";

    public Creature(IStatistics statistics, Experience experience, IStruggleStatistics struggleStatistics) {
        this.statistics = statistics;
        this.experience = experience;
        this.struggleStatistics = struggleStatistics;
    }

    public void applyNewRound() {
        statistics.applyNewRound();
        struggleStatistics.applyNewRound();
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

    public abstract int getSpeed();

    public String getObjectPathPicture() {
        return objectPathPicture;
    }

    public void setObjectPathPicture(String objectPathPicture) {
        this.objectPathPicture = objectPathPicture;
    }
}
