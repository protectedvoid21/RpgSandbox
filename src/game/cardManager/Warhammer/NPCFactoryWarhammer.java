package game.cardManager.Warhammer;

import game.creature.Creature;
import game.creature.Experience;
import game.creature.Monster;
import game.creature.NPC;
import game.equipment.Inventory;
import game.generals.AttributeValue;
import game.generals.LimitedAttribute;
import game.generals.UnlimitedAttribute;
import game.interfaceWarhammer.AttributeEnum;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaces.IAttributeEnum;
import game.interfaces.IFactory;
import game.interfaces.StruggleStatistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NPCFactoryWarhammer implements IFactory {

    @Override
    public NPC creat(ArrayList<String> stats) {
        String name = stats.get(0);
        int exp = 0;

        Map<IAttributeEnum, AttributeValue> attributes = new HashMap<>();
        for (int i = 1; i < 10; i ++){
            attributes.put(AttributeEnum.values()[i-1], new LimitedAttribute(0,100,Integer.parseInt(stats.get(i))));
        }

        attributes.put(AttributeEnum.ATTACKS, new UnlimitedAttribute(Integer.parseInt(stats.get(10))));
        attributes.put(AttributeEnum.HEALTH_POINTS_MAX, new UnlimitedAttribute(Integer.parseInt(stats.get(11))));
        attributes.put(AttributeEnum.HEALTH_POINTS_NOW, new UnlimitedAttribute(Integer.parseInt(stats.get(12))));
        attributes.put(AttributeEnum.MOVEMENT, new UnlimitedAttribute(Integer.parseInt(stats.get(13))));

        StatisticsWarhammer statistics = new StatisticsWarhammer(attributes);
        StruggleStatistics struggleStatistics = new StruggleStatistics();
        Experience experience = new Experience(exp);

        NPC npc = new NPC(statistics,new Inventory(),experience,struggleStatistics);
        npc.setName(name);
        return npc;
    }
}
