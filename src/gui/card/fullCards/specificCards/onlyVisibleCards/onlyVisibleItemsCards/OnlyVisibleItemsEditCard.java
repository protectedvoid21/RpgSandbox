package gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleItemsCards;

import gui.card.SharedCmpsFont;
import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.AbstractCustomButton;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class OnlyVisibleItemsEditCard extends OnlyVisibleItemCard {
    private AbstractCustomButton editButton;
    private AbstractCustomButton deleteButton;


    public OnlyVisibleItemsEditCard(GuiFactory factory) {
        super(factory);
    }

    @Override
    protected void initializeDownPanel() {
        editButton = factory.createButton("EDIT", null);
        deleteButton = factory.createButton("DELETE", null);
        for (var but : Arrays.asList(editButton, deleteButton)){
            seriesPanel.addMiddleComponent(but, 2, 10);
            seriesPanel.getMiddleComponent(2, but==editButton?0:1).addSpace(5, ComponentPanelMenager.Side.RIGHT,
                    ComponentPanelMenager.Side.LEFT);
            seriesPanel.getMiddleComponent(2, but==editButton?0:1).addSpace(3, ComponentPanelMenager.Side.BOTTOM,
                    ComponentPanelMenager.Side.TOP);
        }

    }

    @Override
    public boolean containsButton(JButton button) {
        return button==deleteButton || button==editButton;
    }

    @Override
    public void setUniformFont() {
        super.setUniformFont();
        SharedCmpsFont.setUniformFont(new ArrayList<>(Arrays.asList(editButton, deleteButton)));
    }

    public AbstractCustomButton getEditButton() {
        return editButton;
    }
    public AbstractCustomButton getDeleteButton() {
        return deleteButton;
    }
}
