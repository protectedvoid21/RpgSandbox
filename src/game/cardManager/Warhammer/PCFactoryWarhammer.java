package game.cardManager.Warhammer;

import game.cardManager.DecodeArrayStatistics;
import game.creature.Creature;
import game.creature.Experience;
import game.creature.NPC;
import game.creature.PlayerCharacter;
import game.equipment.Inventory;
import game.generals.AttributeValue;
import game.generals.LimitedAttribute;
import game.generals.UnlimitedAttribute;
import game.interfaceWarhammer.AttributeEnum;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaces.IAttributeEnum;
import game.interfaces.IFactory;
import game.interfaces.Statistics;
import game.interfaces.StruggleStatistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PCFactoryWarhammer implements IFactory {
    @Override
    public PlayerCharacter creat(ArrayList<String> stats) {
        String name = stats.get(0);
        int exp = 0;

        Statistics statistics = DecodeArrayStatistics.decodeStats(stats);
        StruggleStatistics struggleStatistics = new StruggleStatistics();
        Experience experience = new Experience(exp);

        PlayerCharacter playerCharacter = new PlayerCharacter(statistics,new Inventory(),experience,struggleStatistics);
        playerCharacter.setName(name);
        return playerCharacter;
    }
}
