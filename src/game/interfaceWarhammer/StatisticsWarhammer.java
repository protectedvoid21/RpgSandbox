package game.interfaceWarhammer;

import game.generals.AttributeValue;
import game.generals.Effect;
import game.generals.LimitedAttribute;
import game.interfaces.Statistics;

import java.util.ArrayList;

public class StatisticsWarhammer implements Statistics {
    @Override
    public ArrayList<AttributeValue> createStatistics() {
        ArrayList<AttributeValue>  result = new ArrayList<AttributeValue>();
        ArrayList<String> statistics = new ArrayList<String>();;
        // statysyki podstawowe są z przedziału 0-100
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

        // statystyki drugorzędne
        result.add(new LimitedAttribute(1, "attacks"));  // ilość ataków możliwych do wykonania
        result.add(new LimitedAttribute(13, "healthPoints"));
        result.add(new LimitedAttribute(5, "movement")); // ile Pól może przejść w jednej akcji
        result.add(new LimitedAttribute(1, "magic")); // ilość kości przy teście rzutu zaklęcia; ---trzeba dopisac inicjalizacje, nie do konca rozumiem koncept tego atrybutu

        return  result;

    }

    public ArrayList<Effect> createEffects(){
        ArrayList<Effect> result = new ArrayList<Effect>();
        ArrayList<String> effects = new ArrayList<String>();

        effects.add("bleding");
        effects.add("schock");
        effects.add("poison");
        effects.add("inFire");


        for (int i = 0; i < effects.size(); i++){
            result.add(new Effect(effects.get(i),false,0));
        }

        return result;

    }

}
