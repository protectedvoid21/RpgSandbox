package game.board;

import game.creature.Creature;

public class CreatureObject extends GameObject {
    private final Creature creature;
    
    public CreatureObject(Creature creature) {
        this.name = creature.getName();
        this.creature = creature;
    }
    
    public Creature getCreature() {
        return creature;
    }
}
