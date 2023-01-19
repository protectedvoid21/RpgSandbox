package controllers;

import gui.factories.IOverallFactory;
import gui.views.menuViews.SelectingView;

import javax.swing.*;

public class ItemTypeMenuController extends Controller {
    public ItemTypeMenuController(ControllerManager controllerManager, JFrame mainFrame) {
        super(controllerManager, mainFrame);
    }

    @Override
    public void initialize(IOverallFactory overallFactory) {
        SelectingView selectingView = overallFactory.createViewingItemsPanel();
        selectingView.getReturnButton().addActionListener(
                new RedirectListener(controllerManager, new MenuController(controllerManager, mainFrame))
        );

        //todo get item type and pass it to ItemListController
        selectingView.getButton(0).addActionListener(
                new RedirectListener(controllerManager, new ItemListController(controllerManager, mainFrame))
        );
        selectingView.getButton(1).addActionListener(
                new RedirectListener(controllerManager, new ItemListController(controllerManager, mainFrame))
        );
        selectingView.getButton(2).addActionListener(
                new RedirectListener(controllerManager, new ItemListController(controllerManager, mainFrame))
        );
        selectingView.getButton(3).addActionListener(
                new RedirectListener(controllerManager, new ItemListController(controllerManager, mainFrame))
        );
        selectingView.getButton(4).addActionListener(
                new RedirectListener(controllerManager, new ItemListController(controllerManager, mainFrame))
        );

        mainFrame.add(selectingView.getPanel());
    }
}
