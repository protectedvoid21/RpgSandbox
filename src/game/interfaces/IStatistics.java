package game.interfaces;

import game.generals.AttributeValue;
import game.generals.Effect;

/**Interface for every RPG stats*/
public interface IStatistics extends RoundListener {
    AttributeValue getAttribute(IAttributeEnum attributeEnum);
    
    Effect getEffect(IEffectEnum effectEnum);
    
    int getDependantAttrValue(IDependantEnum dependantAttributeEnum);
    
    boolean isAlive();
    
    boolean isAbleToPlay();
    
    int getMovePriority();
}
