package gui.views.objectViews.creatureViews;

import gui.factories.IOverallFactory;
import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleCreatureCards.OnlyVisibleCard;
import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleCreatureCards.OnlyVisibleShowCard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AllCreaturesShowView extends AllCreaturesView {
    private ArrayList<OnlyVisibleShowCard> cards = new ArrayList<>();



    public AllCreaturesShowView(IOverallFactory factory) {
        super(factory);
        initialize();
    }

    @Override
    protected OnlyVisibleCard createOnlyVisibleCard(int index) {
        var card = factory.createSmallShowCard();
        card.getShowButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedIndex = maximumumElements * currentSide + index;
                if (listenerHashMap.containsKey(clickedIndex) && listenerHashMap.get(clickedIndex).containsKey(ButtonType.SHOW)) {
                    listenerHashMap.get(clickedIndex).get(ButtonType.SHOW).actionPerformed(e);
                }
            }
        });
        cards.add(card);
        return card;
    }

    @Override
    protected ArrayList<? extends OnlyVisibleCard> getCards() {
        return cards;
    }
}
