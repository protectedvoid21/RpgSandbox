package controllers.items;

import controllers.Controller;
import controllers.MenuController;
import controllers.utils.ItemType;
import controllers.utils.RedirectListener;
import gui.card.fullCards.abstractCards.Card;
import gui.factories.IOverallFactory;

public class ItemTypeMenuController extends Controller {
    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createViewingItemsPanel();
        view.getReturnButton().addActionListener(
                new RedirectListener(controllerManager, new MenuController())
        );

        view.getButton(0).addActionListener(
                new RedirectListener(controllerManager, new ItemActionController(Card.CardTypes.MOUNT)));
        view.getButton(1).addActionListener(
                new RedirectListener(controllerManager, new ItemActionController(Card.CardTypes.ARMOR)));
        view.getButton(2).addActionListener(
                new RedirectListener(controllerManager, new ItemActionController(Card.CardTypes.WEAPONS)));
        /*view.getButton(3).addActionListener(
                new RedirectListener(controllerManager, new ItemActionController());*/

        mainFrame.add(view.getPanel());
    }
}
