package controllers.creatures;

import controllers.Controller;
import controllers.MenuController;
import controllers.RedirectListener;
import gui.factories.IOverallFactory;

public class CreatureTypeController extends Controller {
    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createCreaturesPanel();
        view.getReturnButton().addActionListener(
                new RedirectListener(controllerManager, new MenuController())
        );
        view.getButton(0).addActionListener(
                new RedirectListener(controllerManager, new CreatureActionController())
        );
        view.getButton(1).addActionListener(
                new RedirectListener(controllerManager, new CreatureActionController())
        );
        view.getButton(2).addActionListener(
                new RedirectListener(controllerManager, new CreatureActionController())
        );

        mainFrame.add(view.getPanel());
    }
}
