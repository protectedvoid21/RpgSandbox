package controllers.creatures;

import controllers.Controller;
import controllers.utils.CreatureType;
import controllers.utils.RedirectListener;
import game.creature.Creature;
import game.filehandle.EntityManager;
import game.interfaces.IFactory;
import gui.Converter;
import gui.card.DoubleArrowPanel;
import gui.card.fullCards.abstractCards.BaseCard;
import gui.card.fullCards.abstractCards.Card;
import gui.card.fullCards.specificCards.EntriesCard;
import gui.factories.IOverallFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreatureCreateController extends Controller {
    private EntriesCard view;
    private Creature creature;
    private CreatureType creatureType;

    public CreatureCreateController(Creature creature, CreatureType creatureType) {
        this.creature = creature;
        this.creatureType = creatureType;
    }

    @Override
    public void run(IOverallFactory overallFactory) {
        view = overallFactory.createEntriesCard();
        var contentData = Converter.createFullDataCreature(creature);
        view.uploadNewData(contentData, Converter.createFullDetailDataCreature(creature));

        view.getCancelButton().addActionListener(
                new RedirectListener(controllerManager, new CreatureListController(creatureType))
        );
        view.getSaveButton().addActionListener(new SaveListener());

        mainFrame.add(view.getPanel());
    }

    private class SaveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            var data = view.generateContentData().get(Card.CardTypes.OVERALL);
            var contentData = view.generateContentData().get(Card.CardTypes.ATTRIBUTE).clone();
            contentData.titlePath = data.titlePath;
            contentData.titleContent = data.titleContent;

            EntityManager.getInstance().removeCreature(creature);
            Creature newCreature = null;
            System.out.println(contentData + "moj content");

            switch (creatureType) {
                case MONSTER -> {
                    newCreature = Converter.createMonsterFromCard(contentData);
                }
                case PLAYER_CHARACTER -> {
                    newCreature = Converter.createPlayerCharacterFromCard(contentData);
                }
                case NPC -> {
                    newCreature = Converter.createNPCFromCard(contentData);
                }
            }
            if (IFactory.isErrorFlag()) {
                System.out.println("helllo");
                view.setEntriesIncorrect(IFactory.getErrorIndexes(), 1500);
                if (IFactory.isPathError())
                    view.setTitleIncorrect(BaseCard.Side.LEFT, 1500);
                if (IFactory.isNameError())
                    view.setTitleIncorrect(BaseCard.Side.RIGHT, 1500);
                IFactory.resetErrorFlags();
                return;
            }

            EntityManager.getInstance().addCreature(newCreature);
            EntityManager.getInstance().saveAllEntities();

            controllerManager.changeController(new CreatureListController(creatureType));
        }
    }
}
