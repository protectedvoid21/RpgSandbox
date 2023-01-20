package game.filehandle;

import game.creature.*;
import game.equipment.Armor;
import game.equipment.Inventory;
import game.equipment.Mount;
import game.equipment.Weapon;
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
    PlayerCharacter playerCharacterWithAllItems;
    PlayerCharacter defaultPlayerCharacter;
    FileManager fileManager;

    private static EntityManager instance;
    
    public EntityManager(String gameName) {
        if(instance == null) {
            instance = this;
        }
        
        fileManager = new FileManager(gameName);
        defaultPlayerCharacter = new PlayerCharacter(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
        playerCharacterWithAllItems = new PlayerCharacter(new StatisticsWarhammer(), 
                new Inventory(new Weapon("Sword", 0, 0, 0, 0,0 ,0), 
                        new Armor("Armor", 0), new Mount("Benek", 0)), 
                new Experience(0), new StruggleStatisticsWarhammer());
    }
    
    public EntityManager getInstance() {
        return instance;
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


