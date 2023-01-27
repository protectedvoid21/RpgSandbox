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
    ErrorValidationChecker getErrorValidationChecker();

     CardContentDataSet convertCreatureToDataSetInBasicCard(Creature creature);

     CardContentDataSet convertArmorsToDataSet(Character character);

     CardContentDataSet convertWeaponsToDataSet(Character character);

     CardContentDataSet convertMountsToDataSet(Character character);

     CardContentDataSet convertStatsToDataSet(Creature creature);

     HashMap<Card.CardTypes, ArrayList<CardContentDataSet>> createFullDetailDataCreature(Creature basecreature);

     LinkedHashMap<Card.CardTypes, CardContentDataSet> createFullDataCreature(Creature creature);

     CardContentDataSet createWeaponInEntriesCard();
     CardContentDataSet createArmorInEntriesCard();

     CardContentDataSet createMountInEntriesCard();

     CardContentDataSet addNewItemInEntriesCard(Character character);

     CardContentDataSet editWeaponInEntriesCard(Weapon weapon);

     CardContentDataSet editArmorInEntriesCard(Armor armor);

     CardContentDataSet editMountInEntriesCard(Mount mount);

     CardContentDataSet createMonsterInEntriesCard();

     CardContentDataSet createPlayerCharacterInEntriesCard();

     CardContentDataSet createNPCInEntriesCard();

     CardContentDataSet detailsView(ManyUsageItem item);

     CardContentDataSet smallCharacterCards(Character character);

     Weapon createWeaponFromCard(CardContentDataSet data);

     Armor createArmorFromCard(CardContentDataSet data);

     void setValidationOfNameAndPath(String name, String path);

     Mount createMountFromCard(CardContentDataSet data);

     PlayerCharacter createPlayerCharacterFromCard(CardContentDataSet data);

     NPC createNPCFromCard(CardContentDataSet data);

     Monster createMonsterFromCard(CardContentDataSet data);

     void main(String[] args);
}
