package gui.card.contentCards;

import gui.card.SharedCmpsFont;
import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.AbstractCustomButton;
import gui.customComponents.AbstractCustomLabel;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.*;

public class OverallCard extends AbstractCard<JComponent> {
    private DefaultCustomMenuMenager<JComponent> menager =
            new DefaultCustomMenuMenager<>(ComponentsSeries.ComponentsDimension.VERTICAL,
                    ComponentsSeries.ComponentsDimension.HORIZONTAL);
    protected ArrayList<AbstractCustomLabel> labelList = new ArrayList<>();
    protected ArrayList<AbstractCustomButton> goList = new ArrayList<>();
    //    private Card parent;
    private LinkedHashMap<Card.CardTypes, ActionListener> cardActions = new LinkedHashMap<>();

    /**
     * dataMap should be in format [[path1, text1], [path2, text2], [path3, text3]...]
     */
    public OverallCard(
            GuiFactory factory, LinkedHashMap<Card.CardTypes, ActionListener> cardListeners) {
        super(factory);
        cardActions = cardListeners;
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
            labelList.get( currentIndex).setContent(key.get(0));
            goList.get(currentIndex).setContent("GO");
            currentIndex++;
        }
        if (sublist.size() < maximumElementNumber) {
            for (int i = dataSize % maximumElementNumber; i < maximumElementNumber; i++) {
                labelList.get(i).setContent(Card.EMPTY_DATA_CONTENT);
                goList.get(i).setContent(Card.EMPTY_DATA_CONTENT);
            }
        }


        for (var list : Arrays.asList(labelList, goList)) {
            Card.setAspectVisible(new ArrayList<>(list), true);
        }
    }

    @Override
    protected void initializeContent() {
        int i = 0;
        for (var key : cardActions.keySet()) {
            factory.setLabelType(GuiFactory.LabelType.ICON);
            var label = factory.createLabel(Card.EMPTY_DATA_CONTENT);
            factory.setButtonType(GuiFactory.ButtonType.NORMAL);
            var button = factory.createButton(Card.EMPTY_DATA_CONTENT, null);
            button.addActionListener(cardActions.get(key));//dodac pewnie zmiane listenera

            var newPanel =
                    new ComponentsSeries<ComponentPanelMenager<JComponent>>(ComponentsSeries.ComponentsDimension.HORIZONTAL);

            for (var panel : Arrays.asList(label, button)) {
                newPanel.addOption(new ComponentPanelMenager<>(panel), 2);
            }
            menager.addMiddleComponent(newPanel, i / 2, 20);
            newPanel.getOption(1).addSpace(1, ComponentPanelMenager.Side.LEFT, ComponentPanelMenager.Side.RIGHT);
            newPanel.getOption(1).addSpace(2, ComponentPanelMenager.Side.BOTTOM, ComponentPanelMenager.Side.TOP);

            menager.getMiddleComponent(i / 2, i % 2).addSpace(1);
            labelList.add(label);
            goList.add(button);
            i++;
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
        SharedCmpsFont.setUniformFont(goList);
        SharedCmpsFont.setUniformFont(labelList);
    }

    @Override
    public void initializeCard() {
        initializeCard(cardActions.size());
        initializeContent();
    }

}