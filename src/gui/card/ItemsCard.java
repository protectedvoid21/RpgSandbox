package gui.card;

import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.TimerTask;

public class ItemsCard extends AbstractCard{
    public ItemsCard(AbstractMap.SimpleEntry<String, String> titleIconPathName, ArrayList<AbstractMap.SimpleEntry<String, String>> dataMap, GuiFactory factory) {
        super(titleIconPathName, dataMap, factory);
        maximumElementNumber = 3;
        initializeTitle();
        initializeContent();
    }

    public void initializeTitle() {//zmienia sie
        factory.setLabelType(GuiFactory.LabelType.ICON);
        menager.addMiddleComponent(factory.createLabel(titleIconPathName.getKey()), 0, 30);
        menager.getMiddleComponent(0, 0).addSpace(6, ComponentPanelMenager.Side.LEFT, ComponentPanelMenager.Side.TOP);
        menager.getMiddleComponent(0, 0).addSpace(1, ComponentPanelMenager.Side.RIGHT);
        menager.getMiddleComponent(0, 0).addSpace(2, ComponentPanelMenager.Side.BOTTOM);

        factory.setLabelType(GuiFactory.LabelType.NORMAL);
        menager.addMiddleComponent(factory.createLabel(titleIconPathName.getValue()), 1, 30);
        menager.getMiddleComponent(1, 0).addSpace(6, ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.TOP,
                ComponentPanelMenager.Side.BOTTOM);
        menager.getMiddleComponent(1, 0).addSpace(1, ComponentPanelMenager.Side.LEFT);

    }


    protected void updateTitle() {//zmienia sie
        factory.setLabelType(GuiFactory.LabelType.ICON);
        menager.getMiddleComponent(0, 0).getComponent().setContent(titleIconPathName.getKey());
        factory.setLabelType(GuiFactory.LabelType.NORMAL);
        menager.getMiddleComponent(0, 0).getComponent().setText(titleIconPathName.getValue());
    }

    protected void updateContent() {//zmienia sie
        int maxSideIndex = getSideMaximumElementsNumber();
        int dataSize = dataMap.size();
        System.out.println("hellllll");
        System.out.println(dataSize);

        var sublist = dataMap.subList(currentAttrSide * maximumElementNumber, maxSideIndex > dataSize ? dataSize :
                maxSideIndex);
        while (sublist.size() < maximumElementNumber) {
            sublist.add(new AbstractMap.SimpleEntry<>(Card.EMPTY_DATA_CONTENT, Card.EMPTY_DATA_CONTENT));
        }
        int currentIndex = 1;
        setContentVisible(false);
        for (var key : sublist) {
            System.out.println("sssss");
            menager.getMiddleComponent(0, currentIndex).getComponent().setText(key.getKey());
            menager.getMiddleComponent(1, currentIndex).getComponent().setText(key.getValue());
            currentIndex++;
        }
        new java.util.Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                setContentVisible(true);
            }
        }, 200);

    }

    public void initializeContent() {//zmienia sie
        for (int i = 1; i < maximumElementNumber + 1; i++) {
            menager.addMiddleComponent(factory.createLabel(Card.EMPTY_DATA_CONTENT), 0, 10);
            menager.getMainComponent(0).getComponent().getLastComponent().addSpace(2, ComponentPanelMenager.Side.LEFT
                    , ComponentPanelMenager.Side.BOTTOM, ComponentPanelMenager.Side.TOP);

            menager.addMiddleComponent(factory.createLabel(Card.EMPTY_DATA_CONTENT), 1, 10);
            menager.getMainComponent(1).getComponent().getLastComponent().addSpace(2,
                    ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.BOTTOM,
                    ComponentPanelMenager.Side.TOP);
        }
        updateContent();
//        setCorrectBlockStatus();
    }
}