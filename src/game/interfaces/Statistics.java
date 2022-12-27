package game.interfaces;

import game.generals.AttributeValue;
import game.generals.Effect;

import java.util.function.Function;

import java.util.HashMap;
import java.util.Map;

public abstract class Statistics implements IStatistics {
    protected Map<IAttributeEnum, AttributeValue> attributes = new HashMap<>();
    protected Map<Enum, Effect> effects = new HashMap<>();
    protected Map<Enum, Function<Statistics, Integer>> dependantAttributes = new HashMap<>();

    public Statistics() {
        initializeAttributes();
        initializeEffects();
        initializeDependantAttributes();
    }

    protected abstract void initializeAttributes();

    protected abstract void initializeEffects();

    protected abstract void initializeDependantAttributes();
    
    @Override
    public AttributeValue getAttribute(IAttributeEnum attributeEnum) {
        return attributes.get(attributeEnum);
    }

    @Override
    public Effect getEffect(IEffectEnum effectEnum) {
        return effects.get(effectEnum);
    }

    public int getDependantAttrValue(IDependantEnum dependantAttributeEnum){
        return dependantAttributes.get(dependantAttributeEnum).apply(this);
    }
}
