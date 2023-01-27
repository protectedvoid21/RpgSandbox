package gui.views.objectViews.itemsViews;
import gui.card.fullCards.specificCards.onlyVisibleCards.OnlyVisibleCard;
import gui.factories.IOverallFactory;
public class ShowSmallView extends SmallCardsView {
    public ShowSmallView(IOverallFactory factory) {
        super(factory);
    }

    protected OnlyVisibleCard createOnlyVisibleCard(int index){
        var card = factory.createSmallOnlyShowCard();
        card.getShowbutton().addActionListener(generateActionListener(ButtonType.SHOW, index));
        cards.add(card);
        return card;
    }
}