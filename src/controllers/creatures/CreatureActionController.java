package controllers.creatures;

import controllers.Controller;
import controllers.utils.CreatureType;
import controllers.utils.RedirectListener;
import game.creature.Creature;
import game.filehandle.DummyCreator;
import gui.card.fullCards.abstractCards.Card;
import gui.factories.IOverallFactory;
import gui.views.TitleView;

import java.util.Map;

public class CreatureActionController extends Controller {
    private final CreatureType creatureType;
    private Creature dummyCreature;
    private static final Map<CreatureType, String> titleTexts = Map.of(CreatureType.NPC, "NPC Manager",
            CreatureType.MONSTER, "Monster Manager", CreatureType.PLAYER_CHARACTER, "Player Character Manager");

    public CreatureActionController(CreatureType creatureType) {
        this.creatureType = creatureType;
        
        switch(creatureType) {
            case MONSTER -> {
                dummyCreature = DummyCreator.getMonster();
            }
            case PLAYER_CHARACTER -> {
                dummyCreature = DummyCreator.getPlayerCharacter();
            }
            case NPC -> {
                dummyCreature = DummyCreator.getNPC();
            }
        }
    }

    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createOverallCreaturesPanel();
        var title = new TitleView(overallFactory.getFactory());
        title.initialize(titleTexts.get(creatureType), view, 12, 20);
        view.getReturnButton().addActionListener(
                new RedirectListener(controllerManager, new CreatureTypeController())
        );

        view.getButton(0).addActionListener(
                new RedirectListener(controllerManager, new CreatureCreateController(dummyCreature ,creatureType))
        );
        view.getButton(1).addActionListener(
                new RedirectListener(controllerManager, new CreatureListController(creatureType))
        );
        
        mainFrame.add(title.getPanel());
    }
}
