package controllers.items;

import controllers.Controller;
import controllers.utils.ItemType;
import controllers.utils.RedirectListener;
import game.filehandle.EntityManager;
import gui.card.fullCards.abstractCards.Card;
import gui.factories.IOverallFactory;
import gui.views.objectViews.AllObjectsView;
import gui.views.objectViews.itemsViews.FullSmallView;

public class ItemListController extends Controller {
    private FullSmallView view;
    private Card.CreatorTypes creatorType;

    public ItemListController(Card.CreatorTypes creatorType) {
        this.creatorType = creatorType;
    }

    @Override
    public void run(IOverallFactory overallFactory) {
        switch(creatorType) {
            case ARMOR -> view = overallFactory.createAllArmorsItemsView();
            case WEAPONS -> view = overallFactory.createAllWeaponsItemsView();
            default -> view = overallFactory.createAllMountsItemsView();
        }
        
        view.getCancelButton().addActionListener(
                new RedirectListener(controllerManager, new ItemTypeMenuController())
        );
        
        var itemList = EntityManager.getInstance().getItemList();
        
        for(int i = 0; i < itemList.size(); i++) {
            //view.addButtonActionListener(AllObjectsView.ButtonType.SHOW, );
        }

        mainFrame.add(view.getPanel());
    }
}
