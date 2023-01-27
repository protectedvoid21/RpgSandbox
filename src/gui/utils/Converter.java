package gui.utils;

import game.creature.*;
import game.creature.Character;
import game.equipment.*;
import game.interfaceWarhammer.AttributeEnum;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaceWarhammer.StruggleStatisticsWarhammer;
import game.utils.ErrorValidationChecker;
import game.utils.MathHelper;
import gui.card.CardContentDataSet;
import gui.card.fullCards.abstractCards.Card;
import gui.factories.WarhammerData;
import gui.utils.StringAdapter;
import jdk.jshell.spi.ExecutionControl;
import game.cardManager.Warhammer.*;

import java.util.*;

public class Converter implements WarhammerData, AbstractConverter {

    private static ErrorValidationChecker errorValidationChecker = new ErrorValidationChecker();

    public ErrorValidationChecker getErrorValidationChecker() {
        return errorValidationChecker;
    }

    //widoki entries i basic
    public CardContentDataSet convertCreatureToDataSetInBasicCard(Creature creature) {

        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = creature.getObjectPathPicture();
        data.titleContent = creature.getName();
        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        map.add(new ArrayList<>(List.of(StringAdapter.getRelativePath("stats.png"))));
        if (creature instanceof Character) {
            map.add(new ArrayList<>(List.of(horsePath)));
            map.add(new ArrayList<>(List.of(armorPath)));
            map.add(new ArrayList<>(List.of(weaponPath)));
            map.add(new ArrayList<>(List.of(trolleyPath)));
        }

        for (int i = 0; i < map.size(); i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;
        return data;
    }

    public CardContentDataSet convertArmorsToDataSet(Character character) {
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = armorPath;
        data.titleContent = "Armor";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        for (var item : character.getInventory().getArmors()) {
            String armorName = item.getName();
            map.add(new ArrayList<>(Arrays.asList(item.getItemPathPicture(), armorName, "DETAILS")));
        }

        for (int i = 0; i < map.size(); i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }
    public static CardContentDataSet convertItemsToDataSet(Character character) {
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = trolleyPath;
        data.titleContent = "Items";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        for (var item : character.getInventory().getDisposableItems()) {
            map.add(new ArrayList<>(Arrays.asList(item.getItemPathPicture(), item.getName(), "DETAILS")));
        }

        for (int i = 0; i < map.size(); i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    public CardContentDataSet convertWeaponsToDataSet(Character character) {
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = weaponPath;
        data.titleContent = "Weapon";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        for (var weapon : character.getInventory().getWeapons()) {
            String weaponName = weapon.getName();
            map.add(new ArrayList<>(Arrays.asList(weapon.getItemPathPicture(), weaponName, "DETAILS")));
        }

        for (int i = 0; i < map.size(); i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    public CardContentDataSet convertMountsToDataSet(Character character) {
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = horsePath;
        data.titleContent = "Mount";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        for (var mount : character.getInventory().getMounts()) {
            String mountName = mount.getName();
            map.add(new ArrayList<>(Arrays.asList(mount.getItemPathPicture(), mountName, "DETAILS")));
        }
        for (int i = 0; i < map.size(); i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    public CardContentDataSet convertStatsToDataSet(Creature creature) {
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = statsPath;
        data.titleContent = "Attributes";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();
//        map.add(new ArrayList<>(Arrays.asList("name", creature.getName())));

        for (var attribute : AttributeEnum.values()) {
            String attibuteName = attribute.name().replace("_", " ");//chyba bedzie git jak cos ten tego to usunac replace
            var value = creature.getStatistics().getAttribute(attribute).getValue();
            String attributeValue = Integer.toString(value);
            map.add(new ArrayList<>(Arrays.asList(attibuteName, attributeValue)));
        }
//        map.add(new ArrayList<>(Arrays.asList("path", creature.getObjectPathPicture())));

        for (int i = 0; i < map.size(); i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    public HashMap<Card.CardTypes, ArrayList<CardContentDataSet>> createFullDetailDataCreature(Creature basecreature) {
        var map = new LinkedHashMap<Card.CardTypes, ArrayList<CardContentDataSet>>();
    System.out.println("fsdfs");
        if (basecreature instanceof Character creature) {
            var armorlist = new ArrayList<CardContentDataSet>();
            for (var armor : creature.getInventory().getArmors()) {
                armorlist.add(detailsView(armor));
            }
            map.put(Card.CardTypes.ARMOR, armorlist);

            var mountList = new ArrayList<CardContentDataSet>();
            for (var mount : creature.getInventory().getMounts()) {
                mountList.add(detailsView(mount));
            }
            map.put(Card.CardTypes.MOUNT, mountList);

            var weaponList = new ArrayList<CardContentDataSet>();
            for (var weapon : creature.getInventory().getWeapons()) {
                weaponList.add(detailsView(weapon));
            }
            map.put(Card.CardTypes.WEAPONS, weaponList);

            var itemsList = new ArrayList<CardContentDataSet>();
            System.out.println(creature);System.out.println(creature.getInventory().getDisposableItems());

            for (var item : creature.getInventory().getDisposableItems()) {
                itemsList.add(detailsItemView(item));
            }
            System.out.println(itemsList);
            map.put(Card.CardTypes.ITEMS, itemsList);//todo to change on items
        }
        return map;
    }


    public LinkedHashMap<Card.CardTypes, CardContentDataSet> createFullDataCreature(Creature creature) {
        var map = new LinkedHashMap<Card.CardTypes, CardContentDataSet>();
        if (creature instanceof Character) {
            map.put(Card.CardTypes.OVERALL, convertCreatureToDataSetInBasicCard(creature));
            map.put(Card.CardTypes.ATTRIBUTE, convertStatsToDataSet(creature));
            map.put(Card.CardTypes.MOUNT, convertMountsToDataSet((Character) creature));
            map.put(Card.CardTypes.ARMOR, convertArmorsToDataSet((Character) creature));
            map.put(Card.CardTypes.WEAPONS, convertWeaponsToDataSet((Character) creature));
            map.put(Card.CardTypes.ITEMS, convertItemsToDataSet((Character) creature));
        }
        if (creature instanceof Monster) {
            map.put(Card.CardTypes.OVERALL, convertCreatureToDataSetInBasicCard(creature));
            map.put(Card.CardTypes.ATTRIBUTE, convertStatsToDataSet(creature));
        }

        //todo rest of possiblities
        return map;
    }

    // koniec
    //entries card
    public CardContentDataSet createWeaponInEntriesCard() {
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = weaponPath;
        data.titleContent = "Weapon";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        String name = "";
        String damage = "";
        String range = "";
        map.add(new ArrayList<>(Arrays.asList("name", name)));
        map.add(new ArrayList<>(Arrays.asList("damage", damage)));
        map.add(new ArrayList<>(Arrays.asList("range", range)));

        for (int i = 0; i < map.size(); i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    public CardContentDataSet createArmorInEntriesCard() {
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = armorPath;
        data.titleContent = "Armor";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        String name = "";
        String defence = "";
        map.add(new ArrayList<>(Arrays.asList("name", name)));
        map.add(new ArrayList<>(Arrays.asList("defence", defence)));

        for (int i = 0; i < map.size(); i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    public CardContentDataSet createMountInEntriesCard() {
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = horsePath;
        data.titleContent = "Mount";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        String name = "";
        String speed = "";
        map.add(new ArrayList<>(Arrays.asList("name", name)));
        map.add(new ArrayList<>(Arrays.asList("speed", speed)));

        for (int i = 0; i < map.size(); i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    public CardContentDataSet addNewItemInEntriesCard(Character character) {
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = trolleyPath;
        data.titleContent = "Items";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        System.out.println("NOT IMPLEMENTED");
        //todo fix inventory filtering due to previous Inventory class changes
        /*for (var item : character.getInventory().getItems()) {
            if (item instanceof ManyUsageItem) {
                String path = "src/gui/" + item.getClass().getSimpleName() + ".png";
                map.add(new ArrayList<>(Arrays.asList(path, ((ManyUsageItem) item).getName(), "DETAILS", "")));
            }
        }*/

        for (int i = 0; i < map.size(); i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    public CardContentDataSet editWeaponInEntriesCard(Weapon weapon) {
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = weapon.getItemPathPicture();
        data.titleContent = weapon.getName();

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        String name = "";
        int damage = weapon.getDamage();
        int range = weapon.getRange();
        map.add(new ArrayList<>(Arrays.asList("damage", Integer.toString(damage))));
        map.add(new ArrayList<>(Arrays.asList("range", Integer.toString(range))));

        for (int i = 0; i < map.size(); i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    public CardContentDataSet editArmorInEntriesCard(Armor armor) {
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = armor.getItemPathPicture();
        data.titleContent = armor.getName();
        System.out.println(data.titlePath+"jajaj");

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        String name = "";
        int defence = armor.getDefence();
        map.add(new ArrayList<>(Arrays.asList("defence", Integer.toString(defence))));

        for (int i = 0; i < map.size(); i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    public CardContentDataSet editMountInEntriesCard(Mount mount) {
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = mount.getItemPathPicture();
        data.titleContent = mount.getName();

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        String name = mount.getName();
        int speed = mount.getSpeed();
        map.add(new ArrayList<>(Arrays.asList("speed", Integer.toString(speed))));

        for (int i = 0; i < map.size(); i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    public CardContentDataSet createMonsterInEntriesCard() {
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = monsterPath;
        data.titleContent = "";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        map.add(new ArrayList<>(Arrays.asList(statsPath)));
        map.add(new ArrayList<>(Arrays.asList(efectPath)));

        for (int i = 0; i < map.size(); i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    public CardContentDataSet createPlayerCharacterInEntriesCard() {
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = playerImagePath;
        data.titleContent = "";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        map.add(new ArrayList<>(Arrays.asList(statsPath)));
        map.add(new ArrayList<>(Arrays.asList(efectPath)));
        map.add(new ArrayList<>(Arrays.asList(horsePath)));
        map.add(new ArrayList<>(Arrays.asList(armorPath)));
        map.add(new ArrayList<>(Arrays.asList(weaponPath)));

        for (int i = 0; i < map.size(); i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    public CardContentDataSet createNPCInEntriesCard() {
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = npcImage;
        data.titleContent = "";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        map.add(new ArrayList<>(Arrays.asList(statsPath)));
        map.add(new ArrayList<>(Arrays.asList(efectPath)));
        map.add(new ArrayList<>(Arrays.asList(horsePath)));
        map.add(new ArrayList<>(Arrays.asList(armorPath)));
        map.add(new ArrayList<>(Arrays.asList(weaponPath)));

        for (int i = 0; i < map.size(); i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    public CardContentDataSet detailsView(ManyUsageItem item) {
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = "src/gui/" + item.getClass().getSimpleName() + ".png";//todo
        data.titleContent = item.getName();

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        if (item instanceof Armor) {
            var defence = ((Armor) item).getDefence();
            map.add(new ArrayList<>(Arrays.asList("defence", Integer.toString(defence))));
        } else if (item instanceof Weapon) {
            var damage = ((Weapon) item).getDamage();
            var range = ((Weapon) item).getRange();
            map.add(new ArrayList<>(Arrays.asList("damage", Integer.toString(damage))));
            map.add(new ArrayList<>(Arrays.asList("range", Integer.toString(range))));
        } else if (item instanceof Mount) {
            var speed = ((Mount) item).getSpeed();
            map.add(new ArrayList<>(Arrays.asList("speed", Integer.toString(speed))));
        }

        for (int i = 0; i < map.size(); i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }
    public static CardContentDataSet detailsItemView(DisposableItem item) {
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = item.getItemPathPicture();//todo
        data.titleContent = item.getName();

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();
        map.add(new ArrayList<>(Collections.singletonList(item.getDescription())));

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    public CardContentDataSet smallCharacterCards(Character character) {
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = "src/gui/" + character.getClass().getSimpleName() + ".png";
        data.titleContent = character.getName();

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        int mountCount = character.getInventory().getMounts().size();
        int weaponCount = character.getInventory().getWeapons().size();
        int armorCount = character.getInventory().getArmors().size();

        map.add(new ArrayList<>(Arrays.asList(horsePath, Integer.toString(mountCount))));
        map.add(new ArrayList<>(Arrays.asList(armorPath, Integer.toString(armorCount))));
        map.add(new ArrayList<>(Arrays.asList(weaponPath, Integer.toString(weaponCount))));

        Random randomGenerator = new Random();
        int statsSecretValue = 0;
        int cnt = 0;
        for (var attribute : AttributeEnum.values()) {
            var value = character.getStatistics().getAttribute(attribute).getValue();
            if (value != 0) {
                statsSecretValue += value;
                cnt++;
            }
        }

        statsSecretValue /= cnt;
        statsSecretValue += randomGenerator.nextInt(4, 22);

        map.add(new ArrayList<>(Arrays.asList(statsPath, Integer.toString(statsSecretValue))));

        return data;
    }

    public Weapon createWeaponFromCard(CardContentDataSet data) {
        String name = data.titleContent;
        setValidationOfNameAndPath(name, data.titlePath);
        int damage = 0;
        int range = 0;
        for (var parameter : data.content) {
            if (parameter.get(0).equals("damage")) {
                if (MathHelper.isNumeric(parameter.get(1))) {
                    damage = Integer.parseInt(parameter.get(1));
                } else {
                    errorValidationChecker.addIntexToErrorList(data.content.indexOf(parameter));
                }
            }
            if (parameter.get(0).equals("range")) {
                if (MathHelper.isNumeric(parameter.get(1))) {
                    range = Integer.parseInt(parameter.get(1));
                } else {
                    errorValidationChecker.addIntexToErrorList(data.content.indexOf(parameter));
                }
            }
        }
        Weapon weapon = new Weapon(name, damage, range);
        weapon.setItemPathPicture(data.titlePath);
        return weapon;
    }

    public Armor createArmorFromCard(CardContentDataSet data) {
        String name = data.titleContent;
        setValidationOfNameAndPath(name, data.titlePath);
        int defence = 0;
        for (var parameter : data.content) {
            if (parameter.get(0).equals("defence")) {
                if (MathHelper.isNumeric(parameter.get(1))) {
                    defence = Integer.parseInt(parameter.get(1));
                } else {
                    errorValidationChecker.addIntexToErrorList(data.content.indexOf(parameter));
                }
            }
        }
        Armor armor = new Armor(name, defence);
        armor.setItemPathPicture(data.titlePath);
        return armor;
    }

    public void setValidationOfNameAndPath(String name, String path) {
        System.out.println(path);
        if (name.isEmpty()) {
            errorValidationChecker.setNameErrorOnTrue();
        }
        if (path.isEmpty()) {
            errorValidationChecker.setPathErrorOnTrue();
        }
    }

    public Mount createMountFromCard(CardContentDataSet data) {
        String name = data.titleContent;
        setValidationOfNameAndPath(name, data.titlePath);
        int speed = 0;
        for (var parameter : data.content) {
            if (parameter.get(0).equals("speed")) {
                if (MathHelper.isNumeric(parameter.get(1))) {
                    speed = Integer.parseInt(parameter.get(1));
                } else {
                    errorValidationChecker.addIntexToErrorList(data.content.indexOf(parameter));
                }
            }
        }

        Mount mount = new Mount(name, speed);
        mount.setItemPathPicture(data.titlePath);
        return mount;
    }

    public PlayerCharacter createPlayerCharacterFromCard(CardContentDataSet data) {
        ArrayList<String> stats = new ArrayList<>();
        stats.add(data.titleContent);
        for (var attributeList : data.content)
            stats.add(attributeList.get(1));
        stats.add(data.titlePath);
        PCFactoryWarhammer PCfactory = new PCFactoryWarhammer();
        return PCfactory.creat(stats);
    }

    public NPC createNPCFromCard(CardContentDataSet data) {
        ArrayList<String> stats = new ArrayList<>();
        stats.add(data.titleContent);
        for (var attributeList : data.content)
            stats.add(attributeList.get(1));
        stats.add(data.titlePath);
        NPCFactoryWarhammer NPCfactory = new NPCFactoryWarhammer();
        return NPCfactory.creat(stats);
    }

    public Monster createMonsterFromCard(CardContentDataSet data) {
        ArrayList<String> stats = new ArrayList<>();
        stats.add(data.titleContent);
        for (var attributeList : data.content) {
            stats.add(attributeList.get(1));
        }

        stats.add(data.titlePath);
        MonsterFactoryWarhammer monsterFactory = new MonsterFactoryWarhammer();
        return monsterFactory.creat(stats);
    }

    public void main(String[] args) {
        CardContentDataSet w1 = createWeaponInEntriesCard();
        w1.content.get(0).set(1, "www1");
        w1.content.get(1).set(1, "20");
        w1.content.get(2).set(1, "6");
        w1.content.get(2).set(1, "6t");
        Weapon w1Res = createWeaponFromCard(w1);

        CardContentDataSet npc1 = createNPCInEntriesCard();
        npc1.titleContent = "BAddfg";
        NPC npc1Res = createNPCFromCard(npc1);

        Weapon weapon = new Weapon("weapon1", 100, 10);
        Mount mount = new Mount("horse1", 20);
        Mount mount1 = new Mount("horse2", 30);
        Mount mount2 = new Mount("horse3", 40);
        Armor armor = new Armor("armor1", 45);
        Inventory inventory = new Inventory();
        inventory.addItem(weapon);
        inventory.addItem(mount);
        inventory.addItem(mount1);
        inventory.addItem(mount2);
        inventory.addItem(armor);
        PlayerCharacter playerCharacter = new PlayerCharacter(new StatisticsWarhammer(), inventory,
                new Experience(10), new StruggleStatisticsWarhammer());
        playerCharacter.setName("Shgjehrk");
        playerCharacter.setObjectPathPicture(playerImagePath);

        convertMountsToDataSet(playerCharacter);

        Monster monster = new Monster(new StatisticsWarhammer(), new Experience(10), new StruggleStatisticsWarhammer());
        MonsterFactoryWarhammer mF = new MonsterFactoryWarhammer();
        ArrayList<String> test1 = new ArrayList<>();
        test1.add("Khafil");
        for (int i = 1; i < 13; i++)
            test1.add(Integer.toString(i));
        test1.add("pathimage.png");
        System.out.println(test1.size());
        Monster m1 = mF.creat(test1);
        Monster m2 = createMonsterFromCard(convertStatsToDataSet(m1));

    }
}
