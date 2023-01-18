package gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleItemsCards;

import gui.card.CardContentDataSet;
import gui.card.SharedCmpsFont;
import gui.card.fullCards.abstractCards.BaseCard;
import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.AbstractCustomButton;
import gui.customComponents.AbstractCustomLabel;
import gui.customUI.customUIStyles.borderStrategies.AverageBorderStartegy;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class OnlyVisibleItemCard extends BaseCard {
//    private AbstractCustomButton showbutton;
    private AbstractCustomLabel nameLabel;
    private AbstractCustomButton editButton;
    private AbstractCustomButton deleteButton;
    private AbstractCustomButton showbutton;


    public OnlyVisibleItemCard(GuiFactory factory) {
        super(factory);
    }

    public void uploadNewData(String path, String name, String path2) {
        if (path != leftTitleComponent.getComponent().getContent()) {
            leftTitleComponent.getComponent().setContent(path);
        }
        if (path != rightTitleComponent.getComponent().getContent()) {
            rightTitleComponent.getComponent().setContent(path);
        }
        nameLabel.setContent(name);
//        seriesPanel.getCmp().setBorderData(Color.RED, new AverageBorderStartegy(), 16);
    }


    @Override
    public void setUniformFont() {
        SharedCmpsFont.setUniformFont(new ArrayList<>(Arrays.asList(editButton, deleteButton, showbutton)));
    }

    protected void initializeDownPanel(){
        showbutton = factory.createButton("SHOW", null);
        editButton = factory.createButton("EDIT", null);
        deleteButton = factory.createButton("DELETE", null);
        var list = Arrays.asList(editButton, deleteButton, showbutton);
        for (var but : list){
            int i = 0;
            seriesPanel.addMiddleComponent(but, 2, 10);
            seriesPanel.getMiddleComponent(2, list.indexOf(but)).addSpace(4);
        }
    }

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
        rightTitleComponent =
                new ComponentPanelMenager<>((factory.createLabel(rightTitleComponent.getComponent().getContent())));
        titleSeries.addMiddleComponent(rightTitleComponent, 1,30);

        titleSeries.getMiddleComponent(1,1).addSpace(6, ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.TOP);
        titleSeries.getMiddleComponent(1,1).addSpace(1, ComponentPanelMenager.Side.LEFT);
        titleSeries.getMiddleComponent(1,1).addSpace(2, ComponentPanelMenager.Side.BOTTOM);
        factory.setLabelType(GuiFactory.LabelType.NORMAL);
        nameLabel = factory.createLabel(Card.EMPTY_DATA_CONTENT);

//        showbutton = factory.createButton("SHOW", null);
        seriesPanel.addMainComponent(4);
        seriesPanel.addMainComponent(4);
        seriesPanel.addMiddleComponent(nameLabel, 1, 10);

        initializeDownPanel();

        seriesPanel.getMiddleComponent(1, 0).addSpace(3, ComponentPanelMenager.Side.RIGHT,
                ComponentPanelMenager.Side.LEFT);
        seriesPanel.getMiddleComponent(1, 0).addSpace(2, ComponentPanelMenager.Side.BOTTOM,
                ComponentPanelMenager.Side.TOP);

    }

    public boolean containsButton(JButton button){
        return button==deleteButton || button==editButton || button==showbutton;
    }
    public AbstractCustomButton getEditButton() {
        return editButton;
    }
    public AbstractCustomButton getDeleteButton() {
        return deleteButton;
    }

    public AbstractCustomButton getShowbutton(){
        return showbutton;
    }
}
