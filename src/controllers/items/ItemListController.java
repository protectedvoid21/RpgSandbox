package controllers.items;

import controllers.Controller;
import controllers.RedirectListener;
import gui.factories.IOverallFactory;
import gui.views.objectViews.itemsViews.AllItemsView;

public class ItemListController extends Controller {
    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createAllItemsShowView();
        view.getCancelButton().addActionListener(
                new RedirectListener(controllerManager, new ItemTypeMenuController())
        );

        mainFrame.add(view.getPanel());
    }
}
