package gui.views;

import gui.card.fullCards.abstractCards.BaseCard;
import gui.customComponents.AbstractCustomButton;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;
import java.awt.*;

public class CardCancelView {
    private AbstractCustomButton button;
    private DefaultCustomMenuMenager menager =
            new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.VERTICAL,
                    ComponentsSeries.ComponentsDimension.HORIZONTAL);

    public CardCancelView(GuiFactory factory, BaseCard card) {
        factory.setButtonType(GuiFactory.ButtonType.NORMAL);
        menager.setBackground(new Color(0x346572));
        menager.setHasUniqueColor(true);
        button = factory.createButton("CANCEL", null);
        menager.addMainComponent(10);
        menager.addMainComponent(1);
        menager.addMiddleComponent(card.getPanel(), 0, 10);
        menager.getMainComponent(0).addSpace(1);
        menager.addMiddleComponent(button, 1, 10);
        menager.getMainComponent(1).addSpace(5, ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.LEFT);
        menager.getMainComponent(1).addSpace(1, ComponentPanelMenager.Side.BOTTOM);
    }

    public AbstractCustomButton getButton(){
        return button;
    }

    public JPanel getPanel(){
        return menager.getCmp();
    }

}
