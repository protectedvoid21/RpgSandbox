package gui.actionListener;

import game.equipment.Item;

import java.util.ArrayList;
import java.util.List;

public class PathsArrayListGenerator {
    public static ArrayList<String> generatePathsArrayList(List<? extends Item> items) {
        var array = new ArrayList<String>();
        for (var item : items) {
            array.add(item.getItemPathPicture());
        }
        return array;
    }
}
