package game.interfaceWarhammer;

import game.generals.AttributeValue;
import game.generals.LimitedAttribute;
import game.interfaces.Statistics;

import java.util.ArrayList;

public class StatisticsWarhammer implements Statistics {
    @Override
    public ArrayList<AttributeValue> createStatistics() {
        ArrayList<AttributeValue>  result = new ArrayList<AttributeValue>();
        ArrayList<String> statistics = new ArrayList<String>();;
        statistics.add("weaponSkill");
        statistics.add("ballisticSkill");
        statistics.add("strength");
        statistics.add("toughness");
        statistics.add("agility");
        statistics.add("intelligence");
        statistics.add("willPower");
        statistics.add("fellowship");

        for(int i = 0; i < statistics.size(); i++){
            result.add(new LimitedAttribute(30,statistics.get(i)));
        }
        result.add(new LimitedAttribute(1, "attacks"));
        result.add(new LimitedAttribute(13, "healthPoints"));
        result.add(new LimitedAttribute(5, "movement"));
        result.add(new LimitedAttribute(1, "magic"));

        return  result;

    }
}
