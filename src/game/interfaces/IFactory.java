package game.interfaces;

import game.creature.Creature;

import java.util.ArrayList;

public interface IFactory {

    public Creature creat(ArrayList<String> stats);
}
