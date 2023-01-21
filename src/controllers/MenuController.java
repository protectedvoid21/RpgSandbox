package controllers;

import controllers.creatures.CreatureTypeController;
import controllers.items.ItemActionController;
import controllers.items.ItemListController;
import controllers.items.ItemTypeMenuController;
import controllers.utils.RedirectListener;
import gui.factories.IOverallFactory;
import gui.views.menuViews.MenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController extends Controller {
    @Override
    public void run(IOverallFactory overallFactory) {
        MenuView menuView = overallFactory.createMenuView();
        menuView.getExitButton().addActionListener(new ExitListener());
        
        menuView.getCreaturesButton().addActionListener(
                new RedirectListener(controllerManager, new CreatureTypeController())
        );
        menuView.getItemsButton().addActionListener(
                new RedirectListener(controllerManager, new ItemTypeMenuController())
        );
        menuView.getNewGameButton().addActionListener(
                new RedirectListener(controllerManager, new NewGameController())
        );
        
        mainFrame.add(menuView.getPanel());
    }

    private class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
