package game.filehandle;

import game.creature.*;
import game.equipment.*;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaceWarhammer.StruggleStatisticsWarhammer;
import game.interfaces.IStatistics;
import game.interfaces.IStruggleStatistics;
import game.interfaces.Statistics;

import java.util.ArrayList;
import java.util.List;

public class EntityManager {
    private List<Monster> monsterList = new ArrayList<>();
    private List<NPC> NPCList = new ArrayList<>();
    private List<PlayerCharacter> playerCharacterList = new ArrayList<>();
    private List<Creature> creatureList = new ArrayList<>();
    private PlayerCharacter playerCharacterWithAllItems;
    private PlayerCharacter defaultPlayerCharacter;
    private FileManager fileManager;

    public EntityManager(String gameName) {
        fileManager = new FileManager(gameName);
        defaultPlayerCharacter = new PlayerCharacter(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
        playerCharacterWithAllItems = new PlayerCharacter(new StatisticsWarhammer(),
                new Inventory(new Weapon("Sword", 0, 0, 0, 0,0 ,0),
                              new Armor("Armor", 0), new Mount("Benek", 0)),
                new Experience(0), new StruggleStatisticsWarhammer());
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

    public void removeMonster(Monster monster){
        monsterList.remove(monster);
    }
    public void removeNPC(NPC npc){
        NPCList.remove(npc);
    }
    public void removePC(PlayerCharacter playerCharacter){
        playerCharacterList.remove(playerCharacter);
    }
    public void removeItem(Item item){
        playerCharacterWithAllItems.getInventory().removeItem(item);
    }


    public void addMonster(Monster monster){
        monsterList.add(monster);
    }
    public void addNPC(NPC npc){
        NPCList.add(npc);
    }
    public void addPC(PlayerCharacter playerCharacter){
        playerCharacterList.add(playerCharacter);
    }

    public void addItem(Item item){
        playerCharacterWithAllItems.getInventory().addItem(item);
    }
}


