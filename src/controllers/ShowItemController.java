package controllers;

import gui.factories.IOverallFactory;

import javax.swing.*;

public class ShowItemController extends Controller {
    @Override
    public void run(IOverallFactory overallFactory) {
        var f = overallFactory.createViewingItemsPanel();
    }
}
