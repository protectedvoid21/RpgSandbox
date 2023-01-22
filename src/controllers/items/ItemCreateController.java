package controllers.items;

import controllers.Controller;
import controllers.utils.RedirectListener;
import game.equipment.Item;
import game.filehandle.EntityManager;
import gui.Converter;
import gui.card.CardContentDataSet;
import gui.card.fullCards.abstractCards.Card;
import gui.card.fullCards.specificCards.EntriesCard;
import gui.factories.IOverallFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemCreateController extends Controller {
    private EntriesCard view;
    private Item item;
    private Card.CreatorTypes creatorType;
    
    public ItemCreateController(Item item, Card.CreatorTypes creatorType) {
        this.item = item;
        this.creatorType = creatorType;
    }
    
    @Override
    public void run(IOverallFactory overallFactory) {
        view = overallFactory.createCreatorCard(creatorType);
        
        view.getCancelButton().addActionListener(
                new RedirectListener(controllerManager, new ItemTypeMenuController())
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
                    contentData = view.generateContentData().get(Card.CardTypes.ARMOR);
                    newItem = Converter.createArmorFromCard(contentData);
                } 
                case MOUNT -> {
                    contentData = view.generateContentData().get(Card.CardTypes.MOUNT);
                    newItem = Converter.createMountFromCard(contentData);
                }
                case WEAPONS -> {
                    contentData = view.generateContentData().get(Card.CardTypes.WEAPONS);
                    newItem = Converter.createWeaponFromCard(contentData);
                }
            }
            
            if(item == null) {
                System.out.println("[FATAL ERROR] Passed item is null");
                return;
            }

            EntityManager.getInstance().removeItem(item);
            EntityManager.getInstance().addItem(newItem);

            controllerManager.changeController(new ItemListController(creatorType));
        }
    }
}
