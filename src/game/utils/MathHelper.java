package game.utils;

import game.generals.Vector2;

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

    public static List<Vector2> getGridCircle(int range,Vector2 vector2) {
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

        List<Vector2> result = new ArrayList<>();

        for(int i = 0; i < coordinatesList.size(); i++ ){
            result.add(new Vector2(coordinatesList.get(i).x + vector2.x, coordinatesList.get(i).y + vector2.y));
        }
        return result;
    }


    public static List<Vector2> getNextCels(Vector2 position){
        List<Vector2> cels = new ArrayList<Vector2>();

        cels.add(new Vector2(position.x -1, position.y -1 ));
        cels.add(new Vector2(position.x -1, position.y  ));
        cels.add(new Vector2(position.x -1, position.y +1 ));
        cels.add(new Vector2(position.x , position.y -1 ));
        cels.add(new Vector2(position.x , position.y +1 ));
        cels.add(new Vector2(position.x +1, position.y -1 ));
        cels.add(new Vector2(position.x +1, position.y ));
        cels.add(new Vector2(position.x +1, position.y +1 ));

        return cels;
    }
}
