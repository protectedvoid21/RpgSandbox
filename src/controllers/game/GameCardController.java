package controllers.game;

import controllers.Controller;
import controllers.MenuController;
import controllers.utils.RedirectListener;
import game.board.ScenarioTester;
import game.creature.Character;
import game.creature.Creature;
import game.filehandle.EntityManager;
import gui.Converter;
import gui.card.fullCards.abstractCards.Card;
import gui.factories.IOverallFactory;
import gui.views.gamePanel.gamePanels.CreatorPanel;
import gui.views.objectViews.AllObjectsView;

import java.util.ArrayList;

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
        if (creature instanceof Character) {
            card.getGameSelectedCard(Card.CardTypes.ARMOR).setSelectedIndex(((Character) creature).getInventory().getArmors().indexOf(((Character) creature).getInventory().getActiveArmor()));
            card.getGameSelectedCard(Card.CardTypes.WEAPONS).setSelectedIndex(((Character) creature).getInventory().getWeapons().indexOf(((Character) creature).getInventory().getActiveWeapon()));
            card.getGameSelectedCard(Card.CardTypes.MOUNT).setSelectedIndex(((Character) creature).getInventory().getMounts().indexOf(((Character) creature).getInventory().getActiveMount()));
        }
        mainFrame.add(card.getPanel());
        card.getCancelButton().addActionListener(new RedirectListener(controllerManager, secondcntrl));
    }
}
