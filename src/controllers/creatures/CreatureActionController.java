package controllers.creatures;

import controllers.Controller;
import controllers.utils.CreatureType;
import controllers.utils.RedirectListener;
import game.creature.Creature;
import game.filehandle.DummyCreator;
import gui.factories.IOverallFactory;

public class CreatureActionController extends Controller {
    private CreatureType creatureType;
    private Creature dummyCreature;

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
        view.getReturnButton().addActionListener(
                new RedirectListener(controllerManager, new CreatureTypeController())
        );

        view.getButton(0).addActionListener(
                new RedirectListener(controllerManager, new CreatureCreateController(dummyCreature ,creatureType))
        );
        view.getButton(1).addActionListener(
                new RedirectListener(controllerManager, new CreatureListController(creatureType))
        );
        
        mainFrame.add(view.getPanel());
    }
}
