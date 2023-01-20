package controllers;

import gui.factories.IOverallFactory;

public class CreatureActionController extends Controller {
    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createOverallCreaturesPanel();
        view.getReturnButton().addActionListener(
                new RedirectListener(controllerManager, new CreatureMenuController())
        );
        
        mainFrame.add(view.getPanel());
    }
}
