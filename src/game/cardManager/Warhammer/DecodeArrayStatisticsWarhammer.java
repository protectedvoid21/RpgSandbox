package game.cardManager.Warhammer;

import game.generals.AttributeValue;
import game.generals.LimitedAttribute;
import game.generals.UnlimitedAttribute;
import game.interfaceWarhammer.AttributeEnum;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaces.IAttributeEnum;
import game.interfaces.IDecodeArrayStatistics;
import game.interfaces.Statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DecodeArrayStatisticsWarhammer implements IDecodeArrayStatistics {
    public static ArrayList<Integer> errorIndexes = new ArrayList<>();
    public static boolean errorFlag = false;

    @Override
    public Statistics decode(ArrayList<String> stats) {
        errorFlag = false;
        errorIndexes.clear();
        Map<IAttributeEnum, AttributeValue> attributes = new HashMap<>();
        for (int i = 1; i < 9; i++) {
            try {
                attributes.put(AttributeEnum.values()[i - 1], new LimitedAttribute(0, 100,
                        Integer.parseInt(stats.get(i))));
            } catch (NumberFormatException ex) {
                errorIndexes.add(i-1);
                System.out.println(errorFlag+"tututu");
                errorFlag = true;
            }
        }

//        attributes.put(AttributeEnum.ATTACKS, new UnlimitedAttribute(Integer.parseInt(stats.get(9))));
//        attributes.put(AttributeEnum.HEALTH_POINTS_NOW, new UnlimitedAttribute(Integer.parseInt(stats.get(10))));
//        attributes.put(AttributeEnum.HEALTH_POINTS_MAX, new UnlimitedAttribute(Integer.parseInt(stats.get(11))));
//        attributes.put(AttributeEnum.MOVEMENT, new UnlimitedAttribute(Integer.parseInt(stats.get(12))));
        setAttr(stats, attributes, AttributeEnum.ATTACKS, 9);
        setAttr(stats, attributes, AttributeEnum.ATTACKS, 10);
        setAttr(stats, attributes, AttributeEnum.ATTACKS, 11);
        setAttr(stats, attributes, AttributeEnum.ATTACKS, 12);

        StatisticsWarhammer statistics = new StatisticsWarhammer(attributes);

        return statistics;
    }

    private void setAttr(ArrayList<String> stats, Map<IAttributeEnum, AttributeValue> map, AttributeEnum enumValue,
                         int value) {
        try {
            map.put(AttributeEnum.ATTACKS, new UnlimitedAttribute(Integer.parseInt(stats.get(value))));
        } catch (NumberFormatException ex) {
            errorFlag = true;
            System.out.println(errorFlag+"tututu2");
            System.out.println(value+"value");
            errorIndexes.add(value-1);
            System.out.println(errorIndexes);
        }
    }
}
