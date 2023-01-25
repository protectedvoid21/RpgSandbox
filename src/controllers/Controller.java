package controllers;

import controllers.audio.CustomAudioManager;
import gui.factories.IOverallFactory;

import javax.swing.*;

public abstract class Controller {
    protected ControllerManager controllerManager;
    protected JFrame mainFrame;
    protected CustomAudioManager audioManager;

    public void initialize(ControllerManager controllerManager, JFrame mainFrame, CustomAudioManager manager) {
        this.controllerManager = controllerManager;
        this.mainFrame = mainFrame;
        this.audioManager = manager;
    }

    public abstract void run(IOverallFactory overallFactory);

}
