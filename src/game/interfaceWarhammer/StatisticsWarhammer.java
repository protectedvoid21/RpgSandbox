package game.interfaceWarhammer;

import game.generals.AttributeValue;
import game.generals.Effect;
import game.generals.LimitedAttribute;
import game.generals.UnlimitedAttribute;
import game.generals.effects.BleedingEffect;
import game.generals.effects.FreezingEffect;
import game.interfaces.Statistics;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**Specific Warhammer RPG stats class whose task is to initialize attributes, effects and create lambda functions for dependant attributes */
public class StatisticsWarhammer extends Statistics {
    @Override
    public Map<String, AttributeValue> initializeAttributes() {
        var attributes = new HashMap<String, AttributeValue>();
        
        EnumSet.range(AttributeEnum.POWER, AttributeEnum.FELLOWSHIP).forEach(attr -> attributes.put(attr.name(), new LimitedAttribute(30)));
        attributes.put(AttributeEnum.ATTACKS.name(), new UnlimitedAttribute(1));
        attributes.put(AttributeEnum.HEALTH_POINTS.name(), new UnlimitedAttribute(100));
        attributes.put(AttributeEnum.MOVEMENT.name(), new UnlimitedAttribute(5));
        attributes.put(AttributeEnum.MAGIC.name(), new UnlimitedAttribute(1));
        
        return attributes;
    }

    @Override
    public Map<String, Effect> initializeEffects() {
        var effects = new HashMap<String, Effect>();
        
        effects.put(EffectEnum.BLEEDING.name(), new BleedingEffect(this, 3));
        effects.put(EffectEnum.FREEZING.name(), new FreezingEffect(this, 3));
        
        return effects;
    }

    @Override
    protected Map<String, Function<Statistics, Integer>> initializeDependantAttributes() {
        var dependantAttributes = new HashMap<String, Function<Statistics, Integer>>();
        
        dependantAttributes.put(DependantEnum.STRENGTH_BONUS.name(), (var stats) -> stats.getAttribute(AttributeEnum.STRENGTH.name()).getValue() % 10);
        dependantAttributes.put(DependantEnum.TOUGHNESS_BONUS.name(), (var stats) -> stats.getAttribute(AttributeEnum.TOUGHNESS.name()).getValue() % 10);
    
        return dependantAttributes;
    }
}
