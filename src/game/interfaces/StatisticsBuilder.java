package game.interfaces;

/**Every RPG stats builder which gives an opportunity of creating stats from some database*/
public abstract class StatisticsBuilder {

    protected Statistics stats;

    public StatisticsBuilder(){
        setStats();
    }
    
    protected abstract void setStats();
    
    public void setAttributesWithJSON(String jsonPath){
        //to do in the future, method will be constructing stats using json format files
    }
    
    public void setEffectWithJSON(String jsonPath){
        //to do in the future, method will be constructing stats using json format files
    }

    public Statistics getStats(){
        return stats;
    }
}
