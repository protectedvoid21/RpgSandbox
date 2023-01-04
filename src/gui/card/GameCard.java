package gui.card;

import gui.factories.GuiFactory;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameCard extends Card {
    private ArrayList<DetailSelectButtonCard> gameCards = new ArrayList<>();

    public GameCard(GuiFactory factory) {
        super(factory);
    }

    @Override
    protected void initializeDetailButtonsCardPart(CardTypes type) {
        var but = new DetailSelectButtonCard(factory);
        allCards.put(type, but);
        gameCards.add(but);
    }

    public DetailSelectButtonCard getGameSelectedCard(int index) {
        return gameCards.get(index);
    }
}
