package gui.actionListener.warhammer;

import game.board.RoundManager;
import game.creature.Creature;
import game.generals.Vector2;
import gui.actionListener.turnOffButtons;
import gui.views.gamePanel.MainPanelGame;
import gui.views.gamePanel.gamePanels.BaseGamePanel;
import gui.views.gamePanel.gamePanels.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static game.interfaceWarhammer.ActionsEnum.*;
import static game.interfaceWarhammer.AttributeEnum.ATTACKS;

public class BlockListener implements ActionListener {

    RoundManager roundManager;
    MainPanelGame mainPanelGame;

    public BlockListener(RoundManager roundManager, MainPanelGame mainPanelGame) {
        this.roundManager = roundManager;
        this.mainPanelGame = mainPanelGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Vector2 point = mainPanelGame.getGamePanel().getCurrentClickedIndexes();
        Creature you = roundManager.getGameObjectWithTurn().getCreature();
        roundManager.getActions().doAction(BLOCK, you);


        mainPanelGame.getGamePanel().applyDefendActionsContent(point);

        turnOffButtons.turnOff(roundManager,mainPanelGame,1,3);
    }
}