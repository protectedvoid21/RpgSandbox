package game.board;

import game.creature.Creature;

public class CreatureObject extends GameObject {
    private final Creature creature;
    
    public CreatureObject(Board board, Creature creature) {
        super(board);
        this.name = creature.getName();
        this.creature = creature;
    }
    
    public Creature getCreature() {
        return creature;
    }
}
