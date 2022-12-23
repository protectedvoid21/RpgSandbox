package game.creature;

import game.interfaces.Statistics;

public abstract class Character extends Creature{
    public Character(Statistics creatureStats) {
        super(creatureStats);
    }
}