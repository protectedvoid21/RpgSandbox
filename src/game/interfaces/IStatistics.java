package game.interfaces;

import game.generals.AttributeValue;
import game.generals.Effect;

/**Interface for every RPG stats*/
public interface IStatistics {
    AttributeValue getAttribute(String attributeEnumName);
    
    Effect getEffect(String effectEnumName);
    
    int getDependantAttrValue(String dependantAttributeEnumName);
}
