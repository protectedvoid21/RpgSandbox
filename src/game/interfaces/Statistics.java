package game.interfaces;

import game.generals.AttributeValue;
import game.generals.Effect;
import game.generals.LimitedAttribute;

import java.util.function.Function;

import java.util.HashMap;
import java.util.Map;

/**General statistics class which controlling attributes, effects and dependant attributes(attrs which are dependent on other attributes, their influence is based on other values)
 *Contain 3 abstract methods which has to be overridden in its child class(specific for given RPG game)
 *String used as argument in many methods is enum name value which are specific for given RPG game.*/
public abstract class Statistics implements IStatistics {
    protected Map<String, AttributeValue> attributes = new HashMap<>();
    protected Map<String, Effect> effects = new HashMap<>();
    protected Map<String, Function<Statistics, Integer>> dependantAttributes = new HashMap<>();

    public Statistics() {
        initializeAttributes();
        initializeEffects();
        initializeDependantAttributes();
    }

    protected abstract void initializeAttributes();

    protected abstract void initializeEffects();

    protected abstract void initializeDependantAttributes();
    
    @Override
    public AttributeValue getAttribute(String attributeEnumName) {
        return attributes.get(attributeEnumName);
    }

    @Override
    public Effect getEffect(String effectEnumName) {
        return effects.get(effectEnumName);
    }

    public int getDependantAttrValue(String dependantAttributeEnumName){
        return dependantAttributes.get(dependantAttributeEnumName).apply(this);
    }
}
