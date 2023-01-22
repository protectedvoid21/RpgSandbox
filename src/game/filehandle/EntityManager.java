package game.filehandle;

import game.board.Scenario;
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
    private List<Item> itemList = new ArrayList<>();
    private List<Scenario> scenarioList = new ArrayList<>();

    private PlayerCharacter playerCharacterWithAllItems;
    private PlayerCharacter defaultPlayerCharacter;
    private FileManager fileManager;

    private static EntityManager instance;

    public EntityManager(String gameName) {
        if (instance == null) {
            instance = this;
        }

        fileManager = new FileManager(gameName);
        loadAllEntities();

        defaultPlayerCharacter = new PlayerCharacter(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
        playerCharacterWithAllItems = new PlayerCharacter(new StatisticsWarhammer(),
                new Inventory(new Weapon("Sword", 0, 0, 0, 0, 0, 0),
                        new Armor("Armor", 0), new Mount("Benek", 0)),
                new Experience(0), new StruggleStatisticsWarhammer());
    }

    public static EntityManager getInstance() {
        return instance;
    }

    public void saveAllEntities() {
        fileManager.writeToFile(monsterList, Monster.class);
        fileManager.writeToFile(NPCList, NPC.class);
        fileManager.writeToFile(playerCharacterList, PlayerCharacter.class);
        fileManager.writeToFile(itemList, Item.class);
        fileManager.writeToFile(scenarioList, Scenario.class);
    }

    private void loadAllEntities() {
        monsterList = fileManager.readFromFile(Monster.class);
        NPCList = fileManager.readFromFile(NPC.class);
        playerCharacterList = fileManager.readFromFile(PlayerCharacter.class);
        itemList = fileManager.readFromFile(Item.class);
        scenarioList = fileManager.readFromFile(Scenario.class);
    }

    public void addCreature(Creature creature) {
        if (creature instanceof Monster) {
            monsterList.add((Monster) creature);
        }
        if (creature instanceof PlayerCharacter) {
            playerCharacterList.add((PlayerCharacter) creature);
        }
        if (creature instanceof NPC) {
            NPCList.add((NPC) creature);
        }
    }

    public void removeCreature(Creature creature) {
        if (creature instanceof Monster) {
            monsterList.remove((Monster) creature);
        }
        if (creature instanceof PlayerCharacter) {
            playerCharacterList.remove((PlayerCharacter) creature);
        }
        if (creature instanceof NPC) {
            NPCList.remove((NPC) creature);
        }
    }

    public void addScenario(Scenario scenario) {
        scenarioList.add(scenario);
    }

    public void removeScenario(Scenario scenario) {
        scenarioList.remove(scenario);
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }

    public List<NPC> getNPCList() {
        return NPCList;
    }

    public List<PlayerCharacter> getPlayerCharacterList() {
        return playerCharacterList;
    }
    
    public List<Item> getItemList() {
        return itemList;
    }

    public List<Scenario> getScenarioList() {
        return scenarioList;
    }

    public void removeItem(Item item) {
        playerCharacterWithAllItems.getInventory().removeItem(item);
    }

    public void addItem(Item item) {
        playerCharacterWithAllItems.getInventory().addItem(item);
    }
}


