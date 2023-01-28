package gui.utils;

import game.cardManager.NPCFactory;
import game.cardManager.PCFactory;
import game.cardManager.Warhammer.MonsterFactoryWarhammer;
import game.creature.Character;
import game.creature.*;
import game.equipment.*;
import game.interfaceWarhammer.AttributeEnum;
import game.utils.ErrorValidationChecker;
import game.utils.MathHelper;
import gui.card.CardContentDataSet;
import gui.card.fullCards.abstractCards.Card;
import gui.factories.TextData;
import gui.factories.WarhammerData;

import java.util.*;

public class Converter implements WarhammerData, AbstractConverter, TextData {

    private static final ErrorValidationChecker errorValidationChecker = new ErrorValidationChecker();

    public ErrorValidationChecker getErrorValidationChecker() {
        return errorValidationChecker;
    }

    public CardContentDataSet convertCreatureToDataSetInBasicCard(Creature creature) {

        CardContentDataSet data = new CardContentDataSet(creature.getObjectPathPicture(), creature.getName());
        var map = new ArrayList<ArrayList<String>>();
        map.add(new ArrayList<>(List.of(statsPath)));
        if (creature instanceof Character) {
            for (var path : Arrays.asList(horsePath, armorPath, weaponPath, trolleyPath)) {
                map.add(new ArrayList<>(List.of(path)));
            }
        }
        data.content = map;
        data.setFullStringDataContent();
        return data;
    }

    private CardContentDataSet itemToDataSet(List<? extends Item> items, String title, String path) {
        CardContentDataSet data = new CardContentDataSet(path, title);
        var map = new ArrayList<ArrayList<String>>();
        for (var item : items) {
            String armorName = item.getName();
            map.add(new ArrayList<>(Arrays.asList(item.getItemPathPicture(), armorName, detailsText)));
        }
        data.content = map;
        data.setFullStringDataContent();

        return data;
    }


    public CardContentDataSet convertArmorsToDataSet(Character character) {
        return itemToDataSet(character.getInventory().getArmors(), armorText, armorPath);
    }

    public CardContentDataSet convertItemsToDataSet(Character character) {
        return itemToDataSet(character.getInventory().getDisposableItems(), itemsText, trolleyPath);
    }

    public CardContentDataSet convertWeaponsToDataSet(Character character) {
        return itemToDataSet(character.getInventory().getWeapons(), weaponsText, weaponPath);
    }

    public CardContentDataSet convertMountsToDataSet(Character character) {
        return itemToDataSet(character.getInventory().getMounts(), mountsText, horsePath);
    }

    public CardContentDataSet convertStatsToDataSet(Creature creature) {
        CardContentDataSet data = new CardContentDataSet(statsPath, attrText);
        var map = new ArrayList<ArrayList<String>>();
        for (var attribute : AttributeEnum.values()) {
            String attibuteName = attribute.name().replace("_", " ");
            var value = creature.getStatistics().getAttribute(attribute).getValue();
            String attributeValue = Integer.toString(value);
            map.add(new ArrayList<>(Arrays.asList(attibuteName, attributeValue)));
        }
        data.content = map;
        data.setFullStringDataContent();

        return data;
    }

    private ArrayList<CardContentDataSet> generateItemArray(List<? extends Item> arrayList) {
        var list = new ArrayList<CardContentDataSet>();
        for (var item : arrayList) {
            list.add(detailsView(item));
        }
        return list;
    }

