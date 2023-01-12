package gui.views.objectViews.itemsViews;

import gui.factories.IOverallFactory;
import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleItemsCards.OnlyVisibleItemCard;
import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleItemsCards.OnlyVisibleItemsShowCard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AllItemsShowView extends AllItemsView {
    private ArrayList<OnlyVisibleItemsShowCard> cards = new ArrayList<>();


    public AllItemsShowView(IOverallFactory factory) {
        super(factory);
//        initialize();
    }

    @Override
    protected OnlyVisibleItemCard createOnlyVisibleCard(int index) {
        var card = factory.createSmallShowItemCard();
        card.getButton().addActionListener(new ActionListener() {
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
    protected ArrayList<? extends OnlyVisibleItemCard> getCards() {
        return cards;
    }
}