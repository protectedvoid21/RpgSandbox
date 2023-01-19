package controllers;

import gui.factories.IOverallFactory;
import gui.views.menuViews.MenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController extends Controller {
    @Override
    public void initialize(IOverallFactory overallFactory) {
        MenuView menuView = overallFactory.createMenuView();
        menuView.getExitButton().addActionListener(new ExitListener());
        menuView.getCreaturesButton().addActionListener(
                new RedirectListener(new CreatureCreatorController()));
        menuView.getItemsButton().addActionListener(
                new RedirectListener(new ItemTypeMenuController()));
        menuView.getNewGameButton().addActionListener(
                new RedirectListener(new NewGameController())
        );
        ControllerManager.getInstance().getMainFrame().add(menuView.getPanel());
    }

    private class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
