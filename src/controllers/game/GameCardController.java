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
        card.uploadNewData(Converter.createFullDataCreature(creature),
                Converter.createFullDetailDataCreature(creature));
        System.out.println(((Character) creature).getInventory().getArmors().
                indexOf(((Character) creature).getInventory().getActiveArmor()));
        if (creature instanceof Character) {
            var weaponIndex = ((Character) creature).getInventory().getWeapons().
                    indexOf(((Character) creature).getInventory().getActiveWeapon());
            var armorIndex = ((Character) creature).getInventory().getArmors().
                    indexOf(((Character) creature).getInventory().getActiveArmor());
            var moundIndex = ((Character) creature).getInventory().getMounts().
                    indexOf(((Character) creature).getInventory().getActiveMount());
            System.out.println(weaponIndex+"  "+armorIndex+"   "+moundIndex);
            if (weaponIndex >= 0)
                card.getGameSelectedCard(Card.CardTypes.WEAPONS).setSelectedIndex(weaponIndex);
            if (armorIndex >= 0)
                card.getGameSelectedCard(Card.CardTypes.ARMOR).setSelectedIndex(armorIndex);
            if (moundIndex >= 0)
                card.getGameSelectedCard(Card.CardTypes.MOUNT).setSelectedIndex(moundIndex);
//            card.getGameSelectedCard(Card.CardTypes.WEAPONS).setSelectedIndex(((Character) creature).getInventory()
//            .getWeapons().indexOf(((Character) creature).getInventory().getActiveWeapon()));
//            card.getGameSelectedCard(Card.CardTypes.MOUNT).setSelectedIndex(((Character) creature).getInventory()
//            .getMounts().indexOf(((Character) creature).getInventory().getActiveMount()));
        }
        mainFrame.add(card.getPanel());
        card.getCancelButton().addActionListener(new RedirectListener(controllerManager, secondcntrl));
    }
}
