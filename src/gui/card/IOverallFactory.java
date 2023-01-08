package gui.card;

import gui.card.fullCards.abstractCards.Card;
import gui.card.fullCards.specificCards.BasicCard;
import gui.card.fullCards.specificCards.EntriesCard;
import gui.card.fullCards.specificCards.GameCard;
import gui.card.fullCards.specificCards.OnlyVisibleCard;
import gui.factories.GuiFactory;

import java.util.AbstractMap;
import java.util.ArrayList;

public abstract class IOverallFactory {
    protected GuiFactory factory = new GuiFactory();

//    public abstract Card createCard();

//    public abstract Card createFullCard();

    public abstract EntriesCard createEntriesCard();

    public abstract BasicCard createBasicCard();

    public abstract GameCard createGameCard();

    public abstract OnlyVisibleCard createSmallCard();
    public abstract EntriesCard createCreatorCard(Card.CreatorTypes type);
}
