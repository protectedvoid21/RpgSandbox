package gui.utils;

import game.creature.*;
import game.creature.Character;
import game.equipment.Armor;
import game.equipment.ManyUsageItem;
import game.equipment.Mount;
import game.equipment.Weapon;
import game.utils.ErrorValidationChecker;
import gui.card.CardContentDataSet;
import gui.card.fullCards.abstractCards.Card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public interface AbstractConverter {
    public ErrorValidationChecker getErrorValidationChecker();

    public CardContentDataSet convertCreatureToDataSetInBasicCard(Creature creature);

    public CardContentDataSet convertArmorsToDataSet(Character character);

    public CardContentDataSet convertWeaponsToDataSet(Character character);

    public CardContentDataSet convertMountsToDataSet(Character character);

    public CardContentDataSet convertStatsToDataSet(Creature creature);

    public HashMap<Card.CardTypes, ArrayList<CardContentDataSet>> createFullDetailDataCreature(Creature basecreature);

    public LinkedHashMap<Card.CardTypes, CardContentDataSet> createFullDataCreature(Creature creature);

    public CardContentDataSet createWeaponInEntriesCard();

    public CardContentDataSet createArmorInEntriesCard();

    public CardContentDataSet createMountInEntriesCard();

    public CardContentDataSet addNewItemInEntriesCard(Character character);

    public CardContentDataSet editWeaponInEntriesCard(Weapon weapon);

    public CardContentDataSet editArmorInEntriesCard(Armor armor);

    public CardContentDataSet editMountInEntriesCard(Mount mount);

    public CardContentDataSet createMonsterInEntriesCard();

    public CardContentDataSet createPlayerCharacterInEntriesCard();

    public CardContentDataSet createNPCInEntriesCard();

    public CardContentDataSet detailsView(ManyUsageItem item);

    public CardContentDataSet smallCharacterCards(Character character);

    public Weapon createWeaponFromCard(CardContentDataSet data);

    public Armor createArmorFromCard(CardContentDataSet data);

    public void setValidationOfNameAndPath(String name, String path);

    public Mount createMountFromCard(CardContentDataSet data);

    public PlayerCharacter createPlayerCharacterFromCard(CardContentDataSet data);

    public NPC createNPCFromCard(CardContentDataSet data);

    public Monster createMonsterFromCard(CardContentDataSet data);

    public void main(String[] args);
}
