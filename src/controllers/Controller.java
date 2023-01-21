package controllers;

import gui.factories.IOverallFactory;

import javax.swing.*;

public abstract class Controller {
    protected ControllerManager controllerManager;
    protected JFrame mainFrame;

    public void initialize(ControllerManager controllerManager, JFrame mainFrame) {
        this.controllerManager = controllerManager;
        this.mainFrame = mainFrame;
    }
    
    public abstract void run(IOverallFactory overallFactory);
}
