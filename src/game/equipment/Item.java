package game.equipment;

import game.generals.AttributeValue;
import game.interfaceWarhammer.StatisticsWarhammer;

import java.util.Map;

public abstract class Item {
    protected Map<String, AttributeValue> attributes;
    
    public Item() {
        attributes = new StatisticsWarhammer().initializeAttributes(); //these needs to be zeroed
    }
    
    public abstract void use();
}
