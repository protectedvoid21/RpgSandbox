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
    private static ArrayList<Integer> errorIndexes = new ArrayList<>();
    private static boolean errorFlag = false;

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
                errorFlag = true;
            }
        }

        setAttr(stats, attributes, AttributeEnum.ATTACKS, 9);
        setAttr(stats, attributes, AttributeEnum.ATTACKS, 10);
        setAttr(stats, attributes, AttributeEnum.ATTACKS, 11);
        setAttr(stats, attributes, AttributeEnum.ATTACKS, 12);

        StatisticsWarhammer statistics = new StatisticsWarhammer(attributes);

        return statistics;
    }

    public static ArrayList<Integer> getErrorIndexes() {
        return errorIndexes;
    }

    public static boolean isErrorFlag() {
        return errorFlag;
    }

    private void setAttr(ArrayList<String> stats, Map<IAttributeEnum, AttributeValue> map, AttributeEnum enumValue,
                         int value) {
        try {
            map.put(AttributeEnum.ATTACKS, new UnlimitedAttribute(Integer.parseInt(stats.get(value))));
        } catch (NumberFormatException ex) {
            errorFlag = true;
            errorIndexes.add(value-1);
        }
    }
}
