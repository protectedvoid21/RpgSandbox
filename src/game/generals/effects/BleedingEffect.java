package game.generals.effects;

import game.generals.Effect;
import game.interfaces.Statistics;


public class BleedingEffect extends Effect {
    public BleedingEffect(Statistics statistics, int roundsLength) {
        super(statistics, roundsLength);
    }

    @Override
    protected void affect() {
        statistics.getAttribute("HEALTH_POINTS").decreaseValue(3);
        
        decreaseLength();
    }

    @Override
    protected void onEnd() {}
}
