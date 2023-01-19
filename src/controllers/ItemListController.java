package controllers;

import gui.factories.IOverallFactory;
import gui.views.objectViews.itemsViews.AllItemsView;

public class ItemListController extends Controller {
    @Override
    public void initialize(IOverallFactory overallFactory) {
        AllItemsView allItemsView = overallFactory.createAllItemsShowView();
        allItemsView.getCancelButton().addActionListener(
                new RedirectListener(new ItemTypeMenuController())
        );

        ControllerManager.getInstance().getMainFrame().add(allItemsView.getPanel());
    }
}
