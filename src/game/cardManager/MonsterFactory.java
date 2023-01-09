package game.cardManager;

import game.cardManager.Warhammer.MonsterFactoryWarhammer;
import game.creature.Monster;
import game.interfaces.IFactory;

import java.util.ArrayList;

public class MonsterFactory {

    public Monster creat(ArrayList<String> stats){
        IFactory factory = new MonsterFactoryWarhammer();
        return (Monster) factory.creat(stats);
    }
}
