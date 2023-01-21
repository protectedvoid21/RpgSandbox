package gui.views.objectViews.itemsViews;

import gui.card.DoubleArrowPanel;
import gui.card.fullCards.specificCards.onlyVisibleCards.FullOnlyVisibleCard;
import gui.factories.IOverallFactory;
import gui.card.fullCards.specificCards.onlyVisibleCards.OnlyVisibleCard;
import gui.views.objectViews.AllObjectsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class FullSmallView extends SmallCardsView {
    public FullSmallView(IOverallFactory factory) {
        super(factory);
    }

    protected OnlyVisibleCard createOnlyVisibleCard(int index){
        var card = factory.createSmallFullCard();
        card.getShowbutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedIndex = maximumumElements * currentSide + index;
                if (listenerHashMap.containsKey(clickedIndex) && listenerHashMap.get(clickedIndex).containsKey(ButtonType.SHOW)) {
                    listenerHashMap.get(clickedIndex).get(ButtonType.SHOW).actionPerformed(e);
                }
            }
        });
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
        cards.add(card);
        return card;
    }
}
