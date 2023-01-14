package gui.actionListener.warhammer;

import game.board.RoundManager;
import game.creature.Creature;
import gui.actionListener.turnOffButtons;
import gui.views.Point;
import gui.views.gamePanel.MainPanelGame;
import gui.views.gamePanel.gamePanels.BaseGamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static game.interfaceWarhammer.ActionsEnum.*;

public class AimingListener implements ActionListener {

    RoundManager roundManager;
    MainPanelGame mainPanelGame;

    public AimingListener(RoundManager roundManager, MainPanelGame mainPanelGame) {
        this.roundManager = roundManager;
        this.mainPanelGame = mainPanelGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Point point = mainPanelGame.getGamePanel().getCurrentClickedIndexes();
        Creature you = roundManager.getGameObjectWithTurn().getCreature();
        roundManager.getActions().doAction(AIMING,you);
        turnOffButtons.turnOff(roundManager,mainPanelGame,1,0);
    }
}
