package gui.actionListener.warhammer;

import game.board.RoundManager;
import game.generals.Vector2;
import gui.actionListener.turnOffButtons;
import gui.views.Point;
import gui.views.gamePanel.MainPanelGame;
import gui.views.gamePanel.gamePanels.BaseGamePanel;
import gui.views.gamePanel.gamePanels.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.interfaceWarhammer.ActionsEnum.*;

public class AttackListener implements ActionListener {

    RoundManager roundManager;
    MainPanelGame mainPanelGame;
    public AttackListener(RoundManager roundManager, MainPanelGame mainPanelGame) {
        this.roundManager = roundManager;
        this.mainPanelGame = mainPanelGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Point point = mainPanelGame.getGamePanel().getCurrentClickedIndexes();
        roundManager.getActions().doAction(ATTACK,roundManager.getGameObjectWithTurn().getCreature(),roundManager.getBoard().getPlace(new Vector2(point.x, point.y)).getGameObject().getCreature());
        mainPanelGame.getGamePanel().applyAttackActionsContent(point);
        turnOffButtons.turnOff(roundManager,mainPanelGame,0,2);

    }
}
