package controllers;

import gui.factories.IOverallFactory;
import gui.views.menuViews.SelectingView;

public class CreatureCreatorController extends Controller {
    @Override
    public void initialize(IOverallFactory overallFactory) {
        SelectingView selectingView = overallFactory.createCreaturesPanel();
        selectingView.getReturnButton().addActionListener(
                new RedirectListener(new MenuController())
        );
        //selectingView.getButton(0).addActionListener();

        ControllerManager.getInstance().getMainFrame().add(selectingView.getPanel());
    }
}
