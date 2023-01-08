package game.cardManager;

import game.cardManager.Warhammer.MonsterCreatureFactoryWarhammer;
import game.creature.Monster;
import game.interfaces.ICreatureFactory;

public class MonsterFactory {

    public Monster create(String[] stats){
        ICreatureFactory factory = new MonsterCreatureFactoryWarhammer();
        return (Monster) factory.create(stats);
    }
}
