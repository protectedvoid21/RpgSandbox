package controllers;

import controllers.audio.CustomAudioManager;
import gui.factories.IOverallFactory;
import gui.utils.AbstractConverter;
import gui.utils.Converter;
import gui.utils.StringAdapter;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class ControllerManager {
    private Controller currentController;
    private AbstractConverter converter;
    private JFrame mainFrame;

    private IOverallFactory overallFactory;
    private CustomAudioManager audioManager;

    public ControllerManager(IOverallFactory overallFactory, CustomAudioManager audioManager,
                             AbstractConverter converter) {
        this.overallFactory = overallFactory;
        this.converter = converter;
        mainFrame = new JFrame();
        mainFrame.setSize(800, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setResizable(true);
        this.audioManager = audioManager;
        changeController(new MenuController());
    }

    public void setFrameData(String title, String iconPath) {
        mainFrame.setTitle(title);
        mainFrame.setIconImage(new ImageIcon(StringAdapter.getTitleIconPath(iconPath)).getImage());
    }

    public void changeController(Controller controller) {
        currentController = controller;
        controller.initialize(this, mainFrame, converter, audioManager);
        clearFrame();
        currentController.run(overallFactory);
        mainFrame.setVisible(true);
    }

    private void clearFrame() {
        mainFrame.getContentPane().removeAll();
    }
}
