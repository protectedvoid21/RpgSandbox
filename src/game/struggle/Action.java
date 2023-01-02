package game.struggle;

import game.creature.Creature;

public abstract class Action {

    public  void doAction(Creature you, Creature enemy){};
    public void doAction(Creature you){};

}
