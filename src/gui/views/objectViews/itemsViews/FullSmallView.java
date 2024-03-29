package gui.views.objectViews.itemsViews;

import gui.card.DoubleArrowPanel;
import gui.card.fullCards.specificCards.onlyVisibleCards.OnlyVisibleCard;
import gui.factories.IOverallFactory;
import java.awt.event.ActionListener;

public class FullSmallView extends SmallCardsView {
    public FullSmallView(IOverallFactory factory) {
        super(factory);
    }

    protected OnlyVisibleCard createOnlyVisibleCard(int index){
        var card = factory.createSmallFullCard();
        card.getShowbutton().addActionListener(generateActionListener(ButtonType.SHOW, index));
        card.getEditButton().addActionListener(generateActionListener(ButtonType.EDIT, index));

        card.getDeleteButton().addActionListener(e -> {
            generateActionListener(ButtonType.DELETE, index).actionPerformed(e);
            data.remove(data.get(clickedIndex));
            updateContent();
            if (maximumumElements * currentSide >= data.size()) {
                switchSide(DoubleArrowPanel.Side.LEFT);
                arrowPanel.updateSwitchingButtons();
            }
        });

        cards.add(card);
        return card;
    }
}
