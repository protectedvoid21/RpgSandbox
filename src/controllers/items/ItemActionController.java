package controllers.items;

import controllers.*;
import controllers.utils.RedirectListener;
import game.equipment.Item;
import game.filehandle.DummyCreator;
import gui.card.fullCards.abstractCards.Card;
import gui.factories.IOverallFactory;

public class ItemActionController extends Controller {
    private Card.CardTypes creatorType;

    public ItemActionController(Card.CardTypes creatorType) {
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

        Item dummyItem = null;
        switch(creatorType) {
            case ARMOR -> dummyItem = DummyCreator.getArmor();
            case MOUNT -> dummyItem = DummyCreator.getMount();
            case WEAPONS -> dummyItem = DummyCreator.getWeapon();
        }
        
        view.getButton(1).addActionListener(
                new RedirectListener(controllerManager, new ItemCreateController(dummyItem, creatorType))
        );
        
        mainFrame.add(view.getPanel());
    }
}
