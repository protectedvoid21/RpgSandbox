package gui;

import game.creature.*;
import game.creature.Character;
import game.equipment.*;
import game.interfaceWarhammer.AttributeEnum;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaceWarhammer.StruggleStatisticsWarhammer;
import game.interfaces.IStatistics;
import gui.card.CardContentDataSet;
import java.util.*;

import static game.interfaceWarhammer.AttributeEnum.*;


public class Converter {
    //widoki entries i basic
    private static CardContentDataSet convertCreatureToDataSetInBasicCard(Creature creature){

        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = "src/gui/"+creature.getClass().getSimpleName()+"image.png";
        data.titleContent = creature.getName();

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        map.add(new ArrayList<>(Arrays.asList("src/gui/stats.png")));
        map.add(new ArrayList<>(Arrays.asList("src/gui/effect.png")));

        if (creature instanceof Character){
            map.add(new ArrayList<>(Arrays.asList("src/gui/horse.png")));
            map.add(new ArrayList<>(Arrays.asList("src/gui/armor.png")));
            map.add(new ArrayList<>(Arrays.asList("src/gui/weapon.png")));
        }

        for (int i = 0; i< map.size();i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;
        return data;
    }

    private static CardContentDataSet convertArmorsToDataSet(Character character){
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = "src/gui/armor.png";
        data.titleContent = "Armor";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        for (var item: character.getInventory().getItems()) {
            if (item instanceof Armor){
                String armorName = item.getName();
                map.add(new ArrayList<>(Arrays.asList("gui/src/armor.png",armorName, "DETAILS")));
            }
        }


        for (int i = 0; i< map.size();i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    private static CardContentDataSet convertWeaponsToDataSet(Character character){
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = "src/gui/weapon.png";
        data.titleContent = "Weapon";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        for (var item: character.getInventory().getItems()) {
            if (item instanceof Weapon){
                String weaponName = item.getName();
                map.add(new ArrayList<>(Arrays.asList("gui/src/weapon.png",weaponName, "DETAILS")));
            }
        }

        for (int i = 0; i< map.size();i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    private static CardContentDataSet convertMountsToDataSet(Character character){
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = "src/gui/horse.png";
        data.titleContent = "Mount";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        for (var item: character.getInventory().getItems()) {
            if (item instanceof Armor){
                String mountName = item.getName();
                map.add(new ArrayList<>(Arrays.asList("gui/src/horse.png",mountName, "DETAILS")));
            }
        }
        for (int i = 0; i< map.size();i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    private static CardContentDataSet convertStatsToDataSet(Creature creature){
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = "src/gui/attributes.png";
        data.titleContent = "Attributes";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        int cnt = 0;
        for (var attribute: AttributeEnum.values()){
            String attibuteName = attribute.name();
            var value = creature.getStatistics().getAttribute(attribute).getValue();
            String attributeValue = Integer.toString(value);
            if (value!=0) {
                map.add(new ArrayList<>(Arrays.asList(attibuteName, attributeValue)));
                cnt ++;
            }
            if (cnt ==6)
                break;
        }

        for (int i = 0; i< map.size();i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }
    // koniec
    //entries card
    private static CardContentDataSet createWeaponInEntriesCard(){
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = "src/gui/weapon.png";
        data.titleContent = "Weapon";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        String name = "";
        String damage = "";
        String range = "";
        map.add(new ArrayList<>(Arrays.asList("name", name)));
        map.add(new ArrayList<>(Arrays.asList("damage", damage)));
        map.add(new ArrayList<>(Arrays.asList("range", range)));

        for (int i = 0; i< map.size();i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    private static CardContentDataSet createArmorInEntriesCard(){
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = "src/gui/armor.png";
        data.titleContent = "Armor";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        String name = "";
        String defence = "";
        map.add(new ArrayList<>(Arrays.asList("name", name)));
        map.add(new ArrayList<>(Arrays.asList("defence", defence)));

        for (int i = 0; i< map.size();i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    private static CardContentDataSet createMountInEntriesCard(){
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = "src/gui/horse.png";
        data.titleContent = "Mount";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        String name = "";
        String speed = "";
        map.add(new ArrayList<>(Arrays.asList("name", name)));
        map.add(new ArrayList<>(Arrays.asList("speed", speed)));

        for (int i = 0; i< map.size();i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    private static CardContentDataSet addNewItemInEntriesCard(Character character){
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = "src/gui/item.png";
        data.titleContent = "item";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        for (var item: character.getInventory().getItems()){
            String path = "src/gui/" + item.getClass().getSimpleName() + ".png";
            map.add(new ArrayList<>(Arrays.asList(path, item.getName(), "DETAILS", "")));
        }

        for (int i = 0; i< map.size();i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }
    private static CardContentDataSet editWeaponInEntriesCard(Weapon weapon){
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = "src/gui/weapon.png";
        data.titleContent = "Weapon";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        String name = "";
        int damage = weapon.getDamage();
        int range = weapon.getRange();
        map.add(new ArrayList<>(Arrays.asList("name", name)));
        map.add(new ArrayList<>(Arrays.asList("damage", Integer.toString(damage))));
        map.add(new ArrayList<>(Arrays.asList("range", Integer.toString(range))));

        for (int i = 0; i< map.size();i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    private static CardContentDataSet editArmorInEntriesCard(Armor armor){
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = "src/gui/armor.png";
        data.titleContent = "Armor";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        String name = "";
        int defence = armor.getDefence();
        map.add(new ArrayList<>(Arrays.asList("name", name)));
        map.add(new ArrayList<>(Arrays.asList("defence", Integer.toString(defence))));

        for (int i = 0; i< map.size();i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    private static CardContentDataSet editMountInEntriesCard(Mount mount){
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = "src/gui/horse.png";
        data.titleContent = "Mount";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        String name = mount.getName();
        int speed = mount.getSpeed();
        map.add(new ArrayList<>(Arrays.asList("name", name)));
        map.add(new ArrayList<>(Arrays.asList("speed", Integer.toString(speed))));

        for (int i = 0; i< map.size();i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    private static CardContentDataSet createMonsterInEntriesCard(){
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = "src/gui/monsterimage.png";
        data.titleContent = "";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        map.add(new ArrayList<>(Arrays.asList("src/gui/stats.png")));
        map.add(new ArrayList<>(Arrays.asList("src/gui/effect.png")));

        for (int i = 0; i< map.size();i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    private static CardContentDataSet createPlayerCharacterInEntriesCard(){
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = "src/gui/player.png";
        data.titleContent = "";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        map.add(new ArrayList<>(Arrays.asList("src/gui/stats.png")));
        map.add(new ArrayList<>(Arrays.asList("src/gui/effect.png")));
        map.add(new ArrayList<>(Arrays.asList("src/gui/horse.png")));
        map.add(new ArrayList<>(Arrays.asList("src/gui/armor.png")));
        map.add(new ArrayList<>(Arrays.asList("src/gui/weapon.png")));

        for (int i = 0; i< map.size();i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    private static CardContentDataSet createNPCInEntriesCard(){
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = "src/gui/NPC.png";
        data.titleContent = "";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        map.add(new ArrayList<>(Arrays.asList("src/gui/stats.png")));
        map.add(new ArrayList<>(Arrays.asList("src/gui/effect.png")));
        map.add(new ArrayList<>(Arrays.asList("src/gui/horse.png")));
        map.add(new ArrayList<>(Arrays.asList("src/gui/armor.png")));
        map.add(new ArrayList<>(Arrays.asList("src/gui/weapon.png")));

        for (int i = 0; i< map.size();i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    private static CardContentDataSet detalisView(Item item){
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = "src/gui/"+item.getClass().getSimpleName()+".png";
        data.titleContent = item.getName();

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        if (item instanceof Armor){
            var defence= ((Armor) item).getDefence();
            map.add(new ArrayList<>(Arrays.asList("defence", Integer.toString(defence))));
        }
        else if (item instanceof Weapon){
            var damage= ((Weapon) item).getDamage();
            var range= ((Weapon) item).getRange();
            map.add(new ArrayList<>(Arrays.asList("defence", Integer.toString(damage))));
            map.add(new ArrayList<>(Arrays.asList("range", Integer.toString(range))));
        }
        else if (item instanceof Mount){
            var speed= ((Mount) item).getSpeed();
            map.add(new ArrayList<>(Arrays.asList("defence", Integer.toString(speed))));
        }

        for (int i = 0; i< map.size();i++)
            dataTypesList.add(CardContentDataSet.DataType.STRING);

        data.content = map;
        data.dataType = dataTypesList;

        return data;
    }

    private static CardContentDataSet smallCharacterCards(Character character){
        CardContentDataSet data = new CardContentDataSet();
        data.titlePath = "src/gui/"+character.getClass().getSimpleName()+".png";
        data.titleContent = character.getName();

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        int mountCnt = 0;
        int weaponCnt = 0;
        int armorCnt = 0;

        for (var item: character.getInventory().getItems()){
            if (item instanceof Mount)
                mountCnt++;
            else if (item instanceof Weapon)
                weaponCnt++;
            else if (item instanceof Armor)
                armorCnt++;
        }

        map.add(new ArrayList<>(Arrays.asList("src/gui/horse.png", Integer.toString(mountCnt))));
        map.add(new ArrayList<>(Arrays.asList("src/gui/armor.png", Integer.toString(armorCnt))));
        map.add(new ArrayList<>(Arrays.asList("src/gui/weapon.png", Integer.toString(weaponCnt))));

        Random randomGenerator = new Random();
        int statsSecretValue = 0;
        int cnt = 0;
        for (var attribute: AttributeEnum.values()){
            var value = character.getStatistics().getAttribute(attribute).getValue();
            if (value != 0) {
                statsSecretValue += value;
                cnt++;
            }
        }

        statsSecretValue/=cnt;
        statsSecretValue += randomGenerator.nextInt(4,22);

        map.add(new ArrayList<>(Arrays.asList("src/gui/stats.png", Integer.toString(statsSecretValue))));

        return data;
    }



    public static void main(String[] args) {
        Weapon weapon = new Weapon("weapon1", 100, 10);
        Mount mount = new Mount("horse", 20);
        Armor armor = new Armor("armor1", 45);
        Inventory inventory = new Inventory();
        inventory.addItem(weapon);
        inventory.addItem(mount);
        inventory.addItem(armor);
        PlayerCharacter playerCharacter = new PlayerCharacter(new StatisticsWarhammer(), inventory, new Experience(10),new StruggleStatisticsWarhammer());
        playerCharacter.setName("Shgjehrk");
        playerCharacter.setObjectPathPicture("/src/gui/playerimage.png");

        convertCreatureToDataSetInBasicCard(playerCharacter);

        System.out.println("\n\n\n\n");
        Monster monster = new Monster(new StatisticsWarhammer(), new Experience(10), new StruggleStatisticsWarhammer());


    }
}
