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
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DetailButtonsCard extends AbstractCard<JComponent> {
    private DefaultCustomMenuMenager<JComponent> menager =
            new DefaultCustomMenuMenager<>(ComponentsSeries.ComponentsDimension.HORIZONTAL,
                    ComponentsSeries.ComponentsDimension.VERTICAL);

    protected ArrayList<AbstractCustomLabel> labelList = new ArrayList<>();
    protected ArrayList<AbstractCustomButton> selectList = new ArrayList<>();
    protected ArrayList<AbstractCustomButton> detailList = new ArrayList<>();


    /**
     * dataMap should be in format [path1, path2, path3...]
     */
    public DetailButtonsCard(AbstractMap.SimpleEntry titleIconPathName, ArrayList<ArrayList<String>> dataMap,
                             GuiFactory factory) {
        super(titleIconPathName, dataMap, factory);
        initializeCard(3);
    }


    @Override
    public DefaultCustomMenuMenager<JComponent> getContentMenager() {
        return menager;
    }

    @Override
    protected void updateContent() {
        int maxSideIndex = getSideMaximumElementsNumber();
        int dataSize = dataMap.size();
        var sublist = dataMap.subList(currentAttrSide * maximumElementNumber, maxSideIndex > dataSize ? dataSize :
                maxSideIndex);//cos sie piperzy
//        System.out.println(dataMap.size()+"mapasize");
//        var needsToAdded = maximumElementNumber-sublist.size();
//        while (sublist.size() < maximumElementNumber) {
//            System.out.println("hejka jestem tutaj");
//            sublist.add(new ArrayList<>(Arrays.asList(Card.EMPTY_DATA_CONTENT, Card.EMPTY_DATA_CONTENT)));
//        }
        int currentIndex = 0;
//        System.out.println(dataMap.size()+"mapasize");
        for (var key : sublist) {
            labelList.get(currentIndex).setText(key.get(0));
            currentIndex++;
        }
        System.out.println(sublist);
        if (sublist.size() < maximumElementNumber) {
            for (int i = dataSize % maximumElementNumber; i < maximumElementNumber; i++) {
                labelList.get(i).setText(Card.EMPTY_DATA_CONTENT);
            }
        }
        Card.setAspectVisible(labelList, true);
//        System.out.println(dataMap.size()+"mapasize");
    }

    @Override
    protected void initializeContent() {
        factory.setButtonType(GuiFactory.ButtonType.NORMAL);
        for (int i = 0; i < maximumElementNumber; i++) {
            var label = factory.createLabel(Card.EMPTY_DATA_CONTENT);
            labelList.add(label);
            menager.addMiddleComponent(label, 0, 10);
            var cmp = menager.getMainComponent(0).getComponent().getLastComponent();
            cmp.addSpace(2, ComponentPanelMenager.Side.LEFT, ComponentPanelMenager.Side.BOTTOM,
                    ComponentPanelMenager.Side.TOP);
            cmp.addSpace(3, ComponentPanelMenager.Side.RIGHT);
            initButton(detailList, "DETAIL");
            initButton(selectList, "SELECT");
        }
        updateContent();

    }

    private void initButton(ArrayList list, String text) {
        var button = factory.createButton(text, null);
        int index = list == detailList ? 1 : 2;
        menager.addMiddleComponent(button, index, 10);
        menager.getMainComponent(index).getComponent().getLastComponent().addSpace(2);
        list.add(button);
    }

    @Override
    protected void initializeCard(int maximumElementNumber) {
        menager.addMainComponent(20);
        menager.addMainComponent(10);
        menager.addMainComponent(10);

        super.initializeCard(maximumElementNumber);
    }

    @Override
    public void setUniformForm() {
        SharedCmpsFont.setUniformFont(detailList, selectList);
        SharedCmpsFont.setUniformFont(labelList);
    }
}
