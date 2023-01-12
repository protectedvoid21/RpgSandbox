package gui.views.objectViews.creatureViews;

import gui.card.DoubleArrowPanel;
import gui.card.IOverallFactory;
import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleCreatureCards.OnlyVisibleCard;
import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleCreatureCards.OnlyVisibleEditCard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AllCreaturesEditView extends AllCreaturesView {
    private ArrayList<OnlyVisibleEditCard> cards = new ArrayList<>();


    public AllCreaturesEditView(IOverallFactory factory) {
        super(factory);
        initialize();
    }

    @Override
    protected OnlyVisibleCard createOnlyVisibleCard(int index) {
        var card = factory.createSmallEditCard();

        cards.add(card);
        card.getEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedIndex = maximumumElements * currentSide + index;
                if (listenerHashMap.containsKey(clickedIndex) && listenerHashMap.get(clickedIndex).containsKey(ButtonType.EDIT)) {
                    listenerHashMap.get(clickedIndex).get(ButtonType.EDIT).actionPerformed(e);
                }
            }
        });
        card.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedIndex = maximumumElements * currentSide + index;
                if (listenerHashMap.containsKey(clickedIndex) && listenerHashMap.get(clickedIndex).containsKey(ButtonType.DELETE)) {
                    listenerHashMap.get(clickedIndex).get(ButtonType.DELETE).actionPerformed(e);
                }
                data.remove(data.get(clickedIndex));
                updateContent();
                if (maximumumElements * currentSide >= data.size()) {
                    switchSide(DoubleArrowPanel.Side.LEFT);
                    arrowPanel.updateSwitchingButtons();
                }
            }

        });
//        for (var but : Arrays.asList(card.getEditButton(), card.getDeleteButton())) {
//            but.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    clickedIndex = maximumumElements * currentSide + index;
//                    if (listenerHashMap.containsKey(clickedIndex) && listenerHashMap.get(clickedIndex).containsKey
//                    (but == card.getEditButton() ? ButtonType.EDIT : ButtonType.DELETE)) {
//                        listenerHashMap.get(clickedIndex).get(but == card.getEditButton() ? ButtonType.EDIT :
//                                ButtonType.DELETE).actionPerformed(e);
//                    }
//                }
//            });
//        }

        return card;
    }

    @Override
    protected ArrayList<? extends OnlyVisibleCard> getCards() {
        return cards;
    }
}