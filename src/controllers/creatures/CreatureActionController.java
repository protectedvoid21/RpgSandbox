package controllers.creatures;

import controllers.Controller;
import controllers.utils.CreatureType;
import controllers.utils.RedirectListener;
import gui.factories.IOverallFactory;

public class CreatureActionController extends Controller {
    private CreatureType creatureType;

    public CreatureActionController(CreatureType creatureType) {
        this.creatureType = creatureType;
    }

    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createOverallCreaturesPanel();
        view.getReturnButton().addActionListener(
                new RedirectListener(controllerManager, new CreatureTypeController())
        );
        
        view.getButton(0).addActionListener(
                new RedirectListener(controllerManager, new CreatureEditListController(creatureType))
        );
        view.getButton(1).addActionListener(
                new RedirectListener(controllerManager, new CreateCreatureController(creatureType))
        );
        view.getButton(2).addActionListener(
                new RedirectListener(controllerManager, new CreatureListController(creatureType))
        );
        
        mainFrame.add(view.getPanel());
    }
}
