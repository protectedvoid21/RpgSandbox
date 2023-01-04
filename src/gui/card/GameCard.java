package gui.card;

import gui.factories.GuiFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameCard extends Card {
    private ArrayList<DetailSelectButtonCard> gameCards = new ArrayList<>();

    public GameCard(GuiFactory factory) {
        super(factory);
    }

    @Override
    protected DetailButtonsCard createDetailButton() {
        return new NormalDetailButtonsCard(factory);
    }

    @Override
    protected void initializeDetailButtonsCardPart(CardTypes type) {
        var but = new DetailSelectButtonCard(factory);
        allCards.put(type, but);
        gameCards.add(but);
        but.getDetailButton(0).addActionListener(e->detailButtonMethod(but));

    }

    public DetailSelectButtonCard getGameSelectedCard(int index) {
        return gameCards.get(index);
    }
}
