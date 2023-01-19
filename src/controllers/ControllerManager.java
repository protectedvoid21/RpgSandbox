package controllers;

import gui.factories.IOverallFactory;

import javax.swing.*;

public class ControllerManager {
    private Controller currentController;
    private JFrame mainFrame;

    private IOverallFactory overallFactory;
    
    private static ControllerManager instance;

    public ControllerManager(IOverallFactory overallFactory) {
        if(instance == null) {
            instance = this;
        }
        this.overallFactory = overallFactory;

        mainFrame = new JFrame();
        mainFrame.setSize(800, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setResizable(true);

        changeController(new MenuController());
    }
    
    public static ControllerManager getInstance() {
        return instance;
    }
    
    public JFrame getMainFrame() {
        return mainFrame;
    }

    public void changeController(Controller controller) {
        currentController = controller;
        clearFrame();

        currentController.initialize(overallFactory);
        mainFrame.setVisible(true);
    }

    private void clearFrame() {
        mainFrame.getContentPane().removeAll();
    }
}
