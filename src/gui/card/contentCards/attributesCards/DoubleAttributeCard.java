//package gui.card.contentCards.attributesCards;
//
//import gui.card.SharedCmpsFont;
//import gui.card.contentCards.AbstractCard;
//import gui.card.contentCards.detailCards.DetailButtonsCard;
//import gui.card.fullCards.abstractCards.Card;
//import gui.card.fullCards.specificCards.ChoserCard;
//import gui.customComponents.AbstractCustomLabel;
//import gui.customComponents.IContentCustomUICmp;
//import gui.factories.GuiFactory;
//import gui.menu.ComponentPanelMenager;
//import gui.menu.ComponentsSeries;
//import gui.menu.DefaultCustomMenuMenager;
//
//import javax.swing.*;
//import java.util.ArrayList;
//
//public class DoubleAttributeCard extends AbstractCard {
////    protected DefaultCustomMenuMenager<JComponent> menager =
//            new DefaultCustomMenuMenager<JComponent>(ComponentsSeries.ComponentsDimension.HORIZONTAL,
//                    ComponentsSeries.ComponentsDimension.VERTICAL);
//
//    private ChoserCard leftCard;
//    private ChoserCard rightCard;
////    private DetailButtonsCard leftDetailCard;\
////    private DetailButtonsCard rightDetailCard;
//
//
//    public DoubleAttributeCard(GuiFactory factory) {
//        super(factory);
//    }
//
//
//
//
//
//    @Override
//    public DefaultCustomMenuMenager<JComponent> getContentMenager() {
//        return menager;
//    }
//
//    public void initializeCard() {
//        initializeCard(5);
//        initializeContent();
//    }
//
//    @Override
//    protected void initializeCard(int maximumElementNumber) {
//        menager.addMainComponent(10);
//        menager.addMainComponent(10);
//
//        super.initializeCard(maximumElementNumber);
//    }
//
//    protected void updateContent() {//zmienia sie
//        int maxSideIndex = getSideMaximumElementsNumber();
//        int dataSize = data.content.size();
//        var sublist = data.content.subList(currentAttrSide * maximumElementNumber, maxSideIndex > dataSize ? dataSize :
//                maxSideIndex);
//
//        int currentIndex = 0;
//        System.out.println(labelList);
//
//        for (var key : sublist) {
//            System.out.println(key.get(0));
//            labelList.get(currentIndex).setContent(key.get(0));
//            System.out.println("czy ja tu cos robie222" + labelList.get(currentIndex).getContent());
//            getSecondContentList().get(currentIndex).setContent(key.get(1));
////            menager.getMiddleComponent(0, currentIndex).getComponent().setText(key.get(0));
////            menager.getMiddleComponent(1, currentIndex).getComponent().setText(key.get(1));
//            currentIndex++;
//        }
//
//
//        System.out.println();
//        if (sublist.size() < maximumElementNumber) {
//            for (int i = dataSize % maximumElementNumber; i < maximumElementNumber; i++) {
//                System.out.println("czy ja tu cos robie");
//                labelList.get(i).setContent(Card.EMPTY_DATA_CONTENT);
//                getSecondContentList().get(i).setContent(Card.EMPTY_DATA_CONTENT);
////                menager.getMiddleComponent(0, i).getComponent().setText(Card.EMPTY_DATA_CONTENT);
////                menager.getMiddleComponent(1, i).getComponent().setText(Card.EMPTY_DATA_CONTENT);
//            }
//        }
//
//        Card.setAspectVisible(labelList, true);
//
//    }
//
////    protected JComponent baseComponentCreator(){
////        return  factory.createLabel(Card.EMPTY_DATA_CONTENT);
////    }
//
//
//    @Override
//    protected void initializeContent() {//zmienia sie
//        factory.setLabelType(GuiFactory.LabelType.NORMAL);
//        for (int i = 0; i < maximumElementNumber; i++) {
//            var label = factory.createLabel(Card.EMPTY_DATA_CONTENT);
//            menager.addMiddleComponent(label, 0, 10);
//            menager.getMainComponent(0).getComponent().getLastComponent().addSpace(2, ComponentPanelMenager.Side.LEFT
//                    , ComponentPanelMenager.Side.BOTTOM, ComponentPanelMenager.Side.TOP);
//            labelList.add(label);
//
//            var x = createSecondContentComponent();
//            System.out.println(x + "kurwa");
//            menager.addMiddleComponent(x, 1, 10);
//            menager.getMainComponent(1).getComponent().getLastComponent().addSpace(2,
//                    ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.BOTTOM,
//                    ComponentPanelMenager.Side.TOP);
//
//        }
//
////        updateContent();
//    }
//
//    @Override
//    public void setUniformForm() {
//        leftCard.setUniformFont();
//        rightCard.setUniformFont();
////        SharedCmpsFont.setUniformFont(labelList);
//    }
//}
