package gui.card.contentCards.detailCards;

import gui.customComponents.AbstractCustomButton;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;

public class AddingItemButtonCard extends NormalDetailButtonsCard {
    private final DefaultCustomMenuMenager secondCustomMenager = new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.VERTICAL, ComponentsSeries.ComponentsDimension.HORIZONTAL);
    private final AbstractCustomButton button= createCustomButton();
    public AbstractCustomButton getPlusButton() {
        return button;
    }

    public AddingItemButtonCard(GuiFactory factory) {
        super(factory);
    }

    private AbstractCustomButton createCustomButton() {
        factory.setButtonType(GuiFactory.ButtonType.NORMAL);
        var button = factory.createButton("add new Item", null);
        return button;
    }
    @Override
    public DefaultCustomMenuMenager<JComponent> getContentMenager() {
        return secondCustomMenager;
    }

    @Override
    protected void initializeContent() {
        super.initializeContent();
        secondCustomMenager.addMainComponent(8);
        secondCustomMenager.addMainComponent(2);

        var panel = new ComponentPanelMenager<JComponent>(button);
        panel.addSpace(6, ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.LEFT);
        panel.addSpace(1, ComponentPanelMenager.Side.TOP, ComponentPanelMenager.Side.BOTTOM);

        secondCustomMenager.addMiddleComponent(super.getContentMenager().getCmp(), 0,11 );
        secondCustomMenager.addMiddleComponent(panel, 1,11 );
    }
}
