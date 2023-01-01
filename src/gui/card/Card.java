package gui.card;

import game.equipment.Item;
import gui.customComponents.AbstractCustomLabel;
import gui.customComponents.CustomLabel;
import gui.customComponents.ITextCustomUICmp;
import gui.customUI.customUIStyles.borderStrategies.AverageBorderStartegy;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;

public class Card {
    static final public String EMPTY_DATA_CONTENT = "";
    private AbstractCard activeCard;
    private Map<CardTypes, AbstractCard> allCards = new HashMap<>();

    public enum CardTypes {ATTRIBUTE, ARMOR, WEAPONS, EFFECTS}


//    private DefaultCustomMenuMenager<AbstractCustomLabel> menager =
//            new DefaultCustomMenuMenager<>(ComponentsSeries.ComponentsDimension.HORIZONTAL,
//                    ComponentsSeries.ComponentsDimension.VERTICAL);

    private DoubleArrowPanel leftArrows;
    private DoubleArrowPanel rightArrows;

    private DefaultCustomMenuMenager seriesPanel;
    private GuiFactory factory;
//    private int currentAttrSide = 0;
//    private AbstractMap.SimpleEntry<String, String> titleIconPathName;
//    private ArrayList<AbstractMap.SimpleEntry<String, String>> dataMap;
//    private int maximumElementNumber = 5;

    public Card(AbstractMap.SimpleEntry<String, String> titleIconPathName, ArrayList<AbstractMap.SimpleEntry<String,
            String>> dataMap, GuiFactory factory) {
        this.factory = factory;
        allCards.put(CardTypes.ATTRIBUTE, new AttributesCard(titleIconPathName, dataMap, factory));
        allCards.put(CardTypes.ARMOR, new ItemsCard(titleIconPathName, dataMap, factory));
//        this.titleIconPathName = titleIconPathName;
//        this.dataMap = dataMap;

//        var panel = new ComponentsSeries<>(ComponentsSeries.ComponentsDimension.VERTICAL);
//        panel.addOption(menager.getCmp(), 9);
//        panel.addOption(createArrowComponentSeries(), 2);
        seriesPanel = new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.VERTICAL,
                ComponentsSeries.ComponentsDimension.HORIZONTAL);
        seriesPanel.addMainComponent(9);
        seriesPanel.addMiddleComponent(new JPanel(), 0, 10);
        seriesPanel.addMainComponent(2);
        seriesPanel.addMiddleComponent(createArrowComponentSeries(), 1, 10);
        setCard(CardTypes.ATTRIBUTE);

//        seriesPanel.getComponent().

//        menager.addMainComponent(10);
//        menager.addMainComponent(10);
        seriesPanel.getCmp().setBorderData(Color.RED, new AverageBorderStartegy(), 8);
    }

    public void setCard(CardTypes type) {
        activeCard = allCards.get(type);
        seriesPanel.getMainComponent(0).changeContent(activeCard.getMenager().getCmp());
    }

//    public void setDataMap(ArrayList<AbstractMap.SimpleEntry<String,
//            String>> dataMap) {
//        this.dataMap = dataMap;
//        updateContent();
//    }
//
//    public void setTitleData(AbstractMap.SimpleEntry<String, String> titleIconPathName) {
//        this.titleIconPathName = titleIconPathName;
//        updateTitle();
//
//    }

    private ComponentsSeries createArrowComponentSeries() {
        var arrowsManager = new ComponentsSeries<>(ComponentsSeries.ComponentsDimension.HORIZONTAL);
        leftArrows = new DoubleArrowPanel(factory);
        leftArrows.setSpace(5);
        rightArrows = new DoubleArrowPanel(factory);
        rightArrows.setSpace(5);
        leftArrows.setListener(DoubleArrowPanel.Side.RIGHT, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchSide(DoubleArrowPanel.Side.RIGHT);
            }
        });
        leftArrows.setListener(DoubleArrowPanel.Side.LEFT, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchSide(DoubleArrowPanel.Side.LEFT);
            }
        });

        rightArrows.setListener(DoubleArrowPanel.Side.RIGHT, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activeCard.reset();
               setCard(CardTypes.ATTRIBUTE);
            }
        });
        rightArrows.setListener(DoubleArrowPanel.Side.LEFT, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activeCard.reset();
                setCard(CardTypes.ARMOR);
            }
        });
        arrowsManager.addOption(leftArrows.getPanel(), 5);
        arrowsManager.addOption(rightArrows.getPanel(), 5);
        return arrowsManager;
    }

//    private boolean isSwitchForwardSidePossible() {
//        return dataMap.size() > maximumElementNumber * currentAttrSide;
//    }
//
//    private boolean isSwitchBackSidePossible() {
//        return currentAttrSide > 0;
//    }

