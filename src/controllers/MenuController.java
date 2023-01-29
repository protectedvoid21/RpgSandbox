package controllers;

import controllers.creatures.CreatureTypeController;
import controllers.game.ApplyGameController;
import controllers.items.ItemTypeMenuController;
import controllers.scenario.NewScenarioController;
import controllers.utils.RedirectListener;
import gui.bundle.CustomBundle;
import gui.factories.IOverallFactory;
import gui.views.menuViews.MenuView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

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
                new RedirectListener(controllerManager, new ApplyGameController())
        );
        menuView.getScenarioButton().addActionListener(
                new RedirectListener(controllerManager, new NewScenarioController(overallFactory))
        );
        menuView.setAudioButtonsListener(e ->
                audioManager.setSoundOn(), e -> audioManager.setSoundOff());

        menuView.addMultipleButtonListeners(new ArrayList<>(Arrays.asList("ENGLISH", "DEUTSCH")),
                new ArrayList<>(Arrays.asList(e -> generateNewController(menuView, new Locale("de", "DE"), e),
                        e -> generateNewController(menuView, new Locale("en", "US"), e))));
        menuView.settMultipleButtonIndex(CustomBundle.getCurrentLanguageIndex());

        mainFrame.add(menuView.getPanel());
    }

    private class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private void generateNewController(MenuView menuView, Locale locale, ActionEvent e) {
        CustomBundle.changeLanguage(locale);
        CustomBundle.setLanguageIndex(menuView.getMultipleButtonIndex());
        new RedirectListener(controllerManager, new MenuController()).actionPerformed(e);
    }
}
