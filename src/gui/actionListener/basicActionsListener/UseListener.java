package gui.actionListener.basicActionsListener;

import game.creature.Character;
import gui.actionListener.ListenerBaseData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UseListener implements ActionListener {
    private ListenerBaseData listenerBaseData;
    public UseListener(ListenerBaseData listenerBaseData) {
        this.listenerBaseData = listenerBaseData;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (listenerBaseData.roundManager.getGameObjectWithTurn().getCreature() instanceof Character obj) {
            if (obj.getInventory().getSelectedDisposableItem().getWorkOnEnemy()) {
                new UseItemOnEnemyListener(listenerBaseData).actionPerformed(e);
            } else {
                new UseItemOnYourselfListener(listenerBaseData).actionPerformed(e);
            }
            listenerBaseData.audioManager.setAudio(obj.getInventory().getSelectedDisposableItem().enumAudio);
        }

    }
}
