package gui.actionListener.basicActionsListener;

import game.board.RoundManager;
import game.creature.Character;
import game.creature.Creature;
import gui.views.gamePanel.MainPanelGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static game.interfaceWarhammer.StruggleAtributeEnum.ACTIONS_TO_DO;

public class UseListener implements ActionListener {
    RoundManager roundManager;
    MainPanelGame mainPanelGame;

    public UseListener(RoundManager roundManager, MainPanelGame mainPanelGame) {
        this.roundManager = roundManager;
        this.mainPanelGame = mainPanelGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (roundManager.getGameObjectWithTurn().getCreature() instanceof Character) {
            var obj = (Character) roundManager.getGameObjectWithTurn().getCreature();
            if (obj.getInventory().getSelectedDisposableItem().getWorkOnEnemy()) {
                new UseItemOnEnemyListener(roundManager, mainPanelGame).actionPerformed(e);
            } else {
                new UseItemOnYourselfListener(roundManager, mainPanelGame).actionPerformed(e);
            }
        }

    }
}
