package gui.actionListener.warhammer;

import game.board.RoundManager;
import game.creature.Creature;
import game.interfaces.ITurnOffButtons;
import gui.actionListener.turnOffButtons;
import gui.views.gamePanel.MainPanelGame;
import gui.views.gamePanel.gamePanels.BaseGamePanel;
import gui.views.gamePanel.gamePanels.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.interfaceWarhammer.ActionsEnum.BLOCK;
import static game.interfaceWarhammer.ActionsEnum.DEFENSE_STAND;

public class DefenseStandListener implements ActionListener {

    RoundManager roundManager;
    MainPanelGame mainPanelGame;

    public DefenseStandListener(RoundManager roundManager, MainPanelGame mainPanelGame) {
        this.roundManager = roundManager;
        this.mainPanelGame = mainPanelGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Creature you = roundManager.getGameObjectWithTurn().getCreature();
        roundManager.getActions().doAction(DEFENSE_STAND, you);
        mainPanelGame.getGamePanel().applyDefendActionsContent(mainPanelGame.getGamePanel().getCurrentClickedIndexes());

        turnOffButtons.turnOff(roundManager,mainPanelGame,1,1);

    }
}