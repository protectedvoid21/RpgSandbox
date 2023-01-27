package gui.actionListener.basicActionsListener;

import game.creature.Character;
import game.creature.Creature;
import game.generals.Vector2;
import gui.actionListener.ListenerBaseData;
import gui.actionListener.PathsArrayListGenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.interfaceWarhammer.StruggleAtributeEnum.ACTIONS_TO_DO;

public class UseItemOnEnemyListener implements ActionListener {
    private final ListenerBaseData listenerBaseData;

    public UseItemOnEnemyListener(ListenerBaseData listenerBaseData) {
        this.listenerBaseData = listenerBaseData;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Vector2 point = listenerBaseData.mainPanelGame.getGamePanel().getCurrentClickedIndexes();
        Creature you = listenerBaseData.roundManager.getGameObjectWithTurn().getCreature();

        if (you instanceof Character) {
            ((Character) you).getInventory().getSelectedDisposableItem().use(listenerBaseData.roundManager.getBoard().getPlace(point).getGameObject().getCreature());
        }

        you.getStruggleStatistics().getAttribute(ACTIONS_TO_DO).decreaseValue(1);
        listenerBaseData.mainPanelGame.getGamePanel().changeActiveOptionsPanel();
        if (you instanceof Character character) {
            var array = PathsArrayListGenerator.generatePathsArrayList(character.getInventory().getDisposableItems());
            listenerBaseData.mainPanelGame.getItemsItemPicker().uploadData(array);
            listenerBaseData.mainPanelGame.getItemsItemPicker().setCurrentIndex(character.getInventory().getDisposableItems().
                    indexOf(character.getInventory().getSelectedDisposableItem()));
            listenerBaseData.mainPanelGame.getItemsItemPicker().addButtonLIstener(new UseListener(listenerBaseData));

        }

    }

}
