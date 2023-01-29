package gui.card.fullCards.specificCards.onlyVisibleCards;

import gui.bundle.CustomBundle;
import gui.card.SharedCmpsFont;
import gui.customComponents.abstractComponents.AbstractCustomButton;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class OnlyVisibleShowCard extends OnlyVisibleCard {
    private AbstractCustomButton showbutton;

    public OnlyVisibleShowCard(GuiFactory factory) {
        super(factory);
    }
        protected void initializeDownPanel() {
            showbutton = factory.createButton(CustomBundle.getDefaultString(showText), null);
            seriesPanel.addMiddleComponent(showbutton, 2, 10);
            seriesPanel.getMiddleComponent(2, 0).addSpace(4, ComponentPanelMenager.Side.TOP,
                    ComponentPanelMenager.Side.BOTTOM);
            seriesPanel.getMiddleComponent(2, 0).addSpace(6, ComponentPanelMenager.Side.RIGHT,
                ComponentPanelMenager.Side.LEFT);
    }

    public boolean containsButton(JButton button) {
        return button == showbutton;
    }

    public AbstractCustomButton getShowbutton() {
        return showbutton;
    }

    @Override
    public void setUniformFont() {
        SharedCmpsFont.setUniformFont(new ArrayList<>(Arrays.asList(showbutton)));
    }
}
