package game.interfaces;

import game.creature.Creature;

public interface ICreatureFactory {
    Creature create(String [] stats);
}
