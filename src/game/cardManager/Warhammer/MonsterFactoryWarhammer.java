package game.cardManager.Warhammer;

import game.cardManager.DecodeArrayStatistics;
import game.creature.Creature;
import game.creature.Experience;
import game.creature.Monster;
import game.equipment.Weapon;
import game.generals.AttributeValue;
import game.generals.LimitedAttribute;
import game.generals.UnlimitedAttribute;
import game.interfaceWarhammer.AttributeEnum;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaceWarhammer.StruggleStatisticsWarhammer;
import game.interfaces.IAttributeEnum;
import game.interfaces.IFactory;
import game.interfaces.Statistics;
import game.interfaces.StruggleStatistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MonsterFactoryWarhammer implements IFactory {


    public MonsterFactoryWarhammer(){};

    @Override
    public Monster creat(ArrayList<String> stats) {
        String name = stats.get(0);
        int exp = 0;

        Statistics statistics = DecodeArrayStatistics.decodeStats(stats);
        StruggleStatistics struggleStatistics = new StruggleStatisticsWarhammer();
        Experience experience = new Experience(exp);

        Monster monster = new Monster(statistics,experience,struggleStatistics);
        monster.setName(name);
        monster.setObjectPathPicture(stats.get(13));
        return monster;
    }
}
