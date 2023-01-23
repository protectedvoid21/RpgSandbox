package game.cardManager.Warhammer;

import game.generals.AttributeValue;
import game.generals.LimitedAttribute;
import game.generals.UnlimitedAttribute;
import game.interfaceWarhammer.AttributeEnum;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaces.IAttributeEnum;
import game.interfaces.IDecodeArrayStatistics;
import game.interfaces.Statistics;
import game.utils.ErrorValidationChecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DecodeArrayStatisticsWarhammer implements IDecodeArrayStatistics {
//    private static ArrayList<Integer> errorIndexes = new ArrayList<>();
    //    private static boolean errorFlag = false;
    private static ErrorValidationChecker errorValidationChecker = new ErrorValidationChecker();

    public static ErrorValidationChecker getErrorValidationChecker() {
        return errorValidationChecker;
    }

    @Override
    public Statistics decode(ArrayList<String> stats) {
//        errorFlag = false;
//        errorIndexes.clear();
        errorValidationChecker.resetErrorFlags();
        Map<IAttributeEnum, AttributeValue> attributes = new HashMap<>();
        for (int i = 1; i < 9; i++) {
            try {
                var value = Integer.parseInt(stats.get(i));
                if (value < 0 || value > 100) {
                    throw new NumberFormatException();
                }
                attributes.put(AttributeEnum.values()[i - 1], new LimitedAttribute(0, 100,
                        value));

            } catch (NumberFormatException ex) {
//                errorIndexes.add(i - 1);
//                errorFlag = true;
                errorValidationChecker.addIntexToErrorList(i-1);
            }
        }

        setAttr(stats, attributes, AttributeEnum.ATTACKS, 9);
        setAttr(stats, attributes, AttributeEnum.HEALTH_POINTS_NOW, 10);
        setAttr(stats, attributes, AttributeEnum.HEALTH_POINTS_MAX, 11);
        setAttr(stats, attributes, AttributeEnum.MOVEMENT, 12);

        StatisticsWarhammer statistics = new StatisticsWarhammer(attributes);

        return statistics;
    }

//    public static ArrayList<Integer> getErrorIndexes() {
//        return errorIndexes;
//    }
//
//    public static boolean isErrorFlag() {
//        return errorFlag;
//    }

    private void setAttr(ArrayList<String> stats, Map<IAttributeEnum, AttributeValue> map, AttributeEnum enumValue,
                         int value) {
        try {
            var intValue = Integer.parseInt(stats.get(value));
            if (intValue < 0) {
                throw new NumberFormatException();
            }
            map.put(enumValue, new UnlimitedAttribute(intValue));
        } catch (NumberFormatException ex) {
            errorValidationChecker.addIntexToErrorList(value-1);
        }
    }
}
