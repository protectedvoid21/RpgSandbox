package game.creature;

import game.interfaces.Statistics;

public class Monster extends Creature{
    private int experienceDrop;

    public Monster(Statistics creatureStats, int experienceDrop) {
        super(creatureStats);
        this.experienceDrop = experienceDrop;
    }

    public int getExperienceDrop() {
        return experienceDrop;
    }
}
