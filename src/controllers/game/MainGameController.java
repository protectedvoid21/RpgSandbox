package controllers.game;

import controllers.Controller;
import controllers.MenuController;
import controllers.utils.RedirectListener;
import game.board.Board;
import game.board.RoundManager;
import game.board.Scenario;
import game.creature.Character;
import game.filehandle.EntityManager;
import game.generals.Vector2;
import gui.actionListener.basicActionsListener.*;
import gui.actionListener.scrollItem.*;
import gui.actionListener.turnOffButtons;
import gui.actionListener.warhammerActions.*;
import gui.card.DoubleArrowPanel;
import gui.factories.IOverallFactory;
import gui.utils.FileManager;
import gui.views.gamePanel.MainPanelGame;
import gui.views.pickers.CustomLambdaExpression;
import gui.views.pickers.FullItemPicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

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
        gamePanel.getGamePanel().applyContent(roundManager.boardToList());
        gamePanel.getGamePanel().colorButtons(roundManager.getGameObjectWithTurnPosition());
        turnOffButtons.turnOff(roundManager, gamePanel, 2, 0);
    }

    private Vector2 getclickedIndexes() {
        return gamePanel.getGamePanel().getCurrentClickedIndexes();
    }

    private GameCardController createGameCardController() {
        return new GameCardController(!getclickedIndexes().isOutOfRange(10, 10) ?
                roundManager.getBoard().getPlace(getclickedIndexes()).getGameObject().getCreature() : null, this);
    }


    private class ClickGameCardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            controllerManager.changeController(createGameCardController());
        }
    }

    private class ExitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controllerManager.changeController(new MenuController());
            EntityManager.getInstance().loadAllEntities();
        }
    }

    @Override
    public void run(IOverallFactory overallFactory) {
        gamePanel = overallFactory.createMainPanelGame();

        gamePanel.getExitButton().addActionListener(
                new ExitListener());
        gamePanel.getNextPlayerButton().addActionListener(new EndTurnListener(roundManager, gamePanel));

        startGame();

        gamePanel.getGamePanel().addOptionsListener(0, new MoveListener(roundManager, gamePanel));
        gamePanel.getGamePanel().addOptionsListener(1, new ClickGameCardListener());
        gamePanel.getGamePanel().addOptionsListener(2, new AttackListener(roundManager, gamePanel));
        gamePanel.getGamePanel().addOptionsListener(3, new CarefullListener(roundManager, gamePanel));
        gamePanel.getGamePanel().addOptionsListener(4, new MultipleAttackListener(roundManager, gamePanel));
        gamePanel.getItemsItemPicker().addButtonListener(new TurnOnEnemySelecting(roundManager, gamePanel));

        int j = 0;
        for (var list : Arrays.asList(new AimingListener(roundManager, gamePanel), new BlockListener(roundManager,
                gamePanel), new DefenseStandListener(roundManager, gamePanel))) {
            gamePanel.getActivityOptionsPanel().addOptionsPanelCommand(j++, list);
        }
        applyPickerListener(FullItemPicker.LabelType.WEAPON, new PreviousWeaponListener(roundManager),
                new NextWeaponListener(roundManager));
        applyPickerListener(FullItemPicker.LabelType.ARMOR, new PreviousArmorListener(roundManager),
                new NextArmorListener(roundManager));
        applyPickerListener(FullItemPicker.LabelType.MOUNT, new PreviousMountListener(roundManager),
                new NextMountListener(roundManager));
        gamePanel.getPicker(FullItemPicker.LabelType.WEAPON).addListenerToPicker(DoubleArrowPanel.Side.LEFT,
                new PreviousWeaponListener(roundManager));
        gamePanel.getPicker(FullItemPicker.LabelType.MOUNT).addListenerToPicker(DoubleArrowPanel.Side.LEFT,
                new PreviousMountListener(roundManager));
        gamePanel.getPicker(FullItemPicker.LabelType.ARMOR).addListenerToPicker(DoubleArrowPanel.Side.LEFT,
                new PreviousArmorListener(roundManager));
        gamePanel.getPicker(FullItemPicker.LabelType.WEAPON).addListenerToPicker(DoubleArrowPanel.Side.RIGHT,
                new NextWeaponListener(roundManager));
        gamePanel.getPicker(FullItemPicker.LabelType.MOUNT).addListenerToPicker(DoubleArrowPanel.Side.RIGHT,
                new NextMountListener(roundManager));
        gamePanel.getPicker(FullItemPicker.LabelType.ARMOR).addListenerToPicker(DoubleArrowPanel.Side.RIGHT,
                new NextArmorListener(roundManager));
        mainFrame.add(gamePanel.getPanel());

        gamePanel.getItemsItemPicker().addListenerToPicker(DoubleArrowPanel.Side.LEFT,
                new PreviousActiveListener(roundManager));
        gamePanel.getItemsItemPicker().addListenerToPicker(DoubleArrowPanel.Side.RIGHT,
                new NextActiveListener(roundManager));


        gamePanel.getItemsItemPicker().addButtonLIstener(new UseListener(roundManager, gamePanel, audioManager ));

    }

    private void applyPickerListener(FullItemPicker.LabelType type, CustomLambdaExpression expLeft,
                                     CustomLambdaExpression expRight) {
        gamePanel.getPicker(type).addListenerToPicker(DoubleArrowPanel.Side.LEFT, expLeft);
        gamePanel.getPicker(type).addListenerToPicker(DoubleArrowPanel.Side.RIGHT, expRight);
    }
}
