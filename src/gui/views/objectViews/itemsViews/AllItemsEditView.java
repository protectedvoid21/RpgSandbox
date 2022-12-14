package gui.views.objectViews.itemsViews;

import gui.card.IOverallFactory;
import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleItemsCards.OnlyVisibleItemCard;
import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleItemsCards.OnlyVisibleItemsEditCard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class AllItemsEditView extends AllItemsView {
    private ArrayList<OnlyVisibleItemsEditCard> cards = new ArrayList<>();

    public AllItemsEditView(IOverallFactory factory) {
        super(factory);
        initialize();
    }

    @Override
    protected OnlyVisibleItemCard createOnlyVisibleCard(int index) {
        var card = factory.createSmallEditItemCard();
        for (var but : Arrays.asList(card.getEditButton(), card.getDeleteButton())) {
            but.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    clickedIndex = maximumumElements * currentSide + index;
                    if (listenerHashMap.containsKey(clickedIndex) && listenerHashMap.get(clickedIndex).containsKey(but == card.getEditButton() ? ButtonType.EDIT : ButtonType.DELETE)) {
                        listenerHashMap.get(clickedIndex).get(but == card.getEditButton() ? ButtonType.EDIT :
                                ButtonType.DELETE).actionPerformed(e);
                    }
                }
            });
        }
        cards.add(card);
        return card;
    }

    @Override
    protected ArrayList<? extends OnlyVisibleItemCard> getCards() {
        return cards;
    }
}