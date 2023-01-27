package gui.card.fullCards.specificCards.onlyVisibleCards;

import gui.card.SharedCmpsFont;
import gui.card.fullCards.abstractCards.BaseCard;
import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.AbstractCustomButton;
import gui.customComponents.AbstractCustomLabel;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public abstract class OnlyVisibleCard extends BaseCard {
    private AbstractCustomLabel nameLabel;


    public OnlyVisibleCard(GuiFactory factory) {
        super(factory);
    }

    public void uploadTypePathData(String path){
        if (!Objects.equals(path, rightTitleComponent.getComponent().getContent())) {
            rightTitleComponent.getComponent().setContent(path);
        }
    }

    public void uploadNewData(String path, String name) {
        if (path != leftTitleComponent.getComponent().getContent()) {
            leftTitleComponent.getComponent().setContent(path);
        }
        nameLabel.setContent(name);
    }



    protected abstract void initializeDownPanel();

    @Override
    public void setVisibility(boolean value) {
        setAspectVisible(new ArrayList<>(Arrays.asList(leftTitleComponent.getComponent(),
                rightTitleComponent.getComponent())), value);
    }

    @Override
    public void initialize() {
        initializeCard();
    }


    protected void initializeCard() {
        factory.setLabelType(GuiFactory.LabelType.ICON);
        rightTitleComponent.setVisible(false);
        var l =factory.createLabel(rightTitleComponent.getComponent().getContent());
        l.getCustomUI().setOffSet(0);
        rightTitleComponent =
                new ComponentPanelMenager<>(l);
        titleSeries.addMiddleComponent(rightTitleComponent, 1,30);

        titleSeries.getMiddleComponent(1,1).addSpace(4, ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.TOP);
        titleSeries.getMiddleComponent(1,1).addSpace(2, ComponentPanelMenager.Side.BOTTOM);
        factory.setLabelType(GuiFactory.LabelType.NORMAL);
        nameLabel = factory.createLabel(Card.EMPTY_DATA_CONTENT);
        seriesPanel.addMainComponent(4);
        seriesPanel.addMainComponent(4);
        seriesPanel.addMiddleComponent(nameLabel, 1, 10);

        initializeDownPanel();

        seriesPanel.getMiddleComponent(1, 0).addSpace(3, ComponentPanelMenager.Side.RIGHT,
                ComponentPanelMenager.Side.LEFT);
        seriesPanel.getMiddleComponent(1, 0).addSpace(2, ComponentPanelMenager.Side.BOTTOM,
                ComponentPanelMenager.Side.TOP);

    }

    public abstract boolean containsButton(JButton button);
}
