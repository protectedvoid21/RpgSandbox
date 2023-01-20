package gui.views.gamePanel.optionsPanels;

import game.generals.Vector2;


import java.util.AbstractMap;
import java.util.ArrayList;

public class OptionsPanelData {
    private ArrayList<AbstractMap.SimpleEntry<Vector2, ArrayList<Integer>>> disabledIndexesList  =new ArrayList<>();

    public void setPointData(Vector2 point, ArrayList<Integer> newIndexes){
        for (var pair : disabledIndexesList){
            if (pair.getKey().equals(point)){
                disabledIndexesList.get(disabledIndexesList.indexOf(pair)).setValue(newIndexes);
                return;
            }
        }
        disabledIndexesList.add(new AbstractMap.SimpleEntry<>(point, newIndexes));
    }

    public ArrayList<Integer> getPointData(Vector2 point){
        for (var pair : disabledIndexesList){
            if (pair.getKey().equals(point)){
                return disabledIndexesList.get(disabledIndexesList.indexOf(pair)).getValue();
            }
        }
        return new ArrayList<>();
    }
    public boolean getPointData(Vector2 point, int index){
        for (var pair : disabledIndexesList){
            if (pair.getKey().equals(point)){
                return disabledIndexesList.get(disabledIndexesList.indexOf(pair)).getValue().contains(index);
            }
        }
        return false;
    }


}
