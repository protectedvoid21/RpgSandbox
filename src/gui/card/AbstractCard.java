package gui.card;

import gui.customComponents.AbstractCustomLabel;
import gui.customComponents.CustomLabel;
import gui.customComponents.IContentCustomUICmp;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.TimerTask;

public abstract class AbstractCard<T extends JComponent> implements SwitchableComponent {
    protected GuiFactory factory;
    protected int currentAttrSide = 0;
    protected AbstractMap.SimpleEntry<String, String> titleIconPathName;
    protected ArrayList<ArrayList<String>> dataMap;
    private ComponentsSeries<JComponent> mainSeries =
            new ComponentsSeries<>(ComponentsSeries.ComponentsDimension.VERTICAL);
    protected int maximumElementNumber;

    public AbstractCard(AbstractMap.SimpleEntry<String, String> titleIconPathName,
                        ArrayList<ArrayList<String>> dataMap, GuiFactory factory) {
        this.factory = factory;
        this.titleIconPathName = titleIconPathName;
        this.dataMap = dataMap;
    }

    protected void initializeCard(int maximumElementNumber) {
        this.maximumElementNumber = maximumElementNumber;
        mainSeries.addOption(getContentMenager().getCmp(), 7);
        initializeContent();
    }

    public void reset() {
        currentAttrSide = 0;
        updateContent();
    }

    public ComponentsSeries<JComponent> getMenager() {
        return mainSeries;
    }

    public abstract DefaultCustomMenuMenager<T> getContentMenager();

    public void setDataMap(ArrayList<ArrayList<String>> dataMap) {
        this.dataMap = dataMap;
        updateContent();
    }


    public String getFirstTitleContent() {
        return titleIconPathName.getKey();
    }

    public String getSecondTitleContent() {
        return titleIconPathName.getValue();
    }


    protected int getSideMaximumElementsNumber() {
        return maximumElementNumber * (currentAttrSide + 1);
    }

    public void switchSide(DoubleArrowPanel.Side side) {
        if (isSwitchingSidePossible(side)) {
            switch (side) {
                case LEFT -> currentAttrSide--;
                case RIGHT -> currentAttrSide++;
            }
            updateContent();

        }
    }

    public boolean isSwitchingSidePossible(DoubleArrowPanel.Side side) {
        boolean status = false;
        switch (side) {
            case LEFT -> status = currentAttrSide > 0;
            case RIGHT -> status = getSideMaximumElementsNumber() < dataMap.size();
        }
        return status;
    }


    protected abstract void updateContent();

    protected abstract void initializeContent();

    public abstract void setUniformForm();


}