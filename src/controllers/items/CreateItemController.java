package controllers.items;

import controllers.Controller;
import controllers.utils.RedirectListener;
import game.equipment.Item;
import game.filehandle.EntityManager;
import gui.Converter;
import gui.card.fullCards.abstractCards.Card;
import gui.card.fullCards.specificCards.EntriesCard;
import gui.factories.IOverallFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateItemController extends Controller {
    private EntriesCard view;
    private Card.CreatorTypes creatorType;
    
    public CreateItemController(Card.CreatorTypes creatorType) {
        this.creatorType = creatorType;
    }
    
    @Override
    public void run(IOverallFactory overallFactory) {
        view = overallFactory.createCreatorCard(creatorType);
        
        view.getCancelButton().addActionListener(
                new RedirectListener(controllerManager, new ItemTypeMenuController())
        );
        view.getSaveButton().addActionListener(new SaveItemListener());
        view.getSaveButton().addActionListener(
                new RedirectListener(controllerManager, new ItemTypeMenuController())
        );
        
        mainFrame.add(view.getPanel());
    }
    
    private class SaveItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Item item = null;
            var contentSet = view.getCurrectCreatorItemData();
            
            switch (creatorType) {
                case ARMOR -> item = Converter.createArmorFromCard(contentSet);
                case MOUNT -> item = Converter.createMountFromCard(contentSet);
                case WEAPONS -> item = Converter.createWeaponFromCard(contentSet);
            }
            
            if(item == null) {
                System.out.println("[FATAL ERROR] Passed item is null");
                return;
            }

            EntityManager.getInstance().addItem(item);
        }
    }
}
