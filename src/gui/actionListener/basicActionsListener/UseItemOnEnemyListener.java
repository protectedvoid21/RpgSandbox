package gui.actionListener.basicActionsListener;

import game.board.RoundManager;
import game.creature.Character;
import game.creature.Creature;
import game.generals.Vector2;
import gui.actionListener.turnOffButtons;
import gui.views.gamePanel.MainPanelGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static game.interfaceWarhammer.StruggleAtributeEnum.*;
public class UseItemOnEnemyListener implements ActionListener {

    RoundManager roundManager;
    MainPanelGame mainPanelGame;

    public UseItemOnEnemyListener(RoundManager roundManager, MainPanelGame mainPanelGame) {
        this.roundManager = roundManager;
        this.mainPanelGame = mainPanelGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Vector2 point = mainPanelGame.getGamePanel().getCurrentClickedIndexes();
        Creature you = roundManager.getGameObjectWithTurn().getCreature();

        if(you instanceof Character){
            ((Character) you).getInventory().getSelectedDisposableItem().use(roundManager.getBoard().getPlace(point).getGameObject().getCreature());
        }

        you.getStruggleStatistics().getAttribute(ACTIONS_TO_DO).decreaseValue(1);
        turnOffButtons.turnOff(roundManager,mainPanelGame,2,0);

    }
}
