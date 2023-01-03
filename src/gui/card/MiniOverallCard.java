package gui.card;

import gui.customComponents.AbstractCustomButton;
import gui.customComponents.AbstractCustomLabel;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;

public class MiniOverallCard extends AbstractCard<JComponent> {
    private DefaultCustomMenuMenager<JComponent> menager =
            new DefaultCustomMenuMenager<>(ComponentsSeries.ComponentsDimension.VERTICAL,
                    ComponentsSeries.ComponentsDimension.HORIZONTAL);

    protected ArrayList<AbstractCustomLabel> labelList = new ArrayList<>();


    public MiniOverallCard(GuiFactory factory) {
        super(factory);
        initializeCard(5);
    }


    @Override
    public DefaultCustomMenuMenager<JComponent> getContentMenager() {
        return menager;
    }

    @Override
    protected void updateContent() {
        int maxSideIndex = getSideMaximumElementsNumber();
        int dataSize = data.content.size();
        var sublist = data.content.subList(currentAttrSide * maximumElementNumber, maxSideIndex > dataSize ? dataSize :
                maxSideIndex);
        int currentIndex = 0;
        for (var key : sublist) {
            for (int i = 0; i < 2; i++) {
                labelList.get(2 * currentIndex + i).setContent(key.get(i));
            }
            currentIndex++;
        }
        if (sublist.size() < maximumElementNumber) {
            for (int i = dataSize % maximumElementNumber; i < maximumElementNumber; i++) {
                for (int j = 0; j < 2; j++) {
                    labelList.get(2 * i + j).setContent(Card.EMPTY_DATA_CONTENT);
                }
            }
        }
        Card.setAspectVisible(labelList, true);
    }

    @Override
    protected void initializeContent() {
        for (int i = 0; i < maximumElementNumber; i++) {
            factory.setLabelType(GuiFactory.LabelType.ICON);
            var label = factory.createLabel(Card.EMPTY_DATA_CONTENT);
            factory.setLabelType(GuiFactory.LabelType.NORMAL);
            var label2 = factory.createLabel(Card.EMPTY_DATA_CONTENT);

            var newPanel =
                    new ComponentsSeries<ComponentPanelMenager<JComponent>>(ComponentsSeries.ComponentsDimension.HORIZONTAL);

            for (var panel : Arrays.asList(label, label2)) {
                newPanel.addOption(new ComponentPanelMenager<>(panel), 2);
            }
            menager.addMiddleComponent(newPanel, i / 2, 20);
            newPanel.getOption(1).addSpace(2, ComponentPanelMenager.Side.LEFT);
            newPanel.getOption(1).addSpace(2, ComponentPanelMenager.Side.BOTTOM, ComponentPanelMenager.Side.TOP);

            menager.getMiddleComponent(i / 2, i % 2).addSpace(1);
            labelList.add(label);
            labelList.add(label2);
        }
//        updateContent();

    }


    @Override
    protected void initializeCard(int maximumElementNumber) {
        final int modulo = maximumElementNumber % 2;
        final int div = maximumElementNumber / 2;

        int rangeValue = modulo == 1 ? div + 1 : div;
        for (int i = 0; i < rangeValue; i++) {
            menager.addMainComponent(10);
        }
        if (modulo == 1) {
            menager.getMainComponent(div).addSpace(5, ComponentPanelMenager.Side.LEFT,
                    ComponentPanelMenager.Side.RIGHT);
        }
        super.initializeCard(maximumElementNumber);
    }

    @Override
    public void setUniformForm() {
        SharedCmpsFont.setUniformFont(labelList);
    }
}