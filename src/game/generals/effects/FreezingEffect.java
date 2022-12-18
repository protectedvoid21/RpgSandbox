package game.generals.effects;

import game.generals.Effect;
import game.interfaces.Statistics;

public class FreezingEffect extends Effect {
    public FreezingEffect(Statistics statistics, int roundsLength) {
        super(statistics, roundsLength);
    }

    @Override
    protected void affect() {
        statistics.getAttribute("AGILITY").decreaseValue(5);
        statistics.getAttribute("MOVEMENT").decreaseValue(5);
        
        decreaseLength();
    }

    @Override
    protected void onEnd() {
        statistics.getAttribute("AGILITY").increaseValue(5);
        statistics.getAttribute("MOVEMENT").decreaseValue(5);
    }
}
