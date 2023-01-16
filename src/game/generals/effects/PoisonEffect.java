package game.generals.effects;

import game.generals.Effect;
import game.interfaceWarhammer.AttributeEnum;
import game.interfaces.Statistics;

public class PoisonEffect extends Effect {
    public PoisonEffect(Statistics statistics, int roundsLength) {
        super(statistics, roundsLength);
    }

    @Override
    public void affect() {
        statistics.getAttribute(AttributeEnum.HEALTH_POINTS_NOW).decreaseValue(4);

        decreaseLength();
    }

    @Override
    protected void onEnd() {

    }
}
