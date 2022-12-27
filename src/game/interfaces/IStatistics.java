package game.interfaces;

import game.generals.AttributeValue;
import game.generals.Effect;
import java.lang.Enum;

/**Interface for every RPG stats*/
public interface IStatistics {
    AttributeValue getAttribute( IAttributeEnum attributeEnum);
    
    Effect getEffect(IEffectEnum effectEnum);
    
    int getDependantAttrValue(IDependantEnum dependantAttributeEnum);
}
