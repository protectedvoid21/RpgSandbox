package gui.card;

import gui.customComponents.AbstractCustomLabel;
import gui.customComponents.ITextCustomUICmp;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.TimerTask;

public abstract class AbstractCard {
    protected GuiFactory factory;
    protected int currentAttrSide = 0;
    protected AbstractMap.SimpleEntry<String, String> titleIconPathName;
    protected ArrayList<AbstractMap.SimpleEntry<String, String>> dataMap;
    protected DefaultCustomMenuMenager<AbstractCustomLabel> menager =
            new DefaultCustomMenuMenager<>(ComponentsSeries.ComponentsDimension.HORIZONTAL,
                    ComponentsSeries.ComponentsDimension.VERTICAL);
    protected int maximumElementNumber;

    public AbstractCard(AbstractMap.SimpleEntry<String, String> titleIconPathName,
                        ArrayList<AbstractMap.SimpleEntry<String,
                                String>> dataMap, GuiFactory factory) {
        this.factory = factory;
        this.titleIconPathName = titleIconPathName;
        this.dataMap = dataMap;
        menager.addMainComponent(10);
        menager.addMainComponent(10);
    }

    public void reset(){
        currentAttrSide = 0;
    }

    public DefaultCustomMenuMenager getMenager() {
        return menager;
    }

    public void setDataMap(ArrayList<AbstractMap.SimpleEntry<String,
            String>> dataMap) {
        this.dataMap = dataMap;
        updateContent();
    }

    public void setTitleData(AbstractMap.SimpleEntry<String, String> titleIconPathName) {
        this.titleIconPathName = titleIconPathName;
        updateTitle();

    }

    private boolean isSwitchForwardSidePossible() {
        return dataMap.size() > maximumElementNumber * currentAttrSide;
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

    public abstract void initializeTitle(); //zmienia sie

    //        factory.setLabelType(GuiFactory.LabelType.ICON);
//        menager.addMiddleComponent(factory.createLabel(titleIconPathName.getKey()), 0, 30);
//        menager.getMiddleComponent(0, 0).addSpace(6, ComponentPanelMenager.Side.LEFT, ComponentPanelMenager.Side.TOP);
//        menager.getMiddleComponent(0, 0).addSpace(1, ComponentPanelMenager.Side.RIGHT);
//        menager.getMiddleComponent(0, 0).addSpace(2, ComponentPanelMenager.Side.BOTTOM);
//
//        factory.setLabelType(GuiFactory.LabelType.NORMAL);
//        menager.addMiddleComponent(factory.createLabel(titleIconPathName.getValue()), 1, 30);
//        menager.getMiddleComponent(1, 0).addSpace(6, ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.TOP,
//                ComponentPanelMenager.Side.BOTTOM);
//        menager.getMiddleComponent(1, 0).addSpace(1, ComponentPanelMenager.Side.LEFT);
//
//    }
    protected abstract void updateTitle();

    protected abstract void updateContent();

    protected abstract void initializeContent();

//    private void updateTitle() {//zmienia sie
//        factory.setLabelType(GuiFactory.LabelType.ICON);
//        menager.getMiddleComponent(0, 0).getComponent().setContent(titleIconPathName.getKey());
//        factory.setLabelType(GuiFactory.LabelType.NORMAL);
//        menager.getMiddleComponent(0, 0).getComponent().setText(titleIconPathName.getValue());
//    }
//
//    private void updateContent() {//zmienia sie
//        int maxSideIndex = getSideMaximumElementsNumber();
//        int dataSize = dataMap.size();
//
//        var sublist = dataMap.subList(currentAttrSide * maximumElementNumber, maxSideIndex > dataSize ? dataSize :
//                maxSideIndex);
//        while (sublist.size() < maximumElementNumber) {
//            sublist.add(new AbstractMap.SimpleEntry<>(Card.EMPTY_DATA_CONTENT, Card.EMPTY_DATA_CONTENT));
//        }
//        int currentIndex = 1;
//        setContentVisible(false);
//        for (var key : sublist) {
//            menager.getMiddleComponent(0, currentIndex).getComponent().setText(key.getKey());
//            menager.getMiddleComponent(1, currentIndex).getComponent().setText(key.getValue());
//            currentIndex++;
//        }
//        new java.util.Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                setContentVisible(true);
//            }
//        }, 200);
//
//    }
//
//    public void initializeContent() {//zmienia sie
//        for (int i = 1; i < maximumElementNumber + 1; i++) {
//            menager.addMiddleComponent(factory.createLabel(Card.EMPTY_DATA_CONTENT), 0, 10);
//            menager.getMainComponent(0).getComponent().getLastComponent().addSpace(2, ComponentPanelMenager.Side.LEFT
//                    , ComponentPanelMenager.Side.BOTTOM, ComponentPanelMenager.Side.TOP);
//
//            menager.addMiddleComponent(factory.createLabel(Card.EMPTY_DATA_CONTENT), 1, 10);
//            menager.getMainComponent(1).getComponent().getLastComponent().addSpace(2,
//                    ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.BOTTOM,
//                    ComponentPanelMenager.Side.TOP);
//        }
//        updateContent();
////        setCorrectBlockStatus();
//    }

    public void setContentVisible(boolean status) {//uniwersalna karta i nastepnie upload danych konkretnej karty,
        // kazda karta bedzie posiadac
        var firstNo = menager.getMiddleComponent(0, 0).getComponent();
        var secondNo = menager.getMiddleComponent(1, 0).getComponent();
        for (var cmp : menager.getComponentsList()) {
            if (cmp != firstNo && cmp != secondNo) {
                if (status) {
                    cmp.getCustomUI().setRelevantFont(cmp.getText());//meh slabe
                }
                cmp.setVisible(cmp.getText() == "" ? false : status);//jesli border panela to pewnie problem ale
                // niech bedzie
            }
        }
    }

    public void setUniformFont() {
        ArrayList<ITextCustomUICmp> cmpsUIs = new ArrayList<>();
        var mngrLst = menager.getComponentsList();
        var firstNo = menager.getMiddleComponent(0, 0).getComponent();
        var secondNo = menager.getMiddleComponent(1, 0).getComponent();

        for (var cmp : mngrLst) {
            if (cmp != firstNo && cmp != secondNo) {
                cmpsUIs.add(cmp);
            }
        }
        var sharecmpfont = new SharedCmpsFont(cmpsUIs);
        for (var cmpUI : cmpsUIs) {
            cmpUI.getCustomUI().setSharedComponentSize(sharecmpfont);
        }
    }
}