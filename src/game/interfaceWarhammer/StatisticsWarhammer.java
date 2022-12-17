package game.interfaceWarhammer;

import game.generals.EffectAttribute;
import game.generals.LimitedAttribute;
import game.generals.UnlimitedAttribute;
import game.interfaces.Statistics;

import java.util.EnumSet;

public class StatisticsWarhammer extends Statistics {
    @Override
    public void initializeAttributes() {
        EnumSet.range(AttributeEnum.POWER, AttributeEnum.FELLOWSHIP).forEach(attr -> attributes.put(attr.name(), new LimitedAttribute(30)));
        attributes.put(AttributeEnum.ATTACKS.name(), new UnlimitedAttribute(1));
        attributes.put(AttributeEnum.HEALTH_POINTS.name(), new UnlimitedAttribute(13));
        attributes.put(AttributeEnum.MOVEMENT.name(), new UnlimitedAttribute(5));
        attributes.put(AttributeEnum.MAGIC.name(), new UnlimitedAttribute(1));
    }

    @Override
    public void initializeEffects() {
        for (var effect : EffectEnum.values()) {
            effects.put(effect.name(), new EffectAttribute());
        }
    }

    @Override
    protected void initializeDependantAttributes() {
        dependantAttributes.put(DependantEnum.STRENGTH_BONUS.name(), (var stats) -> stats.getAttribute(AttributeEnum.STRENGTH.name()).getValue() % 10);
        dependantAttributes.put(DependantEnum.TOUGHNESS_BONUS.name(), (var stats) -> stats.getAttribute(AttributeEnum.TOUGHNESS.name()).getValue() % 10);
    }
}
