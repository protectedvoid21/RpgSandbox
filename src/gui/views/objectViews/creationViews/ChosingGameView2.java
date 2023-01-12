package gui.views.objectViews.creationViews;

import gui.factories.IOverallFactory;
import gui.customComponents.AbstractCustomButton;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.views.gamePanel.gamePanels.CreatorPanel;
import gui.views.objectViews.AllObjectsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChosingGameView2 extends ChoosingCreationGameView {
    protected ArrayList<CreatorPanel> data = new ArrayList<>();


    public ChosingGameView2(IOverallFactory factory) {
        super(factory);

    }
    protected ArrayList<? extends Object> getCards(){
        return data;
    }


    public void uploadData(ArrayList<CreatorPanel> data) {
        this.data = data;
        currentSide = 0;
        arrowPanel.updateSwitchingButtons();
        updateContent();
    }

    @Override
    public ArrayList<? extends CreatorPanel> getData() {
        return data;
    }


    @Override
    protected void updateContent() {
        int maxSideIndex = getSideMaximumElementsNumber();
        int dataSize = data.size();
        var sublist = data.subList(currentSide * maximumumElements, maxSideIndex > dataSize ? dataSize :
                maxSideIndex);
        int currentIndex = 0;
        for (var key : sublist) {
            manager.getMiddleComponent(0, currentIndex).changeContent(key.getPanel());
            key.getPanel().setVisible(true);
            currentIndex++;
        }
        setAllowButtonVisibility(true, true);
        if (sublist.size() < maximumumElements) {
            for (int i = dataSize % maximumumElements; i < maximumumElements; i++) {
                manager.getMiddleComponent(0, i).getComponent().setVisible(false);
            }
        }
        setAllowButtonVisibility(dataSize!=0, sublist.size()%maximumumElements==0 && dataSize!=0);

    }


}
