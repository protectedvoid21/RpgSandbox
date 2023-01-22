package controllers.game;

import controllers.Controller;
import controllers.MenuController;
import controllers.utils.RedirectListener;
import game.board.Board;
import game.board.RoundManager;
import game.board.Scenario;
import game.filehandle.EntityManager;
import game.generals.Vector2;
import gui.Converter;
import gui.actionListener.scrollItem.*;
import gui.actionListener.turnOffButtons;
import gui.actionListener.warhammerActions.*;
import gui.card.DoubleArrowPanel;
import gui.factories.GuiFactory;
import gui.factories.IOverallFactory;
import gui.views.gamePanel.MainPanelGame;
import gui.views.gamePanel.gamePanels.CreatorPanel;
import gui.views.gamePanel.gamePanels.GamePanel;
import gui.views.objectViews.AllObjectsView;
import gui.views.pickers.CustomLambdaExpression;
import gui.views.pickers.FullItemPicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MainGameController extends Controller {
    private RoundManager roundManager;
    private Board board;
    private Scenario scenario;
    private MainPanelGame gamePanel;

    public MainGameController(Scenario scenario) {
        this.scenario = scenario;
        this.board = new Board(scenario);
        this.roundManager = new RoundManager(board);
    }

    private void startGame() {
        roundManager.startNewTurn();
//        gamePanel.getGamePanel().applyContent(roundManager.boardToList());
//        roundManager.moveToNextObject();
//        gamePanel.getGamePanel().colorButtons(roundManager.getGameObjectWithTurnPosition());
//        turnOffButtons.turnOff(roundManager,gamePanel,2,0);
    }

    @Override
    public void run(IOverallFactory overallFactory) {
        gamePanel = overallFactory.createMainPanelGame();

        gamePanel.getExitButton().addActionListener(
                new RedirectListener(controllerManager, new MenuController())
        );
        gamePanel.getNextPlayerButton().addActionListener(new EndTurnListener(roundManager, gamePanel));
        var cntrl = this;

        startGame();

        int i = 0;
        for (var listener : Arrays.asList(new MoveListener(roundManager, gamePanel),
                new RedirectListener(controllerManager,
                        new GameCardController(roundManager.getGameObjectWithTurn().getCreature(), this)),
                new AttackListener(roundManager, gamePanel),
                new CarefullListener(roundManager, gamePanel),
                new MultipleAttackListener(roundManager, gamePanel))) {
            gamePanel.getGamePanel().addOptionsListener(i++, listener);
        }

        int j = 0;
        for (var list : Arrays.asList(new AimingListener(roundManager, gamePanel), new BlockListener(roundManager,
                gamePanel), new DefenseStandListener(roundManager, gamePanel))) {
            gamePanel.getActivityOptionsPanel().addOptionsPanelCommand(j++, list);
        }
        applyPickerListener(FullItemPicker.LabelType.WEAPON, new PreviousWeaponListener(roundManager), new NextWeaponListener(roundManager));
        applyPickerListener(FullItemPicker.LabelType.ARMOR, new PreviousArmorListener(roundManager), new NextArmorListener(roundManager));
        applyPickerListener(FullItemPicker.LabelType.MOUNT, new PreviousMountListener(roundManager), new NextMountListener(roundManager));

        mainFrame.add(gamePanel.getPanel());
    }

    private void applyPickerListener(FullItemPicker.LabelType type, CustomLambdaExpression expLeft,
                                     CustomLambdaExpression expRight) {
        gamePanel.getPicker(type).addListenerToPicker(DoubleArrowPanel.Side.LEFT, expLeft);
        gamePanel.getPicker(type).addListenerToPicker(DoubleArrowPanel.Side.RIGHT, expRight);
    }
}
