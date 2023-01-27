package controllers.game;

import controllers.Controller;
import controllers.utils.RedirectListener;
import game.creature.Character;
import game.creature.Creature;
import gui.utils.Converter;
import gui.card.fullCards.abstractCards.Card;
import gui.factories.IOverallFactory;

public class GameCardController extends Controller {
    private Creature creature;
    private Controller secondcntrl;

    public GameCardController(Creature creature, Controller secondcntrl) {
        this.creature = creature;
        this.secondcntrl = secondcntrl;
    }

    @Override
    public void run(IOverallFactory overallFactory) {
        var card = overallFactory.createGameCard();
        card.uploadNewData(converter.createFullDataCreature(creature),
                converter.createFullDetailDataCreature(creature));
        if (creature instanceof Character character) {
            var weaponIndex = character.getInventory().getWeapons().
                    indexOf(character.getInventory().getActiveWeapon());
            var armorIndex = character.getInventory().getArmors().
                    indexOf(character.getInventory().getActiveArmor());
            var moundIndex = character.getInventory().getMounts().
                    indexOf(character.getInventory().getActiveMount());
            if (weaponIndex >= 0)
                card.getGameSelectedCard(Card.CardTypes.WEAPONS).setSelectedIndex(weaponIndex);
            if (armorIndex >= 0)
                card.getGameSelectedCard(Card.CardTypes.ARMOR).setSelectedIndex(armorIndex);
            if (moundIndex >= 0)
                card.getGameSelectedCard(Card.CardTypes.MOUNT).setSelectedIndex(moundIndex);
        }
        mainFrame.add(card.getPanel());
        card.getCancelButton().addActionListener(new RedirectListener(controllerManager, secondcntrl));
    }
}
