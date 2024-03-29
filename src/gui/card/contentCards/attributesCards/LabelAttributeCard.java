package gui.card.contentCards.attributesCards;

import gui.card.fullCards.abstractCards.Card;
import gui.card.SharedCmpsFont;
import gui.customComponents.abstractComponents.AbstractCustomLabel;
import gui.customComponents.IContentCustomUICmp;
import gui.factories.GuiFactory;

import javax.swing.*;
import java.util.ArrayList;

public class LabelAttributeCard extends AttributesCard {

    private final ArrayList<AbstractCustomLabel> secondLabelList = new ArrayList<>();
    public LabelAttributeCard(GuiFactory factory) {
        super(factory);
    }
    @Override
    protected JComponent createSecondContentComponent() {
        factory.setLabelType(GuiFactory.LabelType.NORMAL);
        var x = factory.createLabel(Card.EMPTY_DATA_CONTENT);
        secondLabelList.add(x);
        return x;
    }


    @Override
    protected ArrayList<? extends IContentCustomUICmp> getSecondContentList() {
        return secondLabelList;
    }

    @Override
    public void setUniformForm() {
        super.setUniformForm();
        SharedCmpsFont.setUniformFont(secondLabelList);
    }

    @Override
    protected void updateContent() {
        super.updateContent();
        Card.setAspectVisible(secondLabelList, true);
    }
}
