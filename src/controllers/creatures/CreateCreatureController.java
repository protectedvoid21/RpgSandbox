package controllers.creatures;

import controllers.Controller;
import controllers.RedirectListener;
import gui.factories.IOverallFactory;

public class CreateCreatureController extends Controller {
    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createEntriesCard();
        view.getCancelButton().addActionListener(
                new RedirectListener(controllerManager, new CreatureActionController())
        );
        
        mainFrame.add(view.getPanel());
    }
}
