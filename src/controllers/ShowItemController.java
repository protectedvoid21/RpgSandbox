package controllers;

import gui.factories.IOverallFactory;

import javax.swing.*;

public class ShowItemController extends Controller {
    public ShowItemController(ControllerManager controllerManager, JFrame mainFrame) {
        super(controllerManager, mainFrame);
    }

    @Override
    public void initialize(IOverallFactory overallFactory) {
        var f = overallFactory.createViewingItemsPanel();    
    }
}
