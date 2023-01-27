package gui.actionListener.basicActionsListener;

import game.board.RoundManager;

import game.creature.Character;
import gui.views.gamePanel.MainPanelGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.interfaceWarhammer.StruggleAtributeEnum.ACTIONS_TO_DO;

public class UseItem implements ActionListener {

    RoundManager roundManager;
    MainPanelGame mainPanelGame;

    public UseItem(RoundManager roundManager, MainPanelGame mainPanelGame) {
        this.roundManager = roundManager;
        this.mainPanelGame = mainPanelGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (roundManager.getGameObjectWithTurn().getCreature() instanceof Character) {
            if (((Character) roundManager.getGameObjectWithTurn().getCreature()).getInventory().getSelectedDisposableItem().isOnEnemy()) {
                mainPanelGame.getGamePanel().changeActiveOptionsPanel();
            } else {
                ((Character) roundManager.getGameObjectWithTurn().getCreature()).getInventory().getSelectedDisposableItem().use();
                roundManager.getGameObjectWithTurn().getCreature().getStruggleStatistics().getAttribute(ACTIONS_TO_DO).decreaseValue(1);
            }
        }
    }
}
