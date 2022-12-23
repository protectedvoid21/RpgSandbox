package game.generals;

import game.interfaces.Statistics;

/**Effect class which is some kind of implementation of effect in every RPG game.
 * Contain reference to player statistics to have an ability of changing its components by invoking "affect" method.
 * Also calculates automatically validation.*/
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
    
    /** Core method for main properties of effect influence on its owner. Responsible for using decreaseLength()
     * every its call when effect is active.
     * @see #decreaseLength() */
    protected abstract void affect();
    
    protected abstract void onEnd();
}
