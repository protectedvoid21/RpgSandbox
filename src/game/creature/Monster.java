package game.creature;

import game.interfaceWarhammer.AttributeEnum;
import game.interfaces.IStatistics;

public class Monster extends Creature{
    public Monster(IStatistics creatureStats) {
        super(creatureStats);
    }

    @Override
    public int getDamage() {
        return statistics.getAttribute(AttributeEnum.STRENGTH).getValue();
    }

    @Override
    public int getDefense() {
        return statistics.getAttribute(AttributeEnum.STRENGTH).getValue();
    }

    @Override
    public int getSpeed() {
        return statistics.getAttribute(AttributeEnum.MOVEMENT).getValue();
    }
}
