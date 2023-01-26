package gui.actionListener.basicActionsListener;

import game.board.RoundManager;

import game.creature.Character;
import game.creature.Creature;
import gui.actionListener.warhammerActions.turnOffUseItem;
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


        Creature you = roundManager.getGameObjectWithTurn().getCreature();

        if(you instanceof Character){
            if(!(((Character) you).getInventory().getSelectedDisposableItem().isOnEnemy()== 0)) {
                ((Character) you).getInventory().getSelectedDisposableItem().use(you);
                you.getStruggleStatistics().getAttribute(ACTIONS_TO_DO).decreaseValue(1);
            } else {
                mainPanelGame.getGamePanel().changeActiveOptionsPanel();
                turnOffUseItem.turnOff(roundManager,mainPanelGame);
            }

        }






    }
}
