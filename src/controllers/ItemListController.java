package controllers;

import gui.factories.IOverallFactory;
import gui.views.objectViews.itemsViews.AllItemsShowView;

import javax.swing.*;

public class ItemListController extends Controller {
    public ItemListController(ControllerManager controllerManager, JFrame mainFrame) {
        super(controllerManager, mainFrame);
    }

    @Override
    public void initialize(IOverallFactory overallFactory) {
        AllItemsShowView allItemsView = overallFactory.createAllItemsShowView();
        allItemsView.getCancelButton().addActionListener(
                new RedirectListener(controllerManager, new ItemTypeMenuController(controllerManager, mainFrame))
        );
        
        mainFrame.add(allItemsView.getPanel());
    }
}
