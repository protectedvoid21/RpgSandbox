package gui.card.contentCards.detailCards;

import gui.card.contentCards.AbstractCard;
import gui.card.fullCards.abstractCards.Card;
import gui.card.SharedCmpsFont;
import gui.customComponents.AbstractCustomButton;
import gui.customComponents.AbstractCustomLabel;
import gui.customComponents.IContentCustomUICmp;
import gui.factories.GuiFactory;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;
import java.util.*;

public abstract class DetailButtonsCard extends AbstractCard<JComponent> {
    protected DefaultCustomMenuMenager<JComponent> menager =
            new DefaultCustomMenuMenager<>(ComponentsSeries.ComponentsDimension.HORIZONTAL,
                    ComponentsSeries.ComponentsDimension.VERTICAL);

    protected ArrayList<AbstractCustomLabel> labelList = new ArrayList<>();
    protected ArrayList<AbstractCustomButton> detailList = new ArrayList<>();

    public DetailButtonsCard(GuiFactory factory) {
        super(factory);
    }

    protected abstract ArrayList<? extends IContentCustomUICmp> getContentList();

    @Override
    public void initializeCard() {
        initializeCard(3);
        initializeContent();
    }
    public AbstractCustomButton getDetailButton(int index) {
        return detailList.get(index);
    }

    @Override
    public DefaultCustomMenuMenager<JComponent> getContentMenager() {
        return menager;
    }

    @Override
    protected void updateContent() {
        int maxSideIndex = getSideMaximumElementsNumber();
        int dataSize = data.content.size();
        var sublist = data.content.subList(currentAttrSide * maximumElementNumber, Math.min(maxSideIndex, dataSize));
        int currentIndex = 0;
        Card.setNonDependantAspectVisible(labelList);
        Card.setNonDependantAspectVisible(detailList);
        for (var key : sublist) {
            labelList.get(currentIndex).setContent(key.get(0));
            getContentList().get(currentIndex).setContent(key.get(1));
            detailList.get(currentIndex).setContent(detailText);
            currentIndex++;
        }
        if (sublist.size() < maximumElementNumber) {
            for (int i = dataSize % maximumElementNumber; i < maximumElementNumber; i++) {
                labelList.get(i).setContent(Card.EMPTY_DATA_CONTENT);
                getContentList().get(i).setContent(Card.EMPTY_DATA_CONTENT);

                detailList.get(i).setContent(Card.EMPTY_DATA_CONTENT);
            }
        }
        Card.setAspectVisible(labelList, true);
        Card.setAspectVisible(detailList, true);

    }

    @Override
    protected void initializeContent() {
        factory.setButtonType(GuiFactory.ButtonType.NORMAL);
        for (int i = 0; i < maximumElementNumber; i++) {
            factory.setLabelType(GuiFactory.LabelType.ICON);
            initLabel(labelList, Card.EMPTY_DATA_CONTENT);
            initContentSegment();
            initButton(detailList, detailText);
        }
    }

    protected abstract JComponent createContentSegment();

    private void initContentSegment(){
        menager.addMiddleComponent(createContentSegment(), 1, 20);
        menager.getMainComponent(1).getComponent().getLastComponent().addSpace(2);
    }

    protected void initLabel(ArrayList list, String text) {
        var label = factory.createLabel(text);
        int index = list == labelList ? 0 : 3;
        menager.addMiddleComponent(label, index, 20);
        menager.getMainComponent(index).getComponent().getLastComponent().addSpace(2);
        list.add(label);
    }

    protected void initButton(ArrayList list, String text) {
        var button = factory.createButton(text, null);
        int index = list == detailList ? 2 : 3;
        menager.addMiddleComponent(button, index, 20);
        menager.getMainComponent(index).getComponent().getLastComponent().addSpace(4);
        list.add(button);
    }

    @Override
    protected void initializeCard(int maximumElementNumber) {
        menager.addMainComponent(15);
        menager.addMainComponent(15);
        menager.addMainComponent(10);
        super.initializeCard(maximumElementNumber);
    }

    @Override
    public void setUniformForm() {
        SharedCmpsFont.setUniformFont(detailList);
        SharedCmpsFont.setUniformFont(getContentList());
    }

}
