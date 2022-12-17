package game.creature;

import game.generals.AttributeValue;
import game.generals.Effect;
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

    ArrayList<Effect> effects = new ArrayList<Effect>();

    public ArrayList<Effect> createEffects(){
        statistics = new StatisticsWarhammer();
        return statistics.createEffects();

    };

    public Creature() {
        attributes = createStatistics();
        effects = createEffects();
    }


    //Bonus z siły i odporności do ogarnięcia


}
