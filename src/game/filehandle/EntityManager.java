package game.filehandle;

import game.board.Scenario;
import game.creature.*;
import game.creature.Character;
import game.equipment.*;
import game.equipment.examples.*;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaceWarhammer.StruggleStatisticsWarhammer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EntityManager {
    private List<Monster> monsterList = new ArrayList<>();
    private List<NPC> NPCList = new ArrayList<>();
    private List<PlayerCharacter> playerCharacterList = new ArrayList<>();
    private List<Scenario> scenarioList = new ArrayList<>();

    private List<Weapon> weaponList = new ArrayList<>();
    private List<Mount> mountList = new ArrayList<>();
    private List<Armor> armorList = new ArrayList<>();
    private List<DisposableItem> disposableItemList = new ArrayList<>();

    private Character playerCharacterWithAllItems;

    private FileManager fileManager;

    private static EntityManager instance;

    public EntityManager(String gameName) {
        if (instance == null) {
            instance = this;
        }

        fileManager = new FileManager(gameName);
        generateListOfItems();
        loadAllEntities();
    }

    public static EntityManager getInstance() {
        return instance;
    }

    public List<DisposableItem> getDisposableItemList() {
        return disposableItemList;
    }

    public void saveAllEntities() {
        fileManager.writeToFile(monsterList, Monster.class);
        fileManager.writeToFile(NPCList, NPC.class);
        fileManager.writeToFile(playerCharacterList, PlayerCharacter.class);
        fileManager.writeToFile(weaponList, Weapon.class);
        fileManager.writeToFile(mountList, Mount.class);
        fileManager.writeToFile(armorList, Armor.class);
        fileManager.writeToFile(scenarioList, Scenario.class);
    }

    public void loadAllEntities() {
        monsterList = fileManager.readFromFile(Monster.class);
        NPCList = fileManager.readFromFile(NPC.class);
        playerCharacterList = fileManager.readFromFile(PlayerCharacter.class);
        scenarioList = fileManager.readFromFile(Scenario.class);
        weaponList = fileManager.readFromFile(Weapon.class);
        armorList = fileManager.readFromFile(Armor.class);
        mountList = fileManager.readFromFile(Mount.class);

        playerCharacterWithAllItems = new PlayerCharacter(
                new StatisticsWarhammer(), new Inventory(weaponList, armorList, mountList, disposableItemList),
                new Experience(0), new StruggleStatisticsWarhammer());
    }

    private void generateListOfItems() {
        disposableItemList = new ArrayList<>(Arrays.asList(
                new Bandage(5), new DragonsBlood(5), new HolyWater(5),
                new ChickenLeg(5), new DeadRat(5),
                new JustNormalWater(5), new MagicPills(5),
                new MagicPotion(), new Sharpener(5), new CatInBag(3), new SnowBall(8),
                new WarmSocksFromGrandma(5), new HolyHandGrenadeofAntioch(1)));
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

    public List<Scenario> getScenarioList() {
        return scenarioList;
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public List<Mount> getMountList() {
        return mountList;
    }

    public List<Armor> getArmorList() {
        return armorList;
    }

    public Character getPlayerCharacterWithAllItems() {
        return playerCharacterWithAllItems;
    }

    public void addItem(Item item) {
        if (item instanceof Weapon) {
            weaponList.add((Weapon) item);
        }
        if (item instanceof Mount) {
            mountList.add((Mount) item);
        }
        if (item instanceof Armor) {
            armorList.add((Armor) item);
        }
        if (item instanceof DisposableItem) {
            disposableItemList.add((DisposableItem) item);
        }
    }

    public void removeItem(Item item) {
        if (item instanceof Weapon) {
            weaponList.remove(item);
        }
        if (item instanceof Mount) {
            mountList.remove(item);
        }
        if (item instanceof Armor) {
            armorList.remove(item);
        }
        if (item instanceof DisposableItem) {
            disposableItemList.remove(item);
        }
    }
}


