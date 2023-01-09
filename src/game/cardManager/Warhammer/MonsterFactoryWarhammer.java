package game.cardManager.Warhammer;

import game.creature.Creature;
import game.creature.Experience;
import game.creature.Monster;
import game.generals.AttributeValue;
import game.generals.LimitedAttribute;
import game.generals.UnlimitedAttribute;
import game.interfaceWarhammer.AttributeEnum;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaces.IAttributeEnum;
import game.interfaces.IFactory;
import game.interfaces.StruggleStatistics;

import java.util.HashMap;
import java.util.Map;

public class MonsterFactoryWarhammer implements IFactory {


    public MonsterFactoryWarhammer(){};

    @Override

    public Monster creat(String[] stats) {
        String name = stats[0];
        int exp = Integer.parseInt(stats[1]);

        Map<IAttributeEnum, AttributeValue> attributes = new HashMap<>();
        for (int i = 2; i < 11; i ++){
            attributes.put(AttributeEnum.values()[i-2], new LimitedAttribute(0,100,Integer.parseInt(stats[i])));
        }

        attributes.put(AttributeEnum.ATTACKS, new UnlimitedAttribute(Integer.parseInt(stats[11])));
        attributes.put(AttributeEnum.HEALTH_POINTS_MAX, new UnlimitedAttribute(Integer.parseInt(stats[12])));
        attributes.put(AttributeEnum.HEALTH_POINTS_NOW, new UnlimitedAttribute(Integer.parseInt(stats[13])));
        attributes.put(AttributeEnum.MOVEMENT, new UnlimitedAttribute(Integer.parseInt(stats[14])));

        StatisticsWarhammer statistics = new StatisticsWarhammer(attributes);
        StruggleStatistics struggleStatistics = new StruggleStatistics();
        Experience experience = new Experience(exp);

        Monster monster = new Monster(statistics,experience,struggleStatistics);
        monster.setName(name);
        return monster;
    }
}
