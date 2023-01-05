package gui.card;

import gui.customComponents.AbstractCustomButton;
import gui.customComponents.AbstractCustomLabel;
import gui.customComponents.CustomLabel;
import gui.customComponents.IContentCustomUICmp;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class AttributesCard extends AbstractCard {
    protected DefaultCustomMenuMenager<JComponent> menager =
            new DefaultCustomMenuMenager<JComponent>(ComponentsSeries.ComponentsDimension.HORIZONTAL,
                    ComponentsSeries.ComponentsDimension.VERTICAL);

    protected ArrayList<AbstractCustomLabel> labelList = new ArrayList<>();

    public AttributesCard( GuiFactory factory) {
        super(factory);
//        initializeCard(5);
//        initializeContent();
    }


    @Override
    public DefaultCustomMenuMenager<JComponent> getContentMenager() {
        return menager;
    }

    public void initializeCard() {
        initializeCard(5);
        initializeContent();
    }

    @Override
    protected void initializeCard(int maximumElementNumber) {
        menager.addMainComponent(10);
        menager.addMainComponent(10);

        super.initializeCard(maximumElementNumber);
    }
    protected void updateContent() {//zmienia sie
        int maxSideIndex = getSideMaximumElementsNumber();
        int dataSize = data.content.size();
        var sublist = data.content.subList(currentAttrSide * maximumElementNumber, maxSideIndex > dataSize ? dataSize :
                maxSideIndex);

        int currentIndex = 0;
        System.out.println(labelList);

        for (var key : sublist) {
            System.out.println(key.get(0));
            labelList.get(currentIndex).setContent(key.get(0));
            System.out.println("czy ja tu cos robie222"+labelList.get(currentIndex).getContent());
            getSecondContentList().get(currentIndex).setContent(key.get(1));
//            menager.getMiddleComponent(0, currentIndex).getComponent().setText(key.get(0));
//            menager.getMiddleComponent(1, currentIndex).getComponent().setText(key.get(1));
            currentIndex++;
        }

        if (sublist.size() < maximumElementNumber) {
            for (int i = dataSize % maximumElementNumber; i < maximumElementNumber; i++) {
                System.out.println("czy ja tu cos robie");
                labelList.get(currentIndex).setContent(Card.EMPTY_DATA_CONTENT);
                getSecondContentList().get(currentIndex).setContent(Card.EMPTY_DATA_CONTENT);
//                menager.getMiddleComponent(0, i).getComponent().setText(Card.EMPTY_DATA_CONTENT);
//                menager.getMiddleComponent(1, i).getComponent().setText(Card.EMPTY_DATA_CONTENT);
            }
        }

//        Card.setAspectVisible(labelList, true);

    }

//    protected JComponent baseComponentCreator(){
//        return  factory.createLabel(Card.EMPTY_DATA_CONTENT);
//    }


    protected abstract JComponent createSecondContentComponent();

    protected abstract ArrayList<? extends IContentCustomUICmp> getSecondContentList();

    public void initializeContent() {//zmienia sie
        factory.setLabelType(GuiFactory.LabelType.NORMAL);
        for (int i = 0; i < maximumElementNumber ; i++) {
            var label  = factory.createLabel(Card.EMPTY_DATA_CONTENT);
            menager.addMiddleComponent(label, 0, 10);
            menager.getMainComponent(0).getComponent().getLastComponent().addSpace(2, ComponentPanelMenager.Side.LEFT
                    , ComponentPanelMenager.Side.BOTTOM, ComponentPanelMenager.Side.TOP);
            labelList.add(label);

//            initSecondContentComponent();
            menager.addMiddleComponent(createSecondContentComponent(), 1, 10);
            menager.getMainComponent(1).getComponent().getLastComponent().addSpace(2,
                    ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.BOTTOM,
                    ComponentPanelMenager.Side.TOP);

        }

//        updateContent();
    }

    @Override
    public void setUniformForm() {
        SharedCmpsFont.setUniformFont(labelList);
    }

//    public void makeFullContentTransparent() {
//        HashMap<Object, Color> previous = new HashMap<>();
//        for (var cmp : menager.getComponentsList()){
//            previous.put(cmp, cmp.getForeground());
//            cmp.setForeground(new Color(0,0,0,0));
//        }
//        new java.util.Timer().schedule(
//            new java.util.TimerTask() {
//                @Override
//                public void run() {
//                    for (var cmp : menager.getComponentsList()){
//                        cmp.setForeground(previous.get(cmp));
//                    }
//                }
//            },
//            1000
//    );
//    }
}
