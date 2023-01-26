package gui.card.contentCards;

import gui.customComponents.customTextComponents.CustomTextArea;
import gui.customComponents.customTextComponents.CustomTextComponent;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;

public class TextAreaCard extends AbstractCard {
    protected DefaultCustomMenuMenager<JComponent> menager =
            new DefaultCustomMenuMenager<JComponent>(ComponentsSeries.ComponentsDimension.HORIZONTAL,
                    ComponentsSeries.ComponentsDimension.VERTICAL);
    private CustomTextComponent textArea;

    public TextAreaCard(GuiFactory factory) {
        super(factory);
    }

    @Override
    public DefaultCustomMenuMenager getContentMenager() {
        return menager;
    }

    @Override
    protected void updateContent() {
        textArea.setContent(data.content.get(0).get(0));
    }

    @Override
    protected void initializeContent() {
        textArea = factory.createTextArea();
        menager.addMiddleComponent(textArea, 0, 10);
        menager.getMiddleComponent(0,0).addSpace(4, ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.LEFT);

    }

    @Override
    public void setUniformForm() {

    }

    @Override
    public void initializeCard() {
        menager.addMainComponent(10);
        initializeContent();
        super.initializeCard(maximumElementNumber);
    }

}
