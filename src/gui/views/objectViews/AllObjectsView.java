package gui.views.objectViews;

import gui.card.DoubleArrowPanel;
import gui.card.IOverallFactory;
import gui.card.SwitchableComponent;
import gui.customComponents.AbstractCustomButton;
import gui.factories.GuiFactory;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;
import gui.views.BackgroundView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class AllObjectsView extends BackgroundView implements SwitchableComponent {
    protected HashMap<Integer, HashMap<ButtonType,ActionListener>> listenerHashMap = new HashMap<>();
    protected IOverallFactory factory;
    protected DefaultCustomMenuMenager manager =
            new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.VERTICAL,
                    ComponentsSeries.ComponentsDimension.HORIZONTAL);
    protected DoubleArrowPanel arrowPanel;
    private AbstractCustomButton cancelButton;
    protected int currentSide = 0;
    protected int maximumumElements = 4;
    protected int clickedIndex = -1;

    public enum ButtonType {SHOW, EDIT, DELETE}


    public void addButtonActionListener(ButtonType type, int index, ActionListener listener) {
        JButton button = null;
        if (!listenerHashMap.containsKey(index)) {
            listenerHashMap.put(index, new HashMap<>());
        }
        listenerHashMap.get(index).put(type, listener);
    }

    public AllObjectsView(IOverallFactory factory) {
        this.factory = factory;
    }

    public AbstractCustomButton getCancelButton() {
        return cancelButton;
    }

    protected void initialize(int maximumumElements) {
        this.maximumumElements = maximumumElements;

        int maxindex = (maximumumElements+ 1) / 2;
        for (int i = 0; i < maxindex; i++) {
            manager.addMainComponent(24);
        }
        manager.addMainComponent(5);
        arrowPanel = new DoubleArrowPanel(factory.getFactory(), this);
        arrowPanel.setSpace(2);
        factory.getFactory().setButtonType(GuiFactory.ButtonType.NORMAL);
        cancelButton = factory.getFactory().createButton("CANCEL", null);
        manager.addMiddleComponent(arrowPanel.getPanel(), maxindex, 10);
        manager.addMiddleComponent(cancelButton, maxindex, 10);
        manager.getMiddleComponent(maxindex, 1).addSpace(2);
    }

    public int getClickedIndex(){
        return clickedIndex;
    }
    @Override
    protected DefaultCustomMenuMenager getMenager() {
        return manager;
    }

    public JPanel getPanel() {
        return manager.getCmp();
    }

    @Override
    public void switchSide(DoubleArrowPanel.Side side) {
        if (isSwitchingSidePossible(side)) {
            switch (side) {
                case LEFT -> currentSide--;
                case RIGHT -> currentSide++;
            }
            updateContent();

        }
    }

    protected abstract void initializeContent();



    public abstract ArrayList<? extends Object> getData();

    protected abstract void updateContent();

    @Override
    public boolean isSwitchingSidePossible(DoubleArrowPanel.Side side) {
        boolean status = false;
        switch (side) {
            case LEFT -> status = currentSide > 0;
            case RIGHT -> status = getSideMaximumElementsNumber() < getData().size();
        }
        return status;
    }

    public int getSideMaximumElementsNumber() {
        return maximumumElements * (currentSide + 1);
    }
}
