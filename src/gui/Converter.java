package gui;

import game.creature.*;
import game.creature.Character;
import game.equipment.*;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaceWarhammer.StruggleStatisticsWarhammer;
import game.interfaces.IStatistics;
import game.interfaces.IStruggleStatistics;
import gui.card.CardContentDataSet;

import java.lang.reflect.Method;
import java.util.*;


public class Converter {
    private static CardContentDataSet convertCreatureToFirstView(Creature creature){
        HashMap<String,String> data = new HashMap<>();

        Integer speed = creature.getSpeed();
        data.put("Speed", speed.toString());
        String name = creature.getName();
        data.put("Name", name);var map = new ArrayList<ArrayList<String>>();
        String path = creature.getObjectPathPicture();
        data.put("Path", path);

        CardContentDataSet dataSet = new CardContentDataSet();
        dataSet.titlePath = data.get("Path");
        dataSet.titlePath = "src/gui/"+creature.getClass().getSimpleName()+"image.png";
        dataSet.titleContent = data.get("Name");



        map.add(new ArrayList<>(Arrays.asList("src/gui/stats.png")));
        map.add(new ArrayList<>(Arrays.asList("src/gui/effect.png")));

        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();
        dataTypesList.add(CardContentDataSet.DataType.STRING);
        dataTypesList.add(CardContentDataSet.DataType.STRING);

        if (creature instanceof Character){
            map.add(new ArrayList<>(Arrays.asList("src/gui/horse.png")));
            map.add(new ArrayList<>(Arrays.asList("src/gui/item.png")));
            map.add(new ArrayList<>(Arrays.asList("src/gui/armor.png")));
            map.add(new ArrayList<>(Arrays.asList("src/gui/weapon.png")));
            dataTypesList.add(CardContentDataSet.DataType.STRING);
            dataTypesList.add(CardContentDataSet.DataType.STRING);
            dataTypesList.add(CardContentDataSet.DataType.STRING);
            dataTypesList.add(CardContentDataSet.DataType.STRING);


        }
        dataSet.content = map;

        dataSet.dataType = dataTypesList;


        return dataSet;
    }


    private static CardContentDataSet convertCreatureToDataSet(Creature creature) throws SecurityException {
        HashMap<String,String> data = new HashMap<>();

        CardContentDataSet dataSet = new CardContentDataSet();

        Integer speed = creature.getSpeed();
        data.put("Speed", speed.toString());
        String name = creature.getName();
        data.put("Name", name);
        String path = creature.getObjectPathPicture();
        data.put("Path", path);


        HashMap<String, String > experience = new HashMap<>();
        Integer ex = creature.getExperience().getExperience();
        Integer lvl = creature.getExperience().getLevel();
        experience.put("Experience", ex.toString());
        experience.put("Level", lvl.toString());

        HashMap<String, String> inventory = new HashMap<>();
        if (creature instanceof Character){
            Character character = (Character) creature;
            for (Item item: character.getInventory().getItems()){
                if (item instanceof ManyUsageItem) {
                    inventory.put(item.getClass().getSimpleName(),((ManyUsageItem) item).getName() );
                }
            }
        }
        var map = new ArrayList<ArrayList<String>>();

        for (Map.Entry<String, String> set: data.entrySet() ){
            String attribute = set.getKey();
            String value = set.getValue();
            map.add(new ArrayList<>(Arrays.asList(attribute, value)));
        }

        dataSet.dataType = new ArrayList<>(Arrays.asList(CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.STRING, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN));


        dataSet.content = map;

        return dataSet;
    }



    public static void main(String[] args) throws java.lang.NoSuchMethodException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        Weapon weapon = new Weapon("weapon1", 100, 10);
        Mount mount = new Mount("horse", 20);
        Armor armor = new Armor("armor1", 45);
        Inventory inventory = new Inventory();
        inventory.addItem(weapon);
        inventory.addItem(mount);
        inventory.addItem(armor);
        PlayerCharacter playerCharacter = new PlayerCharacter(new StatisticsWarhammer(), inventory, new Experience(10),new StruggleStatisticsWarhammer());
        //CommonBasicView(playerCharacter);
        playerCharacter.setName("Shgjehrk");
        playerCharacter.setObjectPathPicture("/src/gui/playerimage.png");

        //convertCreatureToDataSet(playerCharacter);
        convertCreatureToFirstView(playerCharacter);

        System.out.println("\n\n\n\n");
        Monster monster = new Monster(new StatisticsWarhammer(), new Experience(10), new StruggleStatisticsWarhammer());
        //convertCreatureToDataSet(monster);



    }
}
