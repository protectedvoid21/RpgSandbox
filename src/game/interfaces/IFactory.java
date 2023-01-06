package game.interfaces;

import game.creature.Creature;

public interface IFactory {

    public Creature creat(String [] stats);
}
