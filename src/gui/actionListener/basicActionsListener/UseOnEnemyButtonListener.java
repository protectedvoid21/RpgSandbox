package gui.actionListener.basicActionsListener;

import game.creature.Character;
import game.creature.Creature;
import game.generals.Vector2;
import gui.actionListener.ListenerBaseData;
import gui.actionListener.turnOffButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UseOnEnemyButtonListener implements ActionListener {
    private final ListenerBaseData listenerBaseData;

    public UseOnEnemyButtonListener(ListenerBaseData listenerBaseData) {
        this.listenerBaseData = listenerBaseData;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Vector2 point = listenerBaseData.mainPanelGame.getGamePanel().getCurrentClickedIndexes();
        listenerBaseData.isSetItemMode = false;
        listenerBaseData.mainPanelGame.resizeGamePanel(true);
        listenerBaseData.mainPanelGame.getGamePanel().changeActiveOptionsPanel();
        if (listenerBaseData.roundManager.getGameObjectWithTurn().getCreature() instanceof Character character) {
            listenerBaseData.audioManager.setAudio(character.getInventory().getSelectedDisposableItem().enumAudio);
            character.getInventory().getSelectedDisposableItem().use(listenerBaseData.roundManager.getBoard().getPlace(point).getGameObject().getCreature());
        }
        turnOffButtons.turnOff(listenerBaseData.roundManager, listenerBaseData.mainPanelGame, 0, 0);
    }
}
