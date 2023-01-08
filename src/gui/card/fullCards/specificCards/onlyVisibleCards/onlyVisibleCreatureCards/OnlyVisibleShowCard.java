package gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleCreatureCards;

import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleCreatureCards.OnlyVisibleCard;
import gui.customComponents.AbstractCustomButton;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;

import javax.swing.*;

public class OnlyVisibleShowCard extends OnlyVisibleCard {
    private AbstractCustomButton showButton;

    public OnlyVisibleShowCard(GuiFactory factory, int elementsSize) {
        super(factory, elementsSize);
    }

    public AbstractCustomButton getShowButton() {
        return showButton;
    }

    @Override
    protected void initializeDownPanel() {
        factory.setButtonType(GuiFactory.ButtonType.NORMAL);
        showButton = factory.createButton("DELETE", null);
        initSeriesPanel(showButton, 2, 2);
        seriesPanel.getMiddleComponent(2, 0).addSpace(3, ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.LEFT);
        seriesPanel.getMiddleComponent(2, 0).addSpace(3, ComponentPanelMenager.Side.BOTTOM, ComponentPanelMenager.Side.TOP);
    }

    @Override
    public boolean containsButton(JButton button) {
        return button==showButton ;
    }
}