//    public void initializeTitle() {//zmienia sie
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
//
//    private void updateTitle() {//zmienia sie
//        factory.setLabelType(GuiFactory.LabelType.ICON);
//        menager.getMiddleComponent(0, 0).getComponent().setContent(titleIconPathName.getKey());
//        factory.setLabelType(GuiFactory.LabelType.NORMAL);
//        menager.getMiddleComponent(0, 0).getComponent().setText(titleIconPathName.getValue());
//    }

    public void switchSide(DoubleArrowPanel.Side side) {
        if (activeCard.isSwitchingSidePossible(side)) {
            activeCard.switchSide(side);
            setCorrectBlockStatus();
        }
    }

    public void switchMainSide(){
        setCard(CardTypes.ARMOR);
    }

    private void setCorrectBlockSideStatus(DoubleArrowPanel.Side side) {
        if (!activeCard.isSwitchingSidePossible(side)) {
            blockButton(side);
        } else {
            unblockButton(side);
        }
    }

    private void setCorrectBlockStatus() {
        setCorrectBlockSideStatus(DoubleArrowPanel.Side.LEFT);
        setCorrectBlockSideStatus(DoubleArrowPanel.Side.RIGHT);
    }

    private void blockButton(DoubleArrowPanel.Side side) {
        leftArrows.turnOffButton(side);
    }

    private void unblockButton(DoubleArrowPanel.Side side) {
        leftArrows.turnOnButton(side);
    }

//    private boolean isSwitchingSidePossible(DoubleArrowPanel.Side side) {
//        boolean status = false;
//        switch (side) {
//            case LEFT -> status = currentAttrSide > 0;
//            case RIGHT -> status = getSideMaximumElementsNumber() < dataMap.size();
//        }
//        return status;
//    }

//    private int getSideMaximumElementsNumber() {
//        return maximumElementNumber * (currentAttrSide + 1);
//    }

//
//    private void updateContent() {//zmienia sie
//        int maxSideIndex = getSideMaximumElementsNumber();
//        int dataSize = dataMap.size();
//
//        var sublist = dataMap.subList(currentAttrSide * maximumElementNumber, maxSideIndex > dataSize ? dataSize :
//                maxSideIndex);
//        while (sublist.size() < maximumElementNumber) {
//            sublist.add(new AbstractMap.SimpleEntry<>(EMPTY_DATA_CONTENT, EMPTY_DATA_CONTENT));
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
//            menager.addMiddleComponent(factory.createLabel(EMPTY_DATA_CONTENT), 0, 10);
//            menager.getMainComponent(0).getComponent().getLastComponent().addSpace(2, ComponentPanelMenager.Side.LEFT
//                    , ComponentPanelMenager.Side.BOTTOM, ComponentPanelMenager.Side.TOP);
//
//            menager.addMiddleComponent(factory.createLabel(EMPTY_DATA_CONTENT), 1, 10);
//            menager.getMainComponent(1).getComponent().getLastComponent().addSpace(2,
//                    ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.BOTTOM,
//                    ComponentPanelMenager.Side.TOP);
//        }
//        updateContent();
//        setCorrectBlockStatus();
//    }


    public void setBackgroundImage(String path) throws IOException {
        seriesPanel.getCmp().setBackgroundImage(path);
    }

    public void setBackgroundColor(Color color) {
        seriesPanel.setBackground(color);
    }

    public JPanel getPanel() {
        return seriesPanel.getCmp();
    }

//    public void setUniformFont() {
//        ArrayList<ITextCustomUICmp> cmpsUIs = new ArrayList<>();
//        var mngrLst = activeCard.getMenager().getComponentsList();
//        var firstNo = activeCard.getMenager().getMiddleComponent(0, 0).getComponent();
//        var secondNo = activeCard.getMenager().getMiddleComponent(1, 0).getComponent();
//
//        for (var cmp : mngrLst) {
//            if (cmp != firstNo && cmp != secondNo) {
//                cmpsUIs.add(cmp);
//            }
//        }
//        var sharecmpfont = new SharedCmpsFont(cmpsUIs);
//        for (var cmpUI : cmpsUIs) {
//            cmpUI.getCustomUI().setSharedComponentSize(sharecmpfont);
//        }
//    }

    public void setUniformFont() {
        for (var type : CardTypes.values()) {
            if (allCards.containsKey(type)) {
                allCards.get(type).setUniformFont();
            }
        }
    }

//    public void setContentVisible(boolean status) {//uniwersalna karta i nastepnie upload danych konkretnej karty,
//        // kazda karta bedzie posiadac
//        var firstNo = menager.getMiddleComponent(0, 0).getComponent();
//        var secondNo = menager.getMiddleComponent(1, 0).getComponent();
//        for (var cmp : menager.getComponentsList()) {
//            if (cmp != firstNo && cmp != secondNo) {
//                if (status) {
//                    cmp.getCustomUI().setRelevantFont(cmp.getText());//meh slabe
//                }
//                cmp.setVisible(cmp.getText() == "" ? false : status);//jesli border panela to pewnie problem ale
//                // niech bedzie
//            }
//        }
//    }

}
