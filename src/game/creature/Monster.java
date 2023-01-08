package game.creature;

import game.interfaces.IStatistics;
import game.interfaces.IStruggleStatistics;

public class Monster extends Creature{
    public Monster(IStatistics creatureStats, Experience experience, IStruggleStatistics struggleStatistics) {
        super(creatureStats, experience, struggleStatistics);
    }
}
