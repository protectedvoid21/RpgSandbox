package controllers;

import gui.factories.IOverallFactory;
import gui.views.menuViews.SelectingView;

public class ItemTypeMenuController extends Controller {
    @Override
    public void initialize(IOverallFactory overallFactory) {
        SelectingView selectingView = overallFactory.createViewingItemsPanel();
        selectingView.getReturnButton().addActionListener(
                new RedirectListener(new MenuController())
        );

        //todo get item type and pass it to ItemListController
        selectingView.getButton(0).addActionListener(
                new RedirectListener(new ItemListController())
        );
        selectingView.getButton(1).addActionListener(
                new RedirectListener(new ItemListController())
        );
        selectingView.getButton(2).addActionListener(
                new RedirectListener(new ItemListController())
        );
        selectingView.getButton(3).addActionListener(
                new RedirectListener(new ItemListController())
        );
        selectingView.getButton(4).addActionListener(
                new RedirectListener(new ItemListController())
        );

        ControllerManager.getInstance().getMainFrame().add(selectingView.getPanel());
    }
}
