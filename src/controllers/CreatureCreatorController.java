package controllers;

import gui.factories.IOverallFactory;
import gui.views.menuViews.SelectingView;

import javax.swing.*;

public class CreatureCreatorController extends Controller {
    @Override
    public void run(IOverallFactory overallFactory) {
        SelectingView selectingView = overallFactory.createCreaturesPanel();
        selectingView.getReturnButton().addActionListener(
                new RedirectListener(controllerManager, new MenuController())
        );
        //selectingView.getButton(0).addActionListener();

        mainFrame.add(selectingView.getPanel());
    }
}
