package controllers.creatures;

import controllers.Controller;
import controllers.utils.CreatureType;
import controllers.utils.RedirectListener;
import game.creature.Character;
import game.creature.Creature;
import game.filehandle.EntityManager;
import game.interfaces.IFactory;
import gui.utils.Converter;
import gui.card.fullCards.abstractCards.BaseCard;
import gui.card.fullCards.abstractCards.Card;
import gui.card.fullCards.specificCards.EntriesCard;
import gui.factories.IOverallFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Map;

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
        var contentData = converter.createFullDataCreature(creature);
        view.uploadNewData(contentData, converter.createFullDetailDataCreature(creature));
        view.uploadNewChoserCardData(converter.createFullDataCreature(EntityManager.getInstance().getPlayerCharacterWithAllItems()),
                converter.createFullDetailDataCreature(EntityManager.getInstance().getPlayerCharacterWithAllItems()));
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
            var entity = EntityManager.getInstance();
            var entitiesMap = Map.of(Card.CardTypes.ARMOR, entity.getArmorList(), Card.CardTypes.MOUNT,
                    entity.getMountList(), Card.CardTypes.WEAPONS, entity.getWeaponList(), Card.CardTypes.ITEMS,
                    entity.getDisposableItemList());

            switch (creatureType) {
                case MONSTER -> newCreature = converter.createMonsterFromCard(contentData);
                case PLAYER_CHARACTER -> newCreature = converter.createPlayerCharacterFromCard(contentData);
                case NPC -> newCreature = converter.createNPCFromCard(contentData);

            }
            if (newCreature instanceof Character castedCharacter) {
                var numberData = view.generateIndexesNumberData();
                for (var type : Arrays.asList(Card.CardTypes.ARMOR, Card.CardTypes.MOUNT, Card.CardTypes.WEAPONS,
                        Card.CardTypes.ITEMS)) {
                    for (var item : numberData.get(type))
                        castedCharacter.getInventory().addItem(entitiesMap.get(type).get(item));
                }
            }


            if (IFactory.getErrorValidationChecker().isErrorFlag()) {
                view.setEntriesIncorrect(IFactory.getErrorValidationChecker().getErrorIndexes(), 1500);
                if (IFactory.getErrorValidationChecker().isPathError())
                    view.setTitleIncorrect(BaseCard.Side.LEFT, 1500);
                if (IFactory.getErrorValidationChecker().isNameError())
                    view.setTitleIncorrect(BaseCard.Side.RIGHT, 1500);
                IFactory.getErrorValidationChecker().resetErrorFlags();
                return;
            }

            EntityManager.getInstance().removeCreature(creature);
            EntityManager.getInstance().addCreature(newCreature);
            EntityManager.getInstance().saveAllEntities();

            controllerManager.changeController(new CreatureListController(creatureType));
        }
    }
}
