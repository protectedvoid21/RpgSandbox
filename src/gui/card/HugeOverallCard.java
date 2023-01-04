//package gui.card;
//
//import gui.customComponents.AbstractCustomButton;
//import gui.customComponents.AbstractCustomLabel;
//import gui.factories.GuiFactory;
//import gui.menu.ComponentPanelMenager;
//import gui.menu.ComponentsSeries;
//import gui.menu.DefaultCustomMenuMenager;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.*;
//
//public class HugeOverallCard extends MiniOverallCard {
//
//    private ArrayList<ActionListener> cardActions = new ArrayList<>();
//    protected ArrayList<AbstractCustomButton> goList = new ArrayList<>();
//
//    /**
//     * dataMap should be in format [[path1, text1], [path2, text2], [path3, text3]...]
//     */
//    public HugeOverallCard(
//            GuiFactory factory, ArrayList<ActionListener> cardListeners) {
//        super(factory);
//        cardActions = cardListeners;
//    }
//
//
//
//    @Override
//    protected void updateContent() {
//       super.updateContent();
//        int maxSideIndex = getSideMaximumElementsNumber();
//        int dataSize = data.content.size();
//        var sublist = data.content.subList(currentAttrSide * maximumElementNumber, maxSideIndex > dataSize ? dataSize :
//                maxSideIndex);
//        if (sublist.size() < maximumElementNumber) {
//            for (int i = dataSize % maximumElementNumber; i < maximumElementNumber; i++) {
//                goList.get(i).setContent(Card.EMPTY_DATA_CONTENT);
//            }
//        }
//        Card.setAspectVisible(goList, true);
//    }
//
//    @Override
//    protected void initializeContent() {
//        int i = 0;
//        for (var key : cardActions) {
//            factory.setLabelType(GuiFactory.LabelType.ICON);
//            var label = factory.createLabel(Card.EMPTY_DATA_CONTENT);
//            factory.setLabelType(GuiFactory.LabelType.NORMAL);
//            var label2 = factory.createLabel(Card.EMPTY_DATA_CONTENT);
//            factory.setButtonType(GuiFactory.ButtonType.NORMAL);
//            var button = factory.createButton(Card.EMPTY_DATA_CONTENT, null);
//            button.addActionListener(key);//dodac pewnie zmiane listenera
//
//            var newPanel =
//                    new ComponentsSeries<ComponentPanelMenager<JComponent>>(ComponentsSeries.ComponentsDimension.HORIZONTAL);
//
//            for (var panel : Arrays.asList(label, label2, button)) {
//                newPanel.addOption(new ComponentPanelMenager<>(panel), 2);
//            }
//            getContentMenager().addMiddleComponent(newPanel, i / 2, 20);
//            newPanel.getOption(1).addSpace(1, ComponentPanelMenager.Side.LEFT, ComponentPanelMenager.Side.RIGHT);
//            newPanel.getOption(2).addSpace(1, ComponentPanelMenager.Side.LEFT);
//            newPanel.getOption(1).addSpace(2, ComponentPanelMenager.Side.BOTTOM, ComponentPanelMenager.Side.TOP);
//            newPanel.getOption(2).addSpace(2, ComponentPanelMenager.Side.BOTTOM, ComponentPanelMenager.Side.TOP);
//
//            getContentMenager().getMiddleComponent(i / 2, i % 2).addSpace(1);
//            labelList.add(label);
//            labelList.add(label2);
//            goList.add(button);
//            i++;
//        }
////        updateContent();
//
//    }
//
//
//
//    @Override
//    public void setUniformForm() {
//        super.setUniformForm();
//        SharedCmpsFont.setUniformFont(labelList);
//    }
//
//}