    public HashMap<Card.CardTypes, ArrayList<CardContentDataSet>> createFullDetailDataCreature(Creature basecreature) {
        var map = new LinkedHashMap<Card.CardTypes, ArrayList<CardContentDataSet>>();
        if (basecreature instanceof Character creature) {
            map.put(Card.CardTypes.ARMOR, generateItemArray(creature.getInventory().getArmors()));
            map.put(Card.CardTypes.ITEMS, generateItemArray(creature.getInventory().getDisposableItems()));
            map.put(Card.CardTypes.WEAPONS, generateItemArray(creature.getInventory().getWeapons()));
            map.put(Card.CardTypes.MOUNT, generateItemArray(creature.getInventory().getMounts()));
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
        return map;
    }


    private CardContentDataSet createItemInEntriesCard(String name, String path, List<Pair> attrsNames) {
        CardContentDataSet data = new CardContentDataSet(path, name);
        var map = new ArrayList<ArrayList<String>>();
        for (var attrname : attrsNames) {
            map.add(new ArrayList<>(Arrays.asList(attrname.name, attrname.value)));
        }
        data.content = map;
        data.setFullStringDataContent();
        return data;
    }

    private CardContentDataSet createItemInEntriesCard(String name, String path, Pair... attrsNames) {
       return createItemInEntriesCard(name, path, Arrays.asList(attrsNames));
    }


    private class Pair{
        String value;
        String name;

        public Pair(String value, String name) {
            this.value = value;
            this.name = name;
        }
    }

    public CardContentDataSet editWeaponInEntriesCard(Weapon weapon) {
        var firstPair = new Pair(Integer.toString(weapon.getDamage()), damageText);
        var secondPair = new Pair(Integer.toString(weapon.getRange()), rangeText);
        return createItemInEntriesCard(weapon.getName(), weapon.getItemPathPicture(), firstPair, secondPair);
    }

    public CardContentDataSet editArmorInEntriesCard(Armor armor) {
        var firstPair = new Pair(Integer.toString(armor.getDefence()), defenceText);
        return createItemInEntriesCard(armor.getName(), armor.getItemPathPicture(), firstPair);
    }

    public CardContentDataSet editMountInEntriesCard(Mount mount) {
        var firstPair = new Pair(Integer.toString(mount.getSpeed()), speedText);
        return createItemInEntriesCard(mount.getName(), mount.getItemPathPicture(), firstPair);
    }

    public CardContentDataSet editItemInEntriesCard(DisposableItem item){
        return createItemInEntriesCard(item.getName(), item.getItemPathPicture(), new Pair(item.getDescription(), item.getDescription()));
    }

    public CardContentDataSet detailsView(Item item) {
        CardContentDataSet data = new CardContentDataSet(item.getItemPathPicture(), item.getName());

        if (item instanceof Armor) {
            data = editArmorInEntriesCard((Armor) item);
        } else if (item instanceof Weapon) {
            data = editWeaponInEntriesCard((Weapon) item);
        } else if (item instanceof Mount) {
            data = editMountInEntriesCard((Mount) item);
        } else if (item instanceof DisposableItem) {
            data = editItemInEntriesCard((DisposableItem) item);
        }

        return data;
    }

    public Weapon createWeaponFromCard(CardContentDataSet data) {
        String name = data.titleContent;
        setValidationOfNameAndPath(name, data.titlePath);
        int damage = 0;
        int range = 0;
        for (var parameter : data.content) {
            if (parameter.get(0).equals(damageText)) {
                damage = getCheckedParameter(data, parameter);
            }
            if (parameter.get(0).equals(rangeText)) {
                range = getCheckedParameter(data, parameter);
            }
        }
        Weapon weapon = new Weapon(name, damage, range);
        weapon.setItemPathPicture(data.titlePath);
        return weapon;
    }

    private int getCheckedParameter(CardContentDataSet data,ArrayList<String> parameter){
        var val = 0;
        if (MathHelper.isNumeric(parameter.get(1))) {
            val = Integer.parseInt(parameter.get(1));
        } else {
            errorValidationChecker.addIntexToErrorList(data.content.indexOf(parameter));
        }
        return val;
    }

    public Armor createArmorFromCard(CardContentDataSet data) {
        String name = data.titleContent;
        setValidationOfNameAndPath(name, data.titlePath);
        int defence = 0;
        for (var parameter : data.content) {
            if (parameter.get(0).equals(defenceText)) {
                defence = getCheckedParameter(data, parameter);
            }
        }
        Armor armor = new Armor(name, defence);
        armor.setItemPathPicture(data.titlePath);
        return armor;
    }

    public void setValidationOfNameAndPath(String name, String path) {
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
            if (parameter.get(0).equals(speedText)) {
                speed = getCheckedParameter(data, parameter);
            }
        }

        Mount mount = new Mount(name, speed);
        mount.setItemPathPicture(data.titlePath);
        return mount;
    }

    public PlayerCharacter createPlayerCharacterFromCard(CardContentDataSet data) {
        var array = generateStats(data);
        return new PCFactory().creat(array);
    }

    public NPC createNPCFromCard(CardContentDataSet data) {
        var array = generateStats(data);
        return new NPCFactory().creat(array);
    }

    public Monster createMonsterFromCard(CardContentDataSet data) {
        var array = generateStats(data);
        return new MonsterFactoryWarhammer().creat(array);
    }

    private ArrayList<String> generateStats(CardContentDataSet data){
        ArrayList<String> stats = new ArrayList<>();
        stats.add(data.titleContent);
        for (var attributeList : data.content) {
            stats.add(attributeList.get(1));
        }

        stats.add(data.titlePath);
        return stats;
    }
}
