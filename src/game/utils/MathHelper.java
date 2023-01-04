package game.utils;

import java.util.ArrayList;
import java.util.List;

public class MathHelper {
    public static List<Integer[]> getGridCircle(int range) {
        List<Integer[]> coordinatesList = new ArrayList<>();
        for (int x = 0; x <= range; x++)
            for (int y = 0; y <= range; y++) {
                if (x + y <= range) {
                    coordinatesList.add(new Integer[]{x, y});
                    if (x != 0 && y != 0) {
                        coordinatesList.add(new Integer[]{-x, y});
                        coordinatesList.add(new Integer[]{x, -y});
                        coordinatesList.add(new Integer[]{-x, -y});
                    }
                    if (x == 0 && y != 0) {
                        coordinatesList.add(new Integer[]{x, -y});
                    }
                    if (x != 0 && y == 0) {
                        coordinatesList.add(new Integer[]{-x, y});
                    }
                }
            }
        return coordinatesList;
    }
}
