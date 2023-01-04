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
//    protected AbstractMap.SimpleEntry<String, String> titleIconPathName= new AbstractMap.SimpleEntry<>("", "");
//    protected ArrayList<ArrayList<String>> dataMap = new ArrayList<>();
    protected CardContentDataSet data;
    private ComponentsSeries<JComponent> mainSeries =
            new ComponentsSeries<>(ComponentsSeries.ComponentsDimension.VERTICAL);
    protected int maximumElementNumber;

    public AbstractCard(GuiFactory factory) {
        this.factory = factory;
    }

    public void initializeCardData(CardContentDataSet data) {
        this.data = data;
        reset();
    }

    public CardContentDataSet getData(){
        return data;
    }
//    public void initializeCardData(AbstractMap.SimpleEntry<String, String> titleIconPathName) {
//        this.titleIconPathName = titleIconPathName;
//        reset();
//    }
//
//    public void initializeCardData( ArrayList<ArrayList<String>> dataMap) {
//        this.dataMap = dataMap;
//        reset();
//    }

    protected void initializeCard(int maximumElementNumber) {
        this.maximumElementNumber = maximumElementNumber;
        mainSeries.addOption(getContentMenager().getCmp(), 7);
//        initializeContent();
    }

    public void reset() {
        currentAttrSide = 0;
        updateContent();
    }

    public ComponentsSeries<JComponent> getMenager() {
        return mainSeries;
    }

    public abstract DefaultCustomMenuMenager<T> getContentMenager();

//    public void setDataMap(ArrayList<ArrayList<String>> dataMap) {
//        this.dataMap = dataMap;
//        updateContent();
//    }


    public String getFirstTitleContent() {
        return data.titlePath;
    }

    public String getSecondTitleContent() {
        return data.titleContent;
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
            case RIGHT -> status = getSideMaximumElementsNumber() < data.content.size();
        }
        return status;
    }


    protected abstract void updateContent();

    protected abstract void initializeContent();

    public abstract void setUniformForm();


}