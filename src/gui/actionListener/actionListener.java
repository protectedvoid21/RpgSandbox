package gui.actionListener;

import game.board.RoundManager;
import game.creature.Creature;
import game.generals.Vector2;
import game.interfaceWarhammer.ActionsEnum;
import gui.views.Point;
import gui.views.gamePanel.MainPanelGame;
import gui.views.gamePanel.gamePanels.BaseGamePanel;
import gui.views.gamePanel.gamePanels.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static game.interfaceWarhammer.ActionsEnum.*;
import static game.interfaceWarhammer.StruggleAtributeEnum.*;
public class actionListener implements ActionListener {

    RoundManager roundManager;
    MainPanelGame mainPanelGame;

    public actionListener(RoundManager roundManager, MainPanelGame mainPanelGame) {
        this.roundManager = roundManager;
        this.mainPanelGame = mainPanelGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Point point = mainPanelGame.getGamePanel().getCurrentClickedIndexes();
        Creature you = roundManager.getGameObjectWithTurn().getCreature();

        // Tutaj wykonuje akcje



        turnOffButtons.turnOff(roundManager,mainPanelGame,1,0);
        }
    }
