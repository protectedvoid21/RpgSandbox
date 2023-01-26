package gui.actionListener.basicActionsListener;

import game.board.RoundManager;
import game.creature.Character;
import game.creature.Creature;
import gui.actionListener.turnOffButtons;
import gui.views.gamePanel.MainPanelGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static game.interfaceWarhammer.StruggleAtributeEnum.ACTIONS_TO_DO;

public class UseItemOnYourselfListener implements ActionListener {

    RoundManager roundManager;
    MainPanelGame mainPanelGame;

    public UseItemOnYourselfListener(RoundManager roundManager, MainPanelGame mainPanelGame) {
        this.roundManager = roundManager;
        this.mainPanelGame = mainPanelGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Creature you = roundManager.getGameObjectWithTurn().getCreature();

        if(you instanceof Character){
            ((Character) you).getInventory().getSelectedDisposableItem().use(you);
        }


        you.getStruggleStatistics().getAttribute(ACTIONS_TO_DO).decreaseValue(1);
        if (roundManager.getGameObjectWithTurn().getCreature() instanceof Character) {
            var character = (Character) roundManager.getGameObjectWithTurn().getCreature();
            var array = new ArrayList<String>();
            for (var item : character.getInventory().getDisposableItems()) {
                if(item.isValid())
                array.add(item.getItemPathPicture());
            }
            mainPanelGame.getItemsItemPicker().uploadData(array);
            mainPanelGame.getItemsItemPicker().setCurrentIndex(character.getInventory().getDisposableItems().
                    indexOf(character.getInventory().getSelectedDisposableItem()));

            mainPanelGame.getItemsItemPicker().addButtonLIstener(new UseListener(roundManager, mainPanelGame));


        }

    }
}
