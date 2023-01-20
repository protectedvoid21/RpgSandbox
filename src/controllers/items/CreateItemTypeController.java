package controllers.items;

import controllers.Controller;
import controllers.RedirectListener;
import controllers.items.ItemActionController;
import gui.card.fullCards.abstractCards.Card;
import gui.factories.IOverallFactory;

public class CreateItemTypeController extends Controller {
    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createCreatingEditingItemsPanel();
        view.getReturnButton().addActionListener(
                new RedirectListener(controllerManager, new ItemActionController())
        );
        view.getButton(0).addActionListener(
                new RedirectListener(controllerManager, new CreateItemController(Card.CreatorTypes.MOUNT))
        );
        view.getButton(1).addActionListener(
                new RedirectListener(controllerManager, new CreateItemController(Card.CreatorTypes.WEAPONS))
        );
        view.getButton(2).addActionListener(
                new RedirectListener(controllerManager, new CreateItemController(Card.CreatorTypes.ARMOR))
        );
        
        mainFrame.add(view.getPanel());
    }
}
