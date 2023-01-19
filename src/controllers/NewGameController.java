package controllers;

import gui.factories.IOverallFactory;
import gui.views.objectViews.creationViews.CreatorGameView;

import javax.swing.*;

public class NewGameController extends Controller {
    @Override
    public void run(IOverallFactory overallFactory) {
        CreatorGameView creatorGameView = overallFactory.createCreatorGameView();
        creatorGameView.getExitButton().addActionListener(
                new RedirectListener(controllerManager, new MenuController())
        );

        mainFrame.add(creatorGameView.getPanel());
    }
}
