package game.cardManager;

import game.cardManager.Warhammer.MonsterFactoryWarhammer;
import game.creature.Monster;
import game.interfaces.IFactory;

public class MonsterFactory {

    public Monster creat(String[] stats){
        IFactory factory = new MonsterFactoryWarhammer();
        return (Monster) factory.creat(stats);
    }
}
