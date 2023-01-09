package gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleItemsCards;

import gui.customComponents.AbstractCustomButton;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;

import javax.swing.*;

public class OnlyVisibleItemsShowCard extends OnlyVisibleItemCard {
    private AbstractCustomButton showbutton;

    public OnlyVisibleItemsShowCard(GuiFactory factory) {
        super(factory);
    }

    @Override
    protected void initializeDownPanel() {
        showbutton = factory.createButton("SHOW", null);
        seriesPanel.addMiddleComponent(showbutton, 2, 10);
        seriesPanel.getMiddleComponent(2, 0).addSpace(10, ComponentPanelMenager.Side.RIGHT,
                ComponentPanelMenager.Side.LEFT);
        seriesPanel.getMiddleComponent(2, 0).addSpace(3, ComponentPanelMenager.Side.BOTTOM,
                ComponentPanelMenager.Side.TOP);


    }

    @Override
    public boolean containsButton(JButton button) {
        return button==showbutton;
    }

    public AbstractCustomButton getButton() {
        return showbutton;
    }
}
