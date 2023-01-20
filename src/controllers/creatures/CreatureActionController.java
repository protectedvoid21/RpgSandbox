package controllers.creatures;

import controllers.Controller;
import controllers.RedirectListener;
import gui.factories.IOverallFactory;

public class CreatureActionController extends Controller {
    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createOverallCreaturesPanel();
        view.getReturnButton().addActionListener(
                new RedirectListener(controllerManager, new CreatureTypeController())
        );
        
        view.getButton(0).addActionListener(
                new RedirectListener(controllerManager, new CreatureEditListController())
        );
        view.getButton(1).addActionListener(
                new RedirectListener(controllerManager, new CreateCreatureController())
        );
        view.getButton(2).addActionListener(
                new RedirectListener(controllerManager, new CreatureListController())
        );
        
        mainFrame.add(view.getPanel());
    }
}
