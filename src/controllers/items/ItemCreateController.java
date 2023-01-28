package controllers.items;

import controllers.Controller;
import controllers.utils.CreatureType;
import controllers.utils.RedirectListener;
import game.equipment.Armor;
import game.equipment.Item;
import game.equipment.Mount;
import game.equipment.Weapon;
import game.filehandle.EntityManager;
import gui.utils.Converter;
import gui.card.CardContentDataSet;
import gui.card.fullCards.abstractCards.BaseCard;
import gui.card.fullCards.abstractCards.Card;
import gui.card.fullCards.specificCards.EntriesCard;
import gui.factories.IOverallFactory;
import gui.utils.StringAdapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ItemCreateController extends Controller {
    private EntriesCard view;
    private final Item item;
    private final Card.CardTypes creatorType;

    public ItemCreateController(Item item, Card.CardTypes creatorType) {
        this.item = item;
        this.creatorType = creatorType;
    }

    @Override
    public void run(IOverallFactory overallFactory) {
        view = overallFactory.createCreatorCard(creatorType);
        Map<Card.CardTypes, StringAdapter.Directories> map = Map.of(Card.CardTypes.ITEMS,
                StringAdapter.Directories.ITEMS, Card.CardTypes.WEAPONS, StringAdapter.Directories.WEAPONS,
                Card.CardTypes.ARMOR, StringAdapter.Directories.ARMORS, Card.CardTypes.MOUNT,
                StringAdapter.Directories.MOUNTS);
        view.setJChooserDirectory(StringAdapter.getDirectoryPath(map.get(creatorType)), false);

        CardContentDataSet contentData = null;
        switch (creatorType) {
            case ARMOR -> {
                contentData = converter.editArmorInEntriesCard((Armor) item);
            }
            case MOUNT -> {
                contentData = converter.editMountInEntriesCard((Mount) item);
            }
            case WEAPONS -> {
                contentData = converter.editWeaponInEntriesCard((Weapon) item);
            }
        }
        view.uploadCreatorItemsData(contentData, creatorType);
        view.setCreatorCard(true, creatorType);

        view.getCancelButton().addActionListener(
                new RedirectListener(controllerManager, new ItemListController(creatorType))
        );
        view.getSaveButton().addActionListener(new SaveItemListener());

        mainFrame.add(view.getPanel());
    }

    private class SaveItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CardContentDataSet contentData;
            Item newItem = null;

            switch (creatorType) {
                case ARMOR -> {
                    contentData = view.getCurrentCreatorItemData();
                    newItem = converter.createArmorFromCard(contentData);
                }
                case MOUNT -> {
                    newItem = converter.createMountFromCard(view.getCurrentCreatorItemData());
                }
                case WEAPONS -> {
                    newItem = converter.createWeaponFromCard(view.getCurrentCreatorItemData());
                }
            }

            if (item == null) {
                return;
            }
            if (converter.getErrorValidationChecker().isErrorFlag()) {
                view.setEntriesIncorrect(converter.getErrorValidationChecker().getErrorIndexes(), 1500);
                if (converter.getErrorValidationChecker().isPathError())
                    view.setTitleIncorrect(BaseCard.Side.LEFT, 1500);
                if (converter.getErrorValidationChecker().isNameError())
                    view.setTitleIncorrect(BaseCard.Side.RIGHT, 1500);
                converter.getErrorValidationChecker().resetErrorFlags();
                return;
            }

            EntityManager.getInstance().removeItem(item);
            EntityManager.getInstance().addItem(newItem);
            EntityManager.getInstance().saveAllEntities();

            controllerManager.changeController(new ItemListController(creatorType));
        }
    }
}
