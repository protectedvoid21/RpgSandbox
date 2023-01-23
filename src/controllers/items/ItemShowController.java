package controllers.items;

import controllers.Controller;
import controllers.utils.RedirectListener;
import game.equipment.Item;
import game.filehandle.EntityManager;
import gui.Converter;
import gui.card.fullCards.abstractCards.Card;
import gui.factories.IOverallFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemShowController extends Controller {
    private int index;
    private Card.CardTypes cardType;
    private Card.CardTypes creatorTypes;
    
    public ItemShowController(int index, Card.CardTypes cardType, Card.CardTypes creatorTypes) {
        this.index = index;
        this.cardType = cardType;
        this.creatorTypes = creatorTypes;
    }
    
    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createGodCard();
        var contentData = Converter.createFullDataCreature(EntityManager.getInstance().getPlayerCharacterWithAllItems());
        view.uploadNewData(contentData, Converter.createFullDetailDataCreature((EntityManager.getInstance().getPlayerCharacterWithAllItems())));
        
        view.setItemAction(new RedirectListener(controllerManager, new ItemListController(creatorTypes)));
        view.setItemViewStatus(cardType, index);
        
        mainFrame.add(view.getPanel());
    }
}
