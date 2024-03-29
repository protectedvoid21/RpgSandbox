package gui.card.contentCards.detailCards;

import gui.bundle.CustomBundle;
import gui.card.fullCards.abstractCards.Card;
import gui.card.SharedCmpsFont;
import gui.customComponents.abstractComponents.AbstractCustomLabel;
import gui.data.TextData;
import gui.factories.GuiFactory;

import java.util.*;

public class DetailSelectButtonCard extends NormalDetailButtonsCard {
    protected ArrayList<AbstractCustomLabel> selectList;
    private int selectedIndex = -1;


    public DetailSelectButtonCard(GuiFactory factory) {
        super(factory);
        selectedIndex = 6;
    }

    public AbstractCustomLabel getSelectButton(int index) {
        return selectList.get(index);
    }

    public void setSelectedIndex(int value) {
        selectedIndex = value;
        updateContent();
    }


    @Override
    protected void updateContent() {
        super.updateContent();
        int maxSideIndex = getSideMaximumElementsNumber();
        int dataSize = data.content.size();
        var sublist = data.content.subList(currentAttrSide * maximumElementNumber, Math.min(maxSideIndex, dataSize));
        int currentIndex = 0;
        Card.setNonDependantAspectVisible(selectList);
        for (var key : sublist) {
            selectList.get(currentIndex).setContent((currentAttrSide * maximumElementNumber + currentIndex == selectedIndex)? CustomBundle.getDefaultString(selected) :" ");
            currentIndex++;
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
        factory.setLabelType(GuiFactory.LabelType.NORMAL);
        for (int i = 0; i < maximumElementNumber; i++) {
            initLabel(selectList, " ");
        }

    }

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