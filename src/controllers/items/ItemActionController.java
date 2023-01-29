package controllers.items;

import controllers.*;
import controllers.utils.RedirectListener;
import game.equipment.Item;
import game.filehandle.DummyCreator;
import gui.bundle.CustomBundle;
import gui.card.fullCards.abstractCards.Card;
import gui.data.TextData;
import gui.factories.IOverallFactory;
import gui.views.utilsViews.TitleView;

import java.util.Map;

public class ItemActionController extends Controller implements TextData {
    private static final Map<Card.CardTypes, String> titleTexts = Map.of(Card.CardTypes.ARMOR, CustomBundle.getDefaultString(titlearmorsManager),
            Card.CardTypes.WEAPONS, CustomBundle.getDefaultString(titleweaponsManager), Card.CardTypes.MOUNT, CustomBundle.getDefaultString(titlemountsManager), Card.CardTypes.ITEMS,
            CustomBundle.getDefaultString(titleitemsManager));
    private final Card.CardTypes creatorType;

    public ItemActionController(Card.CardTypes creatorType) {
        this.creatorType = creatorType;
    }

    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createOverallItemPanel();
        var title = new TitleView(overallFactory.getFactory());
        title.initialize(titleTexts.get(creatorType), view, 12, 20);
        view.getReturnButton().addActionListener(
                new RedirectListener(controllerManager, new ItemTypeMenuController())
        );

        view.getButton(0).addActionListener(
                new RedirectListener(controllerManager, new ItemListController(creatorType))
        );

        Item dummyItem = null;
        switch (creatorType) {
            case ARMOR -> dummyItem = DummyCreator.getArmor();
            case MOUNT -> dummyItem = DummyCreator.getMount();
            case WEAPONS -> dummyItem = DummyCreator.getWeapon();
        }

        view.getButton(1).addActionListener(
                new RedirectListener(controllerManager, new ItemCreateController(dummyItem, creatorType))
        );

        mainFrame.add(title.getPanel());
    }
}
