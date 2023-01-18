package gui.actionListener.warhammer;

import game.board.RoundManager;
import game.creature.Creature;
import game.generals.Vector2;
import game.interfaceWarhammer.struggleWarhammer.ChangeEquipment;
import gui.views.gamePanel.MainPanelGame;
import gui.views.gamePanel.gamePanels.BaseGamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static game.interfaceWarhammer.ActionsEnum.*;
public class ChangeEquipmentListener implements ActionListener {

    RoundManager roundManager;
    MainPanelGame mainPanelGame;

    public ChangeEquipmentListener(RoundManager roundManager, MainPanelGame mainPanelGame) {
        this.roundManager = roundManager;
        this.mainPanelGame = mainPanelGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Vector2 point = mainPanelGame.getGamePanel().getCurrentClickedIndexes();
        Creature you = roundManager.getGameObjectWithTurn().getCreature();

    }
}
