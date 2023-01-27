package controllers;

import controllers.audio.CustomAudioManager;
import gui.factories.IOverallFactory;
import gui.utils.Converter;

import javax.swing.*;

public abstract class Controller {
    protected ControllerManager controllerManager;
    protected JFrame mainFrame;
    protected Converter converter;
    protected CustomAudioManager audioManager;

    public void initialize(ControllerManager controllerManager, JFrame mainFrame, Converter converter, CustomAudioManager audioManager) {
        this.controllerManager = controllerManager;
        this.mainFrame = mainFrame;
        this.audioManager = audioManager;
        this.converter = converter;
    }
    
    public abstract void run(IOverallFactory overallFactory);
}
