package game.cardManager;

import game.cardManager.Warhammer.MonsterFactoryWarhammer;
import game.cardManager.Warhammer.NPCFactoryWarhammer;
import game.creature.Monster;
import game.creature.NPC;
import game.creature.PlayerCharacter;
import game.interfaces.IFactory;

import java.util.ArrayList;

public class NPCFactory {
    public NPC creat(ArrayList<String> stats){
        IFactory factory = new NPCFactoryWarhammer();
        return (NPC) factory.creat(stats);
    }
}
