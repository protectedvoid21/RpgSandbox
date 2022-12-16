package game.creature;

import game.generals.AttributeValue;
import game.generals.LimitedAttribute;
import game.generals.UnlimitedAttribute;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaces.Statistics;

import java.util.ArrayList;

abstract public class Creature implements Statistics {


    // Pokazanie propozycji. Trzeba uporządkować jeśli przejdzie
    protected Statistics statistics;
    ArrayList<AttributeValue> attributes =  new ArrayList<AttributeValue>();;
    @Override
    public ArrayList<AttributeValue> createStatistics() {
        statistics = new StatisticsWarhammer();
        return statistics.createStatistics();

    }





    // statysyki podstawowe są z przedziału 0-100
    private AttributeValue weaponSkill;
    private AttributeValue ballisticSkill;
    private AttributeValue strength;
    private AttributeValue toughness;
    private AttributeValue agility;
    private AttributeValue intelligence;
    private AttributeValue willPower;
    private AttributeValue fellowship;

    // statystyki drugorzędne
    private AttributeValue attacks; // ilość ataków możliwych do wykonania
    private AttributeValue healthPoints;
    private AttributeValue movement; // ile Pól może przejść w jednej akcji
    private AttributeValue magic; // ilość kości przy teście rzutu zaklęcia; ---trzeba dopisac inicjalizacje, nie do konca rozumiem koncept tego atrybutu

    //Stany

    private boolean isBleeding;
    private boolean isShocked;
    private boolean isPoisoned;
    private boolean isInFire;

    public Creature() {
        weaponSkill = new LimitedAttribute(30);
        ballisticSkill = new LimitedAttribute(30);
        strength = new LimitedAttribute(30);
        toughness = new LimitedAttribute(30);
        agility = new LimitedAttribute(30);
        intelligence = new LimitedAttribute(30);
        willPower = new LimitedAttribute(30);
        fellowship = new LimitedAttribute(30);

        attacks = new UnlimitedAttribute(1);
        healthPoints = new LimitedAttribute(12);
        movement = new UnlimitedAttribute(4);
        //        magic = 0; todo

        attributes = createStatistics();
    }


    public AttributeValue getWeaponSkill() {
        return weaponSkill;
    }

    public AttributeValue getBallisticSkill() {
        return ballisticSkill;
    }

    public AttributeValue getStrength() {
        return strength;
    }

    public AttributeValue getTougness() {
        return toughness;
    }

    public AttributeValue getAgility() {
        return agility;
    }

    public AttributeValue getIntelligence() {
        return intelligence;
    }

    public AttributeValue getWillPower() {
        return willPower;
    }

    public AttributeValue getFellowship() {
        return fellowship;
    }

    public AttributeValue getAttacks() {
        return attacks;
    }

    public AttributeValue getHealthPoints() {
        return healthPoints;
    }

    public int getStreangthBonus() {
        return strength.getValue() % 10;
    }

    public int getToughnessBonus() {
        return toughness.getValue() % 10;
    }

    public AttributeValue getMovement() {
        return movement;
    }

    public AttributeValue getMagic() {
        return magic;
    }

    public boolean isBleeding() {
        return isBleeding;
    }

    public void setBleeding(boolean bleeding) {
        isBleeding = bleeding;
    }

    public boolean isShocked() {
        return isShocked;
    }

    public void setShocked(boolean shocked) {
        isShocked = shocked;
    }

    public boolean isPoisoned() {
        return isPoisoned;
    }

    public void setPoisoned(boolean poisoned) {
        isPoisoned = poisoned;
    }

    public boolean isInFire() {
        return isInFire;
    }

    public void setInFire(boolean inFire) {
        isInFire = inFire;
    }
}
