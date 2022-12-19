package game.interfaces;

import game.generals.AttributeValue;
import game.generals.Effect;

import java.util.function.Function;

import java.util.HashMap;
import java.util.Map;

public abstract class Statistics implements IStatistics {
    protected Map<String, AttributeValue> attributes;
    protected Map<String, Effect> effects;
    protected Map<String, Function<Statistics, Integer>> dependantAttributes;

    public Statistics() {
        attributes = initializeAttributes();
        effects = initializeEffects();
        dependantAttributes = initializeDependantAttributes();
    }

    protected abstract Map<String, AttributeValue> initializeAttributes();

    protected abstract Map<String, Effect> initializeEffects();

    protected abstract Map<String, Function<Statistics, Integer>> initializeDependantAttributes();
    
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
