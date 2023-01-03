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
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimerTask;
import java.util.function.Consumer;
import java.util.function.Function;

public final class AttributesCard extends AbstractCard<AbstractCustomLabel> {
    protected DefaultCustomMenuMenager<AbstractCustomLabel> menager =
            new DefaultCustomMenuMenager<AbstractCustomLabel>(ComponentsSeries.ComponentsDimension.HORIZONTAL,
                    ComponentsSeries.ComponentsDimension.VERTICAL);

    public AttributesCard( GuiFactory factory) {
        super(factory);
        initializeCard(5);
    }


    @Override
    public DefaultCustomMenuMenager<AbstractCustomLabel> getContentMenager() {
        return menager;
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

        for (var key : sublist) {
            menager.getMiddleComponent(0, currentIndex).getComponent().setText(key.get(0));
            menager.getMiddleComponent(1, currentIndex).getComponent().setText(key.get(1));
            currentIndex++;
        }

        if (sublist.size() < maximumElementNumber) {
            for (int i = dataSize % maximumElementNumber; i < maximumElementNumber; i++) {
                menager.getMiddleComponent(0, i).getComponent().setText(Card.EMPTY_DATA_CONTENT);
                menager.getMiddleComponent(1, i).getComponent().setText(Card.EMPTY_DATA_CONTENT);
            }
        }

        Card.setAspectVisible(menager.getComponentsList(), true);

    }

    public void initializeContent() {//zmienia sie
        for (int i = 0; i < maximumElementNumber ; i++) {
            menager.addMiddleComponent(factory.createLabel(Card.EMPTY_DATA_CONTENT), 0, 10);
            menager.getMainComponent(0).getComponent().getLastComponent().addSpace(2, ComponentPanelMenager.Side.LEFT
                    , ComponentPanelMenager.Side.BOTTOM, ComponentPanelMenager.Side.TOP);

            menager.addMiddleComponent(factory.createLabel(Card.EMPTY_DATA_CONTENT), 1, 10);
            menager.getMainComponent(1).getComponent().getLastComponent().addSpace(2,
                    ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.BOTTOM,
                    ComponentPanelMenager.Side.TOP);
        }

//        updateContent();
    }

    @Override
    public void setUniformForm() {
        SharedCmpsFont.setUniformFont(menager.getComponentsList());
    }
}
