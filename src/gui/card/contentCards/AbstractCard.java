package gui.card.contentCards;

import gui.card.CardContentDataSet;
import gui.card.DoubleArrowPanel;
import gui.card.SwitchableComponent;
import gui.factories.GuiFactory;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;
import java.util.ArrayList;

public abstract class AbstractCard<T extends JComponent> implements SwitchableComponent {
    protected GuiFactory factory;
    protected int currentAttrSide = 0;
    protected CardContentDataSet data;
    protected ArrayList<CardContentDataSet> detailData = new ArrayList<>();

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
    public void initializeCardData(CardContentDataSet data, ArrayList<CardContentDataSet> detailData) {
        this.data = data;
        this.detailData = detailData;
        reset();
    }

    public int getMaximumElementNumber(){
        return maximumElementNumber;
    }

    public CardContentDataSet getData(){
        return data;
    }

    protected void initializeCard(int maximumElementNumber) {
        this.maximumElementNumber = maximumElementNumber;
        mainSeries.addOption(getContentMenager().getCmp(), 7);
//        initializeContent();
    }

//    public void setDetailData(ArrayList<CardContentDataSet> detailData){
//        this.detailData = detailData;
//
//    }

    public void reset() {
        currentAttrSide = 0;
        updateContent();
    }

    public ComponentsSeries<JComponent> getMenager() {
        return mainSeries;
    }

    public abstract DefaultCustomMenuMenager<T> getContentMenager();



    public String getFirstTitleContent() {
        return data.titlePath;
    }

    public String getSecondTitleContent() {
        return data.titleContent;
    }


    public int getSideMaximumElementsNumber() {
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

    public abstract void initializeCard();

//    public abstract void makeFullContentTransparent();


}