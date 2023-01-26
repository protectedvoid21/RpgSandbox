package gui.actionListener.warhammerActions;

import game.board.RoundManager;
import game.creature.Creature;
import game.generals.Vector2;
import gui.actionListener.turnOffButtons;
import gui.views.gamePanel.MainPanelGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static game.interfaceWarhammer.ActionsEnum.*;

public class BlockListener implements ActionListener {

    RoundManager roundManager;
    MainPanelGame mainPanelGame;

    public BlockListener(RoundManager roundManager, MainPanelGame mainPanelGame) {
        this.roundManager = roundManager;
        this.mainPanelGame = mainPanelGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Creature you = roundManager.getGameObjectWithTurn().getCreature();
        Vector2 point = roundManager.getGameObjectWithTurnPosition();
        roundManager.getActions().doAction(DEFENSE_STAND, you);
        System.out.println(point);
        mainPanelGame.getGamePanel().applyDefendActionsContent(point);

        turnOffButtons.turnOff(roundManager,mainPanelGame,1,1);
    }
}