//package gui.card;
//
//import gui.customComponents.AbstractCustomLabel;
//import gui.factories.GuiFactory;
//import gui.menu.ComponentPanelMenager;
//import gui.menu.ComponentsSeries;
//import gui.menu.DefaultCustomMenuMenager;
//
//import java.util.AbstractMap;
//import java.util.ArrayList;
//import java.util.TimerTask;
//
//public class StatsCard {
//    private GuiFactory factory;
//    private int currentAttrSide = 0;
//    private AbstractMap.SimpleEntry<String, String> titleIconPathName;
//    private ArrayList<AbstractMap.SimpleEntry<String, String>> dataMap;
//    private DefaultCustomMenuMenager<AbstractCustomLabel> menager =
//            new DefaultCustomMenuMenager<>(ComponentsSeries.ComponentsDimension.HORIZONTAL,
//                    ComponentsSeries.ComponentsDimension.VERTICAL);
//    private int maximumElementNumber = 5;
//
//    public StatsCard(AbstractMap.SimpleEntry<String, String> titleIconPathName,
//                     ArrayList<AbstractMap.SimpleEntry<String,
//            String>> dataMap, GuiFactory factory) {
//        this.factory = factory;
//        this.titleIconPathName = titleIconPathName;
//        this.dataMap = dataMap;
//    }
//
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
//
//    private boolean isSwitchForwardSidePossible() {
//        return dataMap.size() > maximumElementNumber * currentAttrSide;
//    }
//
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
//        setCorrectBlockStatus();
//    }
//}
