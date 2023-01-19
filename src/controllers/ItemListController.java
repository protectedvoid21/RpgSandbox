package controllers;

import gui.factories.IOverallFactory;
import gui.views.objectViews.itemsViews.AllItemsView;

public class ItemListController extends Controller {
    @Override
    public void run(IOverallFactory overallFactory) {
        AllItemsView allItemsView = overallFactory.createAllItemsShowView();
        allItemsView.getCancelButton().addActionListener(
                new RedirectListener(controllerManager, new ItemTypeMenuController())
        );

        mainFrame.add(allItemsView.getPanel());
    }
}
