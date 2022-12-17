package game.interfaces;

import game.generals.AttributeValue;
import game.generals.EffectAttribute;

import java.util.function.Function;

import java.util.HashMap;
import java.util.Map;

public abstract class Statistics implements IStatistics {

    protected Map<String, AttributeValue> attributes = new HashMap<>();
    protected Map<String, EffectAttribute> effects = new HashMap<>();
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
    public EffectAttribute getEffect(String effectEnumName) {
        return effects.get(effectEnumName);
    }

    public int getDependantAttrValue(String dependantAttributeEnumName){
        return dependantAttributes.get(dependantAttributeEnumName).apply(this);
    }


}
