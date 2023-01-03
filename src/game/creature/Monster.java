package game.creature;

import game.interfaces.IStatistics;

public class Monster extends Creature{
    public Monster(IStatistics creatureStats, Position position, Experience experience) {
        super(creatureStats, position, experience);
    }
}
