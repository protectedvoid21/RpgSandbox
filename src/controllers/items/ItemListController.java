package controllers.items;

import controllers.Controller;
import controllers.creatures.CreatureCreateController;
import controllers.creatures.CreatureListController;
import controllers.creatures.CreatureShowController;
import controllers.utils.ItemType;
import controllers.utils.RedirectListener;
import game.equipment.Item;
import game.filehandle.EntityManager;
import gui.card.fullCards.abstractCards.Card;
import gui.factories.IOverallFactory;
import gui.views.objectViews.AllObjectsView;
import gui.views.objectViews.itemsViews.FullSmallView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemListController extends Controller {
    private FullSmallView view;
    private Card.CreatorTypes creatorType;
    private List<? extends Item> itemList;

    public ItemListController(Card.CreatorTypes creatorType) {
        this.creatorType = creatorType;
    }

    @Override
    public void run(IOverallFactory overallFactory) {
        switch(creatorType) {
            case ARMOR -> {
                itemList = EntityManager.getInstance().getArmorList();
                view = overallFactory.createAllArmorsItemsView();
            }
            case WEAPONS -> {
                itemList = EntityManager.getInstance().getWeaponList();
                view = overallFactory.createAllWeaponsItemsView();
            }
            default -> {
                itemList = EntityManager.getInstance().getMountList();
                view = overallFactory.createAllMountsItemsView();
            }
        }
        
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        for(var item : itemList) {
            data.add(new ArrayList<>(Arrays.asList(item.getItemPathPicture(), item.getName())));
        }
        
        view.uploadData(data);

        for(int i = 0; i < 4; i++) {
            view.addButtonActionListener(AllObjectsView.ButtonType.DELETE, i, new DeleteButtonListener());
            view.addButtonActionListener(AllObjectsView.ButtonType.EDIT, i, new EditButtonListener());
            view.addButtonActionListener(AllObjectsView.ButtonType.SHOW, i, new ShowButtonListener());
        }
        
        view.getCancelButton().addActionListener(
                new RedirectListener(controllerManager, new ItemTypeMenuController())
        );

        mainFrame.add(view.getPanel());
    }

    private class EditButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            controllerManager.changeController(new ItemCreateController(itemList.get(view.getClickedIndex()), creatorType));
        }
    }

    private class ShowButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            controllerManager.changeController(new ItemShowController(itemList.get(view.getClickedIndex()), creatorType));
        }
    }

    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            itemList.remove(view.getClickedIndex());
            EntityManager.getInstance().saveAllEntities();
        }
    }
}
