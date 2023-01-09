package game.interfaceWarhammer;

import game.generals.AttributeValue;
import game.generals.LimitedAttribute;
import game.generals.UnlimitedAttribute;
import game.generals.effects.BleedingEffect;
import game.generals.effects.FreezingEffect;
import game.interfaces.IAttributeEnum;
import game.interfaces.Statistics;

import java.util.EnumSet;
import java.util.Map;

public class StatisticsWarhammer extends Statistics {
    public StatisticsWarhammer() { //todo as statistics are gonna be implemented by json import this need to change
        super();
    }

    public StatisticsWarhammer(Map<IAttributeEnum, AttributeValue> attributes) {
        super(attributes);
    }

    @Override
    public void initializeAttributes() {
        EnumSet.range(AttributeEnum.POWER, AttributeEnum.FELLOWSHIP).forEach(attr -> attributes.put(attr, new LimitedAttribute(30)));
        attributes.put(AttributeEnum.ATTACKS, new UnlimitedAttribute(1));
        attributes.put(AttributeEnum.HEALTH_POINTS_MAX, new UnlimitedAttribute(15));
        attributes.put(AttributeEnum.HEALTH_POINTS_NOW, new UnlimitedAttribute(15));
        attributes.put(AttributeEnum.MOVEMENT, new UnlimitedAttribute(5));
        attributes.put(AttributeEnum.MAGIC, new UnlimitedAttribute(1));
    }

    @Override
    public void initializeEffects() {
        effects.put(EffectEnum.BLEEDING, new BleedingEffect(this, 3));
        effects.put(EffectEnum.FREEZING, new FreezingEffect(this, 3));
    }

    @Override
    protected void initializeDependantAttributes() {
        dependantAttributes.put(DependantEnum.STRENGTH_BONUS, (var stats) -> stats.getAttribute(AttributeEnum.STRENGTH).getValue() % 10);
        dependantAttributes.put(DependantEnum.TOUGHNESS_BONUS, (var stats) -> stats.getAttribute(AttributeEnum.TOUGHNESS).getValue() % 10);
    }

    @Override
    public void applyNewRound() {
        for (var effect : effects.values()) {
            effect.decreaseLength();
        }
    }

    @Override
    public boolean isAlive() {
        return attributes.get(AttributeEnum.HEALTH_POINTS_NOW).getValue() > 0;
    }

    @Override
    public boolean isAbleToPlay() { //todo implement crowd control mechanics and more enchanced return
        return isAlive();
    }
}
