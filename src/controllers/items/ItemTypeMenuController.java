package controllers.items;

import controllers.Controller;
import controllers.MenuController;
import controllers.RedirectListener;
import controllers.items.ItemListController;
import gui.factories.IOverallFactory;

public class ItemTypeMenuController extends Controller {
    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createViewingItemsPanel();
        view.getReturnButton().addActionListener(
                new RedirectListener(controllerManager, new MenuController())
        );

        view.getButton(0).addActionListener(
                new RedirectListener(controllerManager, new ItemListController()));
        view.getButton(1).addActionListener(
                new RedirectListener(controllerManager, new ItemListController()));
        view.getButton(2).addActionListener(
                new RedirectListener(controllerManager, new ItemListController()));
        view.getButton(3).addActionListener(
                new RedirectListener(controllerManager, new ItemListController()));
        view.getButton(4).addActionListener(
                new RedirectListener(controllerManager, new ItemListController()));

        mainFrame.add(view.getPanel());
    }
}
