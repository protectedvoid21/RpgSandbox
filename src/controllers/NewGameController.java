package controllers;

import gui.factories.IOverallFactory;
import gui.views.objectViews.creationViews.CreatorGameView;

import javax.swing.*;

public class NewGameController extends Controller {
    public NewGameController(ControllerManager controllerManager, JFrame mainFrame) {
        super(controllerManager, mainFrame);
    }

    @Override
    public void initialize(IOverallFactory overallFactory) {
        CreatorGameView creatorGameView = overallFactory.createCreatorGameView();
        creatorGameView.getExitButton().addActionListener(
                new RedirectListener(controllerManager, new MenuController(controllerManager, mainFrame))
        );
        
        mainFrame.add(creatorGameView.getPanel());
    }
}
