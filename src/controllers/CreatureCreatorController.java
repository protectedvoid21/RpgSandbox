package controllers;

import gui.factories.IOverallFactory;
import gui.views.menuViews.SelectingView;

import javax.swing.*;

public class CreatureCreatorController extends Controller {
    public CreatureCreatorController(ControllerManager controllerManager, JFrame mainFrame) {
        super(controllerManager, mainFrame);
    }

    @Override
    public void initialize(IOverallFactory overallFactory) {
        SelectingView selectingView = overallFactory.createCreaturesPanel();
        selectingView.getReturnButton().addActionListener(
                new RedirectListener(controllerManager, new MenuController(controllerManager, mainFrame))
        );
        //selectingView.getButton(0).addActionListener();

        mainFrame.add(selectingView.getPanel());
    }
}
