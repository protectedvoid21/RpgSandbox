package gui.actionListener.basicActionsListener;

import game.creature.Character;
import game.creature.Creature;
import gui.actionListener.ListenerBaseData;
import gui.actionListener.PathsArrayListGenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.interfaceWarhammer.StruggleAtributeEnum.ACTIONS_TO_DO;

public class UseItemOnYourselfListener implements ActionListener {
private final ListenerBaseData listenerBaseData;
    public UseItemOnYourselfListener(ListenerBaseData listenerBaseData) {
        this.listenerBaseData = listenerBaseData;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Creature you = listenerBaseData.roundManager.getGameObjectWithTurn().getCreature();
        if(you instanceof Character){
            ((Character) you).getInventory().getSelectedDisposableItem().use(you);
        }
        you.getStruggleStatistics().getAttribute(ACTIONS_TO_DO).decreaseValue(1);
        if (you instanceof Character character) {
            var array = PathsArrayListGenerator.generatePathsArrayList(character.getInventory().getDisposableItems());
            listenerBaseData.mainPanelGame.getItemsItemPicker().uploadData(array);
            listenerBaseData.mainPanelGame.getItemsItemPicker().setCurrentIndex(character.getInventory().getDisposableItems().
                    indexOf(character.getInventory().getSelectedDisposableItem()));

            listenerBaseData.mainPanelGame.getItemsItemPicker().addButtonLIstener(new UseListener(listenerBaseData));


        }

    }
}
