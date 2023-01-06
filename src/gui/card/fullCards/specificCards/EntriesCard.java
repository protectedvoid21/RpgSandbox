package gui.card.fullCards.specificCards;

import gui.card.contentCards.attributesCards.AttributesCard;
import gui.card.contentCards.attributesCards.EntriesAttributesCard;
import gui.card.contentCards.attributesCards.LabelAttributeCard;
import gui.card.contentCards.detailCards.AddingItemButtonCard;
import gui.card.contentCards.detailCards.DetailButtonsCard;
import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.IContentCustomUICmp;
import gui.customComponents.customTextComponents.CustomTextComponent;
import gui.customComponents.customTextComponents.CustomTextField;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;

import javax.swing.*;

public class EntriesCard extends Card {
    public enum EntryType {SPINNER, ENTRY}

    private CustomTextComponent textComponentTitle;

    public EntriesCard(GuiFactory factory) {
        super(factory);
    }

    @Override
    protected DetailButtonsCard createDetailButtonCard() {
        return new AddingItemButtonCard(factory);
    }

    @Override
    protected AttributesCard createAttributeCard() {
        return new EntriesAttributesCard(factory);
    }

    @Override
    protected AttributesCard createDetailItemCard() {
        return new LabelAttributeCard(factory);
    }


    @Override
    protected void updateTitle() {
        super.updateTitle();

        if (activeCard== allCards.get(CardTypes.OVERALL)){
            rightTitleComponent.setVisible(false);
            rightEntryTitleComponent.setVisible(true);
        }else{
            rightEntryTitleComponent.setVisible(false);
            rightTitleComponent.setVisible(true);
        }
        System.out.println("foreground "+rightEntryTitleComponent.getForeground()+"  "+rightEntryTitleComponent.getBackground());
    }

    @Override
    public void initializeTitle() {
        super.initializeTitle();
        textComponentTitle = factory.createTextField();
    }

//    @Override
//    public ComponentPanelMenager<? extends IContentCustomUICmp> getRightTitleComponent() {
//        return rightEntryTitleComponent;
//    }

}
