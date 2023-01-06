package gui.card.fullCards.specificCards;

import gui.card.contentCards.attributesCards.AttributesCard;
import gui.card.contentCards.attributesCards.LabelAttributeCard;
import gui.card.contentCards.detailCards.DetailButtonsCard;
import gui.card.contentCards.detailCards.DetailSelectButtonCard;
import gui.card.contentCards.detailCards.NormalDetailButtonsCard;
import gui.card.fullCards.abstractCards.Card;
import gui.factories.GuiFactory;

import java.util.ArrayList;

public class GameCard extends Card {
    private ArrayList<DetailSelectButtonCard> gameCards = new ArrayList<>();

    public GameCard(GuiFactory factory) {
        super(factory);
    }

    @Override
    protected DetailButtonsCard createDetailButtonCard() {
        return new NormalDetailButtonsCard(factory);
    }

    @Override
    protected void initializeDetailButtonsCardPart(CardTypes type) {
//        super.initializeDetailButtonsCardPart(type);
        var but = new DetailSelectButtonCard(factory);
        but.initializeCard();
        allCards.put(type, but);
        gameCards.add(but);
//        but.getDetailButton(0).addActionListener(e->detailButtonMethod(but));
        for (int i = 0; i<but.getMaximumElementNumber(); i++){
            int finalI = i;
            but.getDetailButton(0).addActionListener(e->detailButtonMethod(but, type, finalI));
        }

    }

    public DetailSelectButtonCard getGameSelectedCard(int index) {
        return gameCards.get(index);
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
