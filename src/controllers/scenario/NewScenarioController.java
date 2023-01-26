package controllers.scenario;

import controllers.Controller;
import controllers.MenuController;
import controllers.utils.CreatureType;
import controllers.utils.RedirectListener;
import game.generals.Vector2;
import gui.factories.IOverallFactory;
import gui.views.objectViews.creationViews.CreatorGameView;

public class NewScenarioController extends Controller {
    private CreatorGameView view;

    public NewScenarioController(IOverallFactory overallFactory){
        view =  overallFactory.createCreatorGameView();
    }

    @Override
    public void run(IOverallFactory overallFactory) {
//        var view = overallFactory.createCreatorGameView();
        System.out.println("wykonuje");
        view.getCreatorPanel().applyNewCreatureOnPosition("", new Vector2(2,2));
        view.getExitButton().addActionListener(
                new RedirectListener(controllerManager, new MenuController())
        );
        var cntrl = this;

        view.getCreatorPanel().addOptionsListener(0,
                new RedirectListener(controllerManager, new SetCreatureController(view,cntrl, CreatureType.MONSTER))
        );
        view.getCreatorPanel().addOptionsListener(1,
                new RedirectListener(controllerManager, new SetCreatureController(view,cntrl, CreatureType.PLAYER_CHARACTER))
        );
        view.getCreatorPanel().addOptionsListener(2,
                new RedirectListener(controllerManager, new SetCreatureController(view,cntrl, CreatureType.NPC))
        );
        
        mainFrame.add(view.getPanel());
    }
}
