package gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleCreatureCards;

import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleCreatureCards.OnlyVisibleCard;
import gui.customComponents.AbstractCustomButton;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;

import javax.swing.*;

public class OnlyVisibleEditCard extends OnlyVisibleCard {
    private AbstractCustomButton deleteButton;
    private AbstractCustomButton editButton;

    public OnlyVisibleEditCard(GuiFactory factory, int elementsSize) {
        super(factory, elementsSize);
    }

    public AbstractCustomButton getDeleteButton() {
        return deleteButton;
    }

    public AbstractCustomButton getEditButton() {
        return editButton;
    }

    @Override
    protected void initializeDownPanel() {
        factory.setButtonType(GuiFactory.ButtonType.NORMAL);
        deleteButton = factory.createButton("DELETE", null);
        deleteButton.addActionListener(e->System.out.println("hejka"));
        deleteButton.addActionListener(e->System.out.println("naklejka"));
        initSeriesPanel(deleteButton, 2, 2);
        seriesPanel.getMiddleComponent(2, 0).addSpace(3, ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.LEFT);
        seriesPanel.getMiddleComponent(2, 0).addSpace(3, ComponentPanelMenager.Side.BOTTOM, ComponentPanelMenager.Side.TOP);

        editButton = factory.createButton("EDIT", null);
        initSeriesPanel(editButton, 2, 2);
        seriesPanel.getMiddleComponent(2, 1).addSpace(3, ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.LEFT);
        seriesPanel.getMiddleComponent(2, 1).addSpace(3, ComponentPanelMenager.Side.BOTTOM, ComponentPanelMenager.Side.TOP);
    }

    @Override
    public boolean containsButton(JButton button) {
        return button==deleteButton || button==editButton;
    }
}
