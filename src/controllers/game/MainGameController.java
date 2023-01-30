package controllers.game;

import controllers.Controller;
import controllers.ControllerManager;
import controllers.MenuController;
import controllers.audio.CustomAudioManager;
import game.board.Board;
import game.board.RoundManager;
import game.board.Scenario;
import game.creature.Character;
import game.filehandle.EntityManager;
import game.generals.Vector2;
import game.interfaceWarhammer.StruggleAtributeEnum;
import gui.actionListener.ListenerBaseData;
import gui.actionListener.basicActionsListener.EndTurnListener;
import gui.actionListener.basicActionsListener.MoveListener;
import gui.actionListener.basicActionsListener.UseListener;
import gui.actionListener.basicActionsListener.UseOnEnemyButtonListener;
import gui.actionListener.scrollItem.*;
import gui.actionListener.turnOffButtons;
import gui.actionListener.turnOffUseItem;
import gui.actionListener.warhammerActions.*;
import gui.card.DoubleArrowPanel;
import gui.factories.IOverallFactory;
import gui.utils.AbstractConverter;
import gui.views.pickers.CustomLambdaExpression;
import gui.views.pickers.FullItemPicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static game.interfaceWarhammer.ActionsEnum.DEFENSE_STAND;

public class MainGameController extends Controller {
    private final ListenerBaseData listenerBaseData;

    public MainGameController(Scenario scenario) {
        this.listenerBaseData = new ListenerBaseData();
        listenerBaseData.roundManager = new RoundManager(new Board(scenario));
    }

    @Override
    public void initialize(ControllerManager controllerManager, JFrame mainFrame, AbstractConverter converter,
                           CustomAudioManager audioManager) {
        super.initialize(controllerManager, mainFrame, converter, audioManager);
        listenerBaseData.audioManager = audioManager;
    }

    private void startGame() {
        listenerBaseData.mainPanelGame.getGamePanel().applyContent(listenerBaseData.roundManager.boardToList());
        listenerBaseData.mainPanelGame.getGamePanel().colorButtons(listenerBaseData.roundManager.getGameObjectWithTurnPosition());
        turnOffButtons.turnOff(listenerBaseData.roundManager, listenerBaseData.mainPanelGame, 2, 0);
    }

    private Vector2 getclickedIndexes() {
        return listenerBaseData.mainPanelGame.getGamePanel().getCurrentClickedIndexes();
    }

    private GameCardController createGameCardController() {
        return new GameCardController(!getclickedIndexes().isOutOfRange(10, 10) ?
                listenerBaseData.roundManager.getBoard().getPlace(getclickedIndexes()).getGameObject().getCreature()
                : null, this);
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
        listenerBaseData.mainPanelGame = overallFactory.createMainPanelGame();

        var gamePanel = listenerBaseData.mainPanelGame;

        gamePanel.getExitButton().addActionListener(
                new ExitListener());
        gamePanel.getNextPlayerButton().addActionListener(new EndTurnListener(listenerBaseData));

        startGame();
        var z = EntityManager.getInstance().getPlayerCharacterList();
        gamePanel.getGamePanel().addOptionsListener(0, new MoveListener(listenerBaseData));
        gamePanel.getGamePanel().addOptionsListener(1, new ClickGameCardListener());
        gamePanel.getGamePanel().addOptionsListener(2, new AttackListener(listenerBaseData));
        gamePanel.getGamePanel().addOptionsListener(3, new CarefullListener(listenerBaseData));
        gamePanel.getGamePanel().addOptionsListener(4, new MultipleAttackListener(listenerBaseData));
        gamePanel.getGamePanel().changeActiveOptionsPanel();
        gamePanel.getGamePanel().addOptionsListener(1, new ClickGameCardListener());
        gamePanel.getGamePanel().addOptionsListener(0, new UseOnEnemyButtonListener(listenerBaseData));
        if (!listenerBaseData.isSetItemMode) {
            gamePanel.getGamePanel().changeActiveOptionsPanel();
        } else {
            turnOffUseItem.turnOff(listenerBaseData.roundManager, listenerBaseData.mainPanelGame);
        }
        listenerBaseData.mainPanelGame.resizeGamePanel(!listenerBaseData.isSetItemMode);

        int j = 0;
        for (var list : Arrays.asList(new AimingListener(listenerBaseData), new BlockListener(listenerBaseData),
                new DefenseStandListener(listenerBaseData))) {
            gamePanel.getActivityOptionsPanel().addOptionsPanelCommand(j++, list);
        }
        var roundManager = listenerBaseData.roundManager;
        applyPickerListener(FullItemPicker.LabelType.WEAPON, new PreviousWeaponListener(roundManager),
                new NextWeaponListener(roundManager));
        applyPickerListener(FullItemPicker.LabelType.ARMOR, new PreviousArmorListener(roundManager),
                new NextArmorListener(roundManager));
        applyPickerListener(FullItemPicker.LabelType.MOUNT, new PreviousMountListener(roundManager),
                new NextMountListener(roundManager));

        mainFrame.add(gamePanel.getPanel());

        gamePanel.getItemsItemPicker().addListenerToPicker(DoubleArrowPanel.Side.LEFT,
                new PreviousActiveListener(listenerBaseData));
        gamePanel.getItemsItemPicker().addListenerToPicker(DoubleArrowPanel.Side.RIGHT,
                new NextActiveListener(listenerBaseData));

        gamePanel.getItemsItemPicker().addButtonLIstener(new UseListener(listenerBaseData));

        for (var c : listenerBaseData.roundManager.getBoard().getAllGameObjects()) {
            var creature = c.getCreature();
            if (creature.getStruggleStatistics().getAttribute(StruggleAtributeEnum.IS_BLOKING).getValue() > 0) {
                listenerBaseData.mainPanelGame.getGamePanel().applyDefendActionsContent(roundManager.getGameObjectPositionFromCreature(creature));
            }
        }
    }

    private void applyPickerListener(FullItemPicker.LabelType type, CustomLambdaExpression expLeft,
                                     CustomLambdaExpression expRight) {
        listenerBaseData.mainPanelGame.getPicker(type).addListenerToPicker(DoubleArrowPanel.Side.LEFT, expLeft);
        listenerBaseData.mainPanelGame.getPicker(type).addListenerToPicker(DoubleArrowPanel.Side.RIGHT, expRight);
    }
}
