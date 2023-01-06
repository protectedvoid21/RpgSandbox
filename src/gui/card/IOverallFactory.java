package gui.card;

import gui.card.fullCards.abstractCards.Card;
import gui.card.fullCards.specificCards.OnlyVisibleCard;
import gui.factories.GuiFactory;

import java.util.AbstractMap;
import java.util.ArrayList;

public abstract class IOverallFactory {
    protected GuiFactory factory = new GuiFactory();

    public abstract Card createCard(AbstractMap.SimpleEntry<String, String> titleIconPathName,
                                    ArrayList<ArrayList<String>> dataMap);

    public abstract Card createFullCard();

    public abstract OnlyVisibleCard createSmallCard();
}
