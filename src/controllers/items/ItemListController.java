package controllers.items;

import controllers.Controller;
import controllers.utils.ItemType;
import controllers.utils.RedirectListener;
import gui.card.fullCards.abstractCards.Card;
import gui.factories.IOverallFactory;
import gui.views.objectViews.itemsViews.FullSmallView;

public class ItemListController extends Controller {
    private Card.CreatorTypes creatorType;

    public ItemListController(Card.CreatorTypes creatorType) {
        this.creatorType = creatorType;
    }

    @Override
    public void run(IOverallFactory overallFactory) {
        FullSmallView view;
        switch(creatorType) {
            case ARMOR -> view = overallFactory.createAllArmorsItemsView();
            case WEAPONS -> view = overallFactory.createAllWeaponsItemsView();
            default -> view = overallFactory.createAllMountsItemsView();
        }
        
        view.getCancelButton().addActionListener(
                new RedirectListener(controllerManager, new ItemTypeMenuController())
        );

        mainFrame.add(view.getPanel());
    }
}
