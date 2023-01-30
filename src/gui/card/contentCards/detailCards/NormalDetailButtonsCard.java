package gui.card.contentCards.detailCards;

import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.abstractComponents.AbstractCustomLabel;
import gui.customComponents.IContentCustomUICmp;
import gui.factories.GuiFactory;

import javax.swing.*;
import java.util.ArrayList;

public class NormalDetailButtonsCard extends DetailButtonsCard {

    private final ArrayList<AbstractCustomLabel> list = new ArrayList<>();
    public NormalDetailButtonsCard(GuiFactory factory) {
        super(factory);
    }

    @Override
    protected ArrayList<? extends IContentCustomUICmp> getContentList() {
        return list;
    }

    @Override
    protected void updateContent() {
        Card.setNonDependantAspectVisible(list);
        super.updateContent();
        Card.setAspectVisible(list, true);
    }

    @Override
    protected JComponent createContentSegment() {

        factory.setLabelType(GuiFactory.LabelType.NORMAL);
        var label = factory.createLabel(Card.EMPTY_DATA_CONTENT);
        list.add(label);
        return label;
    }
}
