package gui.card.fullCards.specificCards;

import gui.card.contentCards.attributesCards.AttributesCard;
import gui.card.contentCards.attributesCards.LabelAttributeCard;
import gui.card.contentCards.detailCards.DetailButtonsCard;
import gui.card.contentCards.detailCards.DetailSelectButtonCard;
import gui.card.contentCards.detailCards.NormalDetailButtonsCard;
import gui.card.fullCards.abstractCards.Card;
import gui.factories.GuiFactory;

import java.util.ArrayList;
import java.util.HashMap;

public class GameCard extends Card {
    private HashMap<CardTypes, DetailSelectButtonCard> gameCards = new HashMap<>();

    public GameCard(GuiFactory factory) {
        super(factory);
    }

    @Override
    protected DetailButtonsCard createDetailButtonCard(CardTypes type) {
        return new NormalDetailButtonsCard(factory);
    }

    @Override
    protected void initializeDetailButtonsCardPart(CardTypes type) {
        var but = type != CardTypes.ITEMS ? new DetailSelectButtonCard(factory) : new NormalDetailButtonsCard(factory);
        but.initializeCard();
        allCards.put(type, but);
        if (type != CardTypes.ITEMS)
            gameCards.put(type, (DetailSelectButtonCard) but);
        for (int i = 0; i < but.getMaximumElementNumber(); i++) {
            int finalI = i;
            but.getDetailButton(i).addActionListener(e -> detailButtonMethod(but, type, finalI));
        }

    }

    public DetailSelectButtonCard getGameSelectedCard(CardTypes type) {
        return gameCards.get(type);
    }

    @Override
    protected AttributesCard createAttributeCard() {
        return new LabelAttributeCard(factory);
    }

    @Override
    protected AttributesCard createDetailItemCard() {
        return createAttributeCard();
    }
}
