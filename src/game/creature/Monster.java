package game.creature;

import game.interfaceWarhammer.AttributeEnum;
import game.interfaces.IStatistics;
import game.interfaces.IStruggleStatistics;
import gui.factories.WarhammerData;

public class Monster extends Creature implements WarhammerData {
    public Monster(IStatistics creatureStats, Experience experience, IStruggleStatistics struggleStatistics) {
        super(creatureStats, experience, struggleStatistics);
    }
    @Override
    public int getSpeed() {
        return statistics.getAttribute(AttributeEnum.MOVEMENT).getValue();
    }
}
