package gui.actionListener;

import game.board.RoundManager;
import game.creature.Creature;
import game.generals.Vector2;
import gui.views.gamePanel.MainPanelGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class actionListener implements ActionListener {

    RoundManager roundManager;
    MainPanelGame mainPanelGame;

    public actionListener(RoundManager roundManager, MainPanelGame mainPanelGame) {
        this.roundManager = roundManager;
        this.mainPanelGame = mainPanelGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Vector2 point = mainPanelGame.getGamePanel().getCurrentClickedIndexes();
        Creature you = roundManager.getGameObjectWithTurn().getCreature();

        // Tutaj wykonuje akcje



        turnOffButtons.turnOff(roundManager,mainPanelGame,1,0);
        }
    }
