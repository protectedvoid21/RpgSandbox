package gui.views.gamePanel.optionsPanels;

import gui.views.Point;

import java.util.AbstractMap;
import java.util.ArrayList;

public class OptionsPanelData {
    private ArrayList<AbstractMap.SimpleEntry<Point, ArrayList<Integer>>> disabledIndexesList  =new ArrayList<>();

    public void setPointData(Point point, ArrayList<Integer> newIndexes){
        for (var pair : disabledIndexesList){
            if (pair.getKey().equals(point)){
                disabledIndexesList.get(disabledIndexesList.indexOf(pair)).setValue(newIndexes);
                return;
            }
        }
        disabledIndexesList.add(new AbstractMap.SimpleEntry<>(point, newIndexes));
    }

    public ArrayList<Integer> getPointData(Point point){
        for (var pair : disabledIndexesList){
            if (pair.getKey().equals(point)){
                return disabledIndexesList.get(disabledIndexesList.indexOf(pair)).getValue();
            }
        }
        return new ArrayList<>();
    }
    public boolean getPointData(Point point, int index){
        for (var pair : disabledIndexesList){
            if (pair.getKey().equals(point)){
                return disabledIndexesList.get(disabledIndexesList.indexOf(pair)).getValue().contains(index);
            }
        }
        return false;
    }


}
