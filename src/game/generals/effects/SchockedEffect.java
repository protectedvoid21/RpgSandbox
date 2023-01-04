package game.generals.effects;

import game.generals.Effect;
import game.interfaceWarhammer.AttributeEnum;
import game.interfaces.Statistics;

public class SchockedEffect extends Effect {
    public SchockedEffect(Statistics statistics, int roundsLength) {
        super(statistics, roundsLength);
    }

    @Override
    protected void affect() {
        if(remainingRounds==roundsLength)
        {
            statistics.getAttribute(AttributeEnum.ACTIONS_TO_DO).decreaseValue(1);
        }

        decreaseLength();
    }

    @Override
    protected void onEnd() {
        statistics.getAttribute(AttributeEnum.ACTIONS_TO_DO).increaseValue(1);
    }
}
