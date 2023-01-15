package controllers;

import gui.factories.IOverallFactory;
import gui.views.menuViews.MenuView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController extends Controller {
    public MenuController(ControllerManager controllerManager, JFrame mainFrame) {
        super(controllerManager, mainFrame);
    }

    @Override
    public void initialize(IOverallFactory overallFactory) {
        MenuView menuView = overallFactory.createMenuView();
        menuView.getExitButton().addActionListener(new ExitListener());
        mainFrame.add(menuView.getPanel());
    }
    
    private class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
