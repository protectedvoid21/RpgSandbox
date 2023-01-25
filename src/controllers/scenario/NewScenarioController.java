package controllers.scenario;

import controllers.Controller;
import controllers.MenuController;
import controllers.utils.CreatureType;
import controllers.utils.RedirectListener;
import gui.factories.IOverallFactory;
import gui.views.objectViews.creationViews.CreatorGameView;

public class NewScenarioController extends Controller {
    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createCreatorGameView();
        view.getExitButton().addActionListener(
                new RedirectListener(controllerManager, new MenuController())
        );

        view.getCreatorPanel().addOptionsListener(0, 
                new RedirectListener(controllerManager, new SetCreatureController(this, CreatureType.MONSTER))
        );
        view.getCreatorPanel().addOptionsListener(1,
                new RedirectListener(controllerManager, new SetCreatureController(this, CreatureType.NPC))
        );
        view.getCreatorPanel().addOptionsListener(2,
                new RedirectListener(controllerManager, new SetCreatureController(this, CreatureType.PLAYER_CHARACTER))
        );
        
        mainFrame.add(view.getPanel());
    }
}
