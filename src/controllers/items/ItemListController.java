package controllers.items;

import controllers.Controller;
import controllers.utils.RedirectListener;
import gui.factories.IOverallFactory;

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
