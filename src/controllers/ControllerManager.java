package controllers;

import javax.swing.*;

public class ControllerManager {
    private Controller currentController;
    private JFrame mainFrame;

    public ControllerManager(Controller startController, JFrame mainFrame) {
        currentController = startController;
        this.mainFrame = mainFrame;
    }

    public void changeController(Controller controller) {
        currentController = controller;
    }

    public void render() {
        currentController.render();
    }

    public void clearFrame() {
        mainFrame.removeAll();
    }
}
