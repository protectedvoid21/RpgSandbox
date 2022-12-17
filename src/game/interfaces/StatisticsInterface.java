package game.interfaces;

import game.generals.AttributeValue;
import game.generals.EffectAttribute;

public interface StatisticsInterface{

    AttributeValue getAttribute(String attributeEnumName);
    EffectAttribute getEffect(String effectEnumName);
    int getDependantAttrValue(String dependantAttributeEnumName);
}
