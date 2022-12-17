package game.generals;

import game.interfaces.Statistics;

public abstract class Effect {
    protected final Statistics statistics;
    protected int remainingRounds;
    private final int roundsLength;
    
    public Effect(Statistics statistics, int roundsLength) {
        this.statistics = statistics;
        this.roundsLength = roundsLength;
    }

    public boolean isActive() {
        return remainingRounds > 0;
    }
    
    public void apply() {
        remainingRounds = roundsLength;
    }
    
    protected void decreaseLength() {
        if(!isActive()) {
            return;
        }
        remainingRounds--;
        if(remainingRounds == 0) {
            onEnd();
        }
    }
    
    protected abstract void affect();
    
    protected abstract void onEnd();
}
