package controllers;

import gui.factories.IOverallFactory;

import javax.swing.*;

public class ShowItemController extends Controller {
    @Override
    public void initialize(IOverallFactory overallFactory) {
        var f = overallFactory.createViewingItemsPanel();
    }
}
