package controllers.creatures;

import controllers.Controller;
import controllers.utils.CreatureType;
import controllers.utils.RedirectListener;
import game.creature.Creature;
import game.filehandle.EntityManager;
import gui.Converter;
import gui.card.fullCards.abstractCards.Card;
import gui.card.fullCards.specificCards.EntriesCard;
import gui.factories.IOverallFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateCreatureController extends Controller {
    private EntriesCard view;
    private CreatureType creatureType;
    
    public CreateCreatureController(CreatureType creatureType) {
        this.creatureType = creatureType;
    }
    
    @Override
    public void run(IOverallFactory overallFactory) {
        view = overallFactory.createEntriesCard();
        view.getCancelButton().addActionListener(
                new RedirectListener(controllerManager, new CreatureActionController(creatureType))
        );
        view.getSaveButton().addActionListener(new SaveCreatureListener());
        view.getSaveButton().addActionListener(
                new RedirectListener(controllerManager, new CreatureActionController(creatureType))
        );
        
        mainFrame.add(view.getPanel());
    }

    private class SaveCreatureListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            var cardContent = view.getCurrectCreatorItemData();
            Creature createdCreature = null;
            
            switch(creatureType) {
                case MONSTER -> createdCreature = Converter.createMonsterFromCard(cardContent);
                case NPC -> createdCreature = Converter.createNPCFromCard(cardContent);
                case PLAYER_CHARACTER -> createdCreature = Converter.createPlayerCharacterFromCard(cardContent);
            }
            if(createdCreature == null) {
                System.out.println("[FATAL ERROR] Passed creature is null");
                return;
            }
            
            EntityManager.getInstance().addCreature(createdCreature);
        }
    }
}
