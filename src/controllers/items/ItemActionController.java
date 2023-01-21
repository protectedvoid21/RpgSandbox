package controllers.items;

import controllers.*;
import controllers.utils.ItemType;
import controllers.utils.RedirectListener;
import gui.card.fullCards.abstractCards.Card;
import gui.factories.IOverallFactory;

public class ItemActionController extends Controller {
    private Card.CreatorTypes creatorType;

    public ItemActionController(Card.CreatorTypes creatorType) {
        this.creatorType = creatorType;
    }

    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createOverallItemPanel();
        view.getReturnButton().addActionListener(
                new RedirectListener(controllerManager, new ItemTypeMenuController())
        );
        
        view.getButton(0).addActionListener(
                new RedirectListener(controllerManager, new ItemListController(creatorType))
        );
        view.getButton(1).addActionListener(
                new RedirectListener(controllerManager, new CreateItemController(creatorType))
        );
        
        mainFrame.add(view.getPanel());
    }
}
