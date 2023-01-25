package controllers;

import gui.factories.IOverallFactory;
import gui.utils.Converter;

import javax.swing.*;

public abstract class Controller {
    protected ControllerManager controllerManager;
    protected JFrame mainFrame;
    protected Converter converter;

    public void initialize(ControllerManager controllerManager, JFrame mainFrame, Converter converter) {
        this.controllerManager = controllerManager;
        this.mainFrame = mainFrame;
        this.converter=converter;
    }
    
    public abstract void run(IOverallFactory overallFactory);
}
