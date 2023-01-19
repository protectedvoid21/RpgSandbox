package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RedirectListener implements ActionListener {
    private Controller controller;

    public RedirectListener(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ControllerManager.getInstance().changeController(controller);
    }
}
