package controllers;

import gui.factories.IOverallFactory;
import gui.views.menuViews.SelectingView;

public class CreatureMenuController extends Controller {
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
