package game.generals.effects;

import game.generals.Effect;
import game.interfaceWarhammer.AttributeEnum;
import game.interfaces.Statistics;

public class FreezingEffect extends Effect {
    public FreezingEffect(Statistics statistics, int roundsLength) {
        super(statistics, roundsLength);
    }

    @Override
    protected void affect() {
        statistics.getAttribute(AttributeEnum.AGILITY).decreaseValue(5);
        statistics.getAttribute(AttributeEnum.MOVEMENT).decreaseValue(5);
        
        decreaseLength();
    }

    @Override
    protected void onEnd() {
        statistics.getAttribute(AttributeEnum.AGILITY).increaseValue(5);
        statistics.getAttribute(AttributeEnum.MOVEMENT).decreaseValue(5);
    }
}
