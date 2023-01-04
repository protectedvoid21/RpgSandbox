package game.utils;

import game.board.Vector2;

import java.util.ArrayList;
import java.util.List;

public class MathHelper {
    public static List<Vector2> getGridCircle(int range) {
        List<Vector2> coordinatesList = new ArrayList<>();
        for (int x = 0; x <= range; x++) {
            for (int y = 0; y <= range; y++) {
                if (x + y > range) {
                    continue;
                }

                coordinatesList.add(new Vector2(x, y));
                if (x != 0 && y != 0) {
                    coordinatesList.add(new Vector2(-x, y));
                    coordinatesList.add(new Vector2(x, -y));
                    coordinatesList.add(new Vector2(-x, -y));
                }
                if (x == 0 && y != 0) {
                    coordinatesList.add(new Vector2(x, -y));
                }
                if (x != 0 && y == 0) {
                    coordinatesList.add(new Vector2(-x, y));
                }
            }
        }
        return coordinatesList;
    }
}
