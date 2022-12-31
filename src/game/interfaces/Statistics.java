package game.interfaces;

import com.owlike.genson.annotation.JsonIgnore;
import com.owlike.genson.annotation.JsonProperty;
import game.generals.AttributeValue;
import game.generals.Effect;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class Statistics implements IStatistics {
    protected Map<IAttributeEnum, AttributeValue> attributes = new HashMap<>();
    @JsonIgnore
    protected Map<IEffectEnum, Effect> effects = new HashMap<>();
    @JsonIgnore
    protected Map<IDependantEnum, Function<Statistics, Integer>> dependantAttributes = new HashMap<>();
    
    public Statistics() {
        initializeAttributes();
        initializeEffects();
        initializeDependantAttributes();
    }
    
    public Statistics(Map<IAttributeEnum, AttributeValue> attributes) {
        this.attributes = attributes;
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

    public int getDependantAttrValue(IDependantEnum dependantAttributeEnum) {
        return dependantAttributes.get(dependantAttributeEnum).apply(this);
    }
}
