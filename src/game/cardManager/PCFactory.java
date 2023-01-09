package game.cardManager;

import game.cardManager.Warhammer.MonsterFactoryWarhammer;
import game.creature.Monster;
import game.creature.PlayerCharacter;
import game.interfaces.IFactory;

import java.util.ArrayList;

public class PCFactory {
    public PlayerCharacter creat(ArrayList<String> stats){
        IFactory factory = new MonsterFactoryWarhammer();
        return (PlayerCharacter) factory.creat(stats);
    }
}
