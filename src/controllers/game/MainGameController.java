package controllers.game;

import controllers.Controller;
import controllers.MenuController;
import controllers.utils.RedirectListener;
import game.board.Board;
import game.board.RoundManager;
import game.board.Scenario;
import game.filehandle.EntityManager;
import gui.Converter;
import gui.actionListener.warhammerActions.EndTurnListener;
import gui.factories.IOverallFactory;
import gui.views.gamePanel.gamePanels.CreatorPanel;
import gui.views.objectViews.AllObjectsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class MainGameController extends Controller {
    private RoundManager roundManager;
    private Board board;
    private Scenario scenario;

    public MainGameController(Scenario scenario) {
        this.scenario = scenario;
        this.board = new Board(scenario);
        this.roundManager = new RoundManager(board);
    }

    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createMainPanelGame();
        view.getExitButton().addActionListener(
                new RedirectListener(controllerManager, new MenuController())
        );
        view.getNextPlayerButton().addActionListener(new EndTurnListener(roundManager, view));
        var cntrl = this;
        view.getGamePanel().addOptionsListener(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var card = overallFactory.createGameCard();
                var creature = roundManager.getGameObjectWithTurn().getCreature();
                card.uploadNewData(Converter.createFullDataCreature(creature), Converter.createFullDetailDataCreature(creature));
                card.getCancelButton().addActionListener(new RedirectListener(controllerManager, cntrl));
            }
        });


        mainFrame.add(view.getPanel());
    }
}
