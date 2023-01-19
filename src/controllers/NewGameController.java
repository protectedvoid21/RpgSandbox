package controllers;

import gui.factories.IOverallFactory;
import gui.views.objectViews.creationViews.CreatorGameView;

public class NewGameController extends Controller {
    @Override
    public void initialize(IOverallFactory overallFactory) {
        CreatorGameView creatorGameView = overallFactory.createCreatorGameView();
        creatorGameView.getExitButton().addActionListener(
                new RedirectListener(new MenuController())
        );

        ControllerManager.getInstance().getMainFrame().add(creatorGameView.getPanel());
    }
}
