package game.creature;

import game.interfaces.IStatistics;

public class Monster extends Creature{
    public Monster(IStatistics creatureStats, Experience experience) {
        super(creatureStats, experience);
    }
}
