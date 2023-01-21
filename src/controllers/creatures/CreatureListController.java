package controllers.creatures;

import controllers.Controller;
import controllers.utils.CreatureType;
import controllers.utils.RedirectListener;
import gui.factories.IOverallFactory;
import gui.views.objectViews.itemsViews.FullSmallView;

public class CreatureListController extends Controller {
    private CreatureType creatureType;

    public CreatureListController(CreatureType creatureType) {
        this.creatureType = creatureType;
    }

    @Override
    public void run(IOverallFactory overallFactory) {
        FullSmallView view;
        switch(creatureType) {
            case NPC -> view = overallFactory.createAllNPCView();
            case MONSTER -> view = overallFactory.createAllMonstersView();
            default -> view = overallFactory.createAllCharactersView();
        }
        
        view.getCancelButton().addActionListener(
                new RedirectListener(controllerManager, new CreatureActionController(creatureType))
        );
        
        mainFrame.add(view.getPanel());
    }
}
