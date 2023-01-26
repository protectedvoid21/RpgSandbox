package gui.views.objectViews.itemsViews;


import gui.card.DoubleArrowPanel;
import gui.card.fullCards.specificCards.onlyVisibleCards.OnlyVisibleCard;
import gui.factories.IOverallFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowSmallView extends SmallCardsView {
    public ShowSmallView(IOverallFactory factory) {
        super(factory);
    }

    protected OnlyVisibleCard createOnlyVisibleCard(int index){
        var card = factory.createSmallOnlyShowCard();
        card.getShowbutton().addActionListener(e -> {
            clickedIndex = maximumumElements * currentSide + index;
            System.out.println();
            if (listenerHashMap.containsKey(clickedIndex) && listenerHashMap.get(clickedIndex).containsKey(ButtonType.SHOW)) {
                listenerHashMap.get(clickedIndex).get(ButtonType.SHOW).actionPerformed(e);
            }
        });
        cards.add(card);
        return card;
    }
}