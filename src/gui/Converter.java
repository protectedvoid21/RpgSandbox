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
                String armorName = ((Armor)item).getName();
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
                String weaponName = ((Weapon)item).getName();
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
            if (item instanceof Mount){
                String mountName = ((Mount)item).getName();
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
        data.titleContent = "Items";

        var map = new ArrayList<ArrayList<String>>();
        ArrayList<CardContentDataSet.DataType> dataTypesList = new ArrayList<>();

        for (var item: character.getInventory().getItems()){
            if (item instanceof ManyUsageItem) {
                String path = "src/gui/" + item.getClass().getSimpleName() + ".png";
                map.add(new ArrayList<>(Arrays.asList(path, ((ManyUsageItem)item).getName(), "DETAILS", "")));
            }
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

    private static CardContentDataSet detalisView(ManyUsageItem item){
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
            map.add(new ArrayList<>(Arrays.asList("damage", Integer.toString(damage))));
            map.add(new ArrayList<>(Arrays.asList("range", Integer.toString(range))));
        }
        else if (item instanceof Mount){
            var speed= ((Mount) item).getSpeed();
            map.add(new ArrayList<>(Arrays.asList("speed", Integer.toString(speed))));
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
    private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }
    private static Weapon createWeaponFromCard(CardContentDataSet data){
        String className = data.titleContent;
        String name = "";
        int damage = 0;
        int range = 0;
        for (var parameter: data.content){
            if (parameter.get(0).equals("name")) {
                name = parameter.get(1);
            }
            if (parameter.get(0).equals("damage")) {
                if (isNumeric(parameter.get(1)))
                    damage = Integer.parseInt(parameter.get(1));
            }
            if (parameter.get(0).equals("range")) {
                if (isNumeric(parameter.get(1)))
                    range = Integer.parseInt(parameter.get(1));
            }
        }
        Weapon weapon = new Weapon(name, damage, range);
        return  weapon;
    }
    private static Armor createArmorFromCard(CardContentDataSet data){
        String className = data.titleContent;
        String name = "";
        int defence = 0;
        for (var parameter: data.content) {
            if (parameter.get(0).equals("name")) {
                name = parameter.get(1);
            }
            if (parameter.get(0).equals("defence")) {
                if (isNumeric(parameter.get(1)))
                    defence = Integer.parseInt(parameter.get(1));
            }
        }
        Armor armor = new Armor(name,defence);
        return  armor;
    }
    private static Mount createMountFromCard(CardContentDataSet data){
        String className = data.titleContent;
        String name = "";
        int speed = 0;
        for (var parameter: data.content){
            if (parameter.get(0).equals("name")) {
                name = parameter.get(1);
            }
            if (parameter.get(0).equals("speed")) {
                if (isNumeric(parameter.get(1)))
                    speed = Integer.parseInt(parameter.get(1));
            }
        }
        Mount mount = new Mount(name, speed);
        return  mount;
    }
    private static PlayerCharacter createPlayerCharacterFromCard(CardContentDataSet data){
        PlayerCharacter playerCharacter = new PlayerCharacter(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
        playerCharacter.setName(data.titleContent);
        return playerCharacter;
    }
    private static NPC createNPCFromCard(CardContentDataSet data){
        NPC npc = new NPC(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
        npc.setName(data.titleContent);
        return npc;
    }
    private static Monster createMonsterFromCard(CardContentDataSet data){
        Monster monster = new Monster(new StatisticsWarhammer(), new Experience(0), new StruggleStatisticsWarhammer());
        monster.setName(data.titleContent);
        return monster;
    }


    public static void main(String[] args) {
        CardContentDataSet w1 = createWeaponInEntriesCard();
        w1.content.get(0).set(1, "www1");
        w1.content.get(1).set(1, "20");
        w1.content.get(2).set(1, "6");
        w1.content.get(2).set(1,"6t");
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
        PlayerCharacter playerCharacter = new PlayerCharacter(new StatisticsWarhammer(), inventory, new Experience(10),new StruggleStatisticsWarhammer());
        playerCharacter.setName("Shgjehrk");
        playerCharacter.setObjectPathPicture("/src/gui/playerimage.png");

        convertMountsToDataSet(playerCharacter);

        Monster monster = new Monster(new StatisticsWarhammer(), new Experience(10), new StruggleStatisticsWarhammer());


    }
}
