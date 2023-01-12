package game.board;

import game.creature.Creature;
import game.interfaces.RoundListener;

public class GameObject implements RoundListener {
    protected String name;
    protected final Creature creature;

    public GameObject(Creature creature) {
        this.name = creature.getName();
        this.creature = creature;
    }
    
    public void applyNewRound() {
        creature.applyNewRound();
    }

    public Creature getCreature() {
        return creature;
    }

    public String getName() {
        return name;
    }


}
