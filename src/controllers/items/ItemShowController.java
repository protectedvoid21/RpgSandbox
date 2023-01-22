package controllers.items;

import controllers.Controller;
import controllers.utils.RedirectListener;
import game.equipment.Item;
import gui.card.fullCards.abstractCards.Card;
import gui.factories.IOverallFactory;

public class ItemShowController extends Controller {
    private Item item;
    private Card.CreatorTypes creatorType;
    
    public ItemShowController(Item item, Card.CreatorTypes creatorType) {
        this.item = item;
        this.creatorType = creatorType;
    }
    
    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createGodCard();
        
        view.getCancelButton().addActionListener(
                new RedirectListener(controllerManager, new ItemListController(creatorType))
        );
        //view.uploadNewData();
        
        mainFrame.add(view.getPanel());
    }
}
