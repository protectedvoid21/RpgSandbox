package game.interfaces;

public abstract class StatisticsBuilder {

    protected Statistics stats;

    public StatisticsBuilder(){
        setStats();
    }
    protected abstract void setStats();
    public  void setAttributesWithJSON(String jsonPath){
        //to do in future, method will be constructing stats using json format files
    }
    public  void setEffectWithJSON(String jsonPath){
        //to do in future, method will be constructing stats using json format files
    }

    public Statistics getStats(){
        return stats;
    }
}
