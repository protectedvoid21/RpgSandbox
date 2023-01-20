package gui.views.gamePanel.gamePanels;

import game.generals.Vector2;
import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.AbstractCustomLabel;
import gui.customComponents.iconComponents.IconLabel;

import javax.swing.*;
import java.util.ArrayList;

public class ActionsData {
    private ArrayList<IconLabel> arrayList = new ArrayList<>();
    private int usedObjects;
    private String path;

    public ActionsData() {
        for (int i = 0; i < 10; i++) {
            var la = new IconLabel(Card.EMPTY_DATA_CONTENT,true);
            la.setVisible(false);
            arrayList.add(la);
        }
    }

    public void setPath(String path) {
        this.path = path;
        for (var label : arrayList) {
            label.setContent(path);
        }
    }


    public IconLabel getNextObject() {
        usedObjects++;
        if (usedObjects >= arrayList.size()) {
            var l = new IconLabel(path,true);
            arrayList.add(l);
            return l;
        }
        for (var label : arrayList){
            if(!label.isVisible()){
                label.setVisible(true);
                return label;
            }
        }
        return null;
    }

    public void removeObject(AbstractCustomLabel label){
        label.setVisible(false);
        usedObjects--;
    }
}
