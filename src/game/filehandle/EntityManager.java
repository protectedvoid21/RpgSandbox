package game.filehandle;

import game.creature.*;
import game.equipment.Inventory;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaceWarhammer.StruggleStatisticsWarhammer;
import game.interfaces.IStatistics;
import game.interfaces.IStruggleStatistics;
import game.interfaces.Statistics;

import java.util.ArrayList;
import java.util.List;

public class EntityManager {
    List<Monster> monsterList = new ArrayList<>();
    List<NPC> NPCList = new ArrayList<>();
    List<PlayerCharacter> playerCharacterList = new ArrayList<>();
    List<Creature> creatureList = new ArrayList<>();
    Creature defaultCreature;
    PlayerCharacter playerCharacterWithAllItems;
    FileManager fileManager;

    public EntityManager(String gameName) {
        fileManager = new FileManager(gameName);
//        defaultCreature = new Creature(new StatisticsWarhammer(), new Experience(0), new StruggleStatisticsWarhammer());
//        playerCharacterWithAllItems = new PlayerCharacter(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
    }

    public void saveAllEntities() {
        fileManager.writeToFile(monsterList, Monster.class);
        fileManager.writeToFile(NPCList, NPC.class);
        fileManager.writeToFile(playerCharacterList, PlayerCharacter.class);
        fileManager.writeToFile(creatureList, Creature.class);
    }

    public void loadAllEntities() {
        monsterList = fileManager.readFromFile(Monster.class);
        NPCList = fileManager.readFromFile(NPC.class);
        playerCharacterList = fileManager.readFromFile(PlayerCharacter.class);
        creatureList = fileManager.readFromFile(Creature.class);
    }
}


