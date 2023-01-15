package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RedirectListener implements ActionListener {
    private ControllerManager controllerManager;
    private Controller controller;
    
    public RedirectListener(ControllerManager controllerManager, Controller controller) {
        this.controllerManager = controllerManager;
        this.controller = controller;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        controllerManager.changeController(controller);
    }
}
