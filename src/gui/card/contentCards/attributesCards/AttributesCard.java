package gui.card.contentCards.attributesCards;

import gui.card.CardContentDataSet;
import gui.card.contentCards.AbstractCard;
import gui.card.fullCards.abstractCards.Card;
import gui.card.SharedCmpsFont;
import gui.customComponents.AbstractCustomLabel;
import gui.customComponents.IContentCustomUICmp;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;
import java.util.*;

public abstract class AttributesCard extends AbstractCard {

    protected DefaultCustomMenuMenager<JComponent> menager =
            new DefaultCustomMenuMenager<JComponent>(ComponentsSeries.ComponentsDimension.HORIZONTAL,
                    ComponentsSeries.ComponentsDimension.VERTICAL);

    protected ArrayList<AbstractCustomLabel> labelList = new ArrayList<>();

    public AttributesCard(GuiFactory factory) {
        super(factory);
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
        var sublist = data.content.subList(currentAttrSide * maximumElementNumber, Math.min(maxSideIndex, dataSize));

        int currentIndex = 0;
        Card.setNonDependantAspectVisible(labelList);
        for (var key : sublist) {
            labelList.get(currentIndex).setContent(key.get(0));
            getSecondContentList().get(currentIndex).setContent(key.get(1));
            currentIndex++;
        }
        if (sublist.size() < maximumElementNumber) {
            for (int i = dataSize % maximumElementNumber; i < maximumElementNumber; i++) {
                labelList.get(i).setContent(Card.EMPTY_DATA_CONTENT);
                getSecondContentList().get(i).setContent(Card.EMPTY_DATA_CONTENT);
            }
        }
        Card.setAspectVisible(labelList, true);
    }


    protected abstract JComponent createSecondContentComponent();

    protected abstract ArrayList<? extends IContentCustomUICmp> getSecondContentList();

    @Override
    protected void initializeContent() {
        factory.setLabelType(GuiFactory.LabelType.NORMAL);
        for (int i = 0; i < maximumElementNumber; i++) {
            var label = factory.createLabel(Card.EMPTY_DATA_CONTENT);
            menager.addMiddleComponent(label, 0, 10);
            menager.getMainComponent(0).getComponent().getLastComponent().addSpace(2, ComponentPanelMenager.Side.LEFT
                    , ComponentPanelMenager.Side.BOTTOM, ComponentPanelMenager.Side.TOP);
            labelList.add(label);

            var x = createSecondContentComponent();
            menager.addMiddleComponent(x, 1, 10);
            menager.getMainComponent(1).getComponent().getLastComponent().addSpace(2,
                    ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.BOTTOM,
                    ComponentPanelMenager.Side.TOP);
        }
    }

    @Override
    public void setUniformForm() {
        SharedCmpsFont.setUniformFont(labelList);
    }

}
