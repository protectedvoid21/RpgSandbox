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

public class DetailSelectButtonCard extends DetailButtonsCard {
    protected ArrayList<AbstractCustomButton> selectList;


    public DetailSelectButtonCard(GuiFactory factory) {
        super(factory);
    }

    public AbstractCustomButton getSelectButton(int index) {
        return selectList.get(index);
    }


    @Override
    protected void updateContent() {
        super.updateContent();
        int maxSideIndex = getSideMaximumElementsNumber();
        int dataSize = data.content.size();
        var sublist = data.content.subList(currentAttrSide * maximumElementNumber, maxSideIndex > dataSize ? dataSize :
                maxSideIndex);
        int currentIndex = 0;
        for (var key : sublist) {
            selectList.get(currentIndex).setContent("SELECT");
        }
        if (sublist.size() < maximumElementNumber) {
            for (int i = dataSize % maximumElementNumber; i < maximumElementNumber; i++) {
                selectList.get(i).setContent(Card.EMPTY_DATA_CONTENT);
            }
        }
        Card.setAspectVisible(selectList, true);
    }

    @Override
    protected void initializeContent() {

        super.initializeContent();
        selectList = new ArrayList<>();
        for (int i = 0; i < maximumElementNumber; i++) {
            initButton(selectList, "SELECT");
        }

    }

//    protected void initLabel(GuiFactory.LabelType type) {
//        factory.setLabelType(type);
//        var label = factory.createLabel(Card.EMPTY_DATA_CONTENT);
//        int index = type == GuiFactory.LabelType.NORMAL ? 1 : 0;
//        menager.addMiddleComponent(label, index, 20);
//        menager.getMainComponent(index).getComponent().getLastComponent().addSpace(2);
//        labelList.add(label);
//    }
//
//    protected void initButton(ArrayList list, String text) {
//        var button = factory.createButton(text, null);
//        int index = list == detailList ? 2 : 3;
//        menager.addMiddleComponent(button, index, 20);
//        menager.getMainComponent(index).getComponent().getLastComponent().addSpace(4);
//        list.add(button);
//    }

    @Override
    protected void initializeCard(int maximumElementNumber) {
        super.initializeCard(maximumElementNumber);
        getContentMenager().addMainComponent(10);

    }

    @Override
    public void setUniformForm() {
        super.setUniformForm();
        SharedCmpsFont.setUniformFont(selectList);
    }

}