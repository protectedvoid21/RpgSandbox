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
        if (you instanceof Character character) {
            character.getInventory().getSelectedDisposableItem().use(you);
            listenerBaseData.audioManager.setAudio(character.getInventory().getSelectedDisposableItem().enumAudio);
            you.getStruggleStatistics().getAttribute(ACTIONS_TO_DO).decreaseValue(1);
            var array = PathsArrayListGenerator.generatePathsArrayList(character.getInventory().getDisposableItems());
            listenerBaseData.mainPanelGame.getItemsItemPicker().uploadData(array);
            listenerBaseData.mainPanelGame.getItemsItemPicker().setCurrentIndex(character.getInventory().getDisposableItems().
                    indexOf(character.getInventory().getSelectedDisposableItem()));

        }
    }
}
