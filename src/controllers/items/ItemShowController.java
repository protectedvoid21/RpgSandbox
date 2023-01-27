package controllers.items;

import controllers.Controller;
import controllers.utils.RedirectListener;
import game.filehandle.EntityManager;
import gui.utils.Converter;
import gui.card.fullCards.abstractCards.Card;
import gui.factories.IOverallFactory;

public class ItemShowController extends Controller {
    private final int index;
    private final Card.CardTypes cardType;
    private final Card.CardTypes creatorTypes;
    
    public ItemShowController(int index, Card.CardTypes cardType, Card.CardTypes creatorTypes) {
        this.index = index;
        this.cardType = cardType;
        this.creatorTypes = creatorTypes;
    }
    
    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createGodCard();
        var contentData = converter.createFullDataCreature(EntityManager.getInstance().getPlayerCharacterWithAllItems());
        view.uploadNewData(contentData, converter.createFullDetailDataCreature((EntityManager.getInstance().getPlayerCharacterWithAllItems())));
        
        view.setItemAction(new RedirectListener(controllerManager, new ItemListController(creatorTypes)));
        view.setItemViewStatus(cardType, index);
        
        mainFrame.add(view.getPanel());
    }
}
