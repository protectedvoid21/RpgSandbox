package gui.actionListener.basicActionsListener;

import game.creature.Character;
import gui.actionListener.ListenerBaseData;
import gui.actionListener.ValidatorItemListener;
import gui.actionListener.turnOffButtons;
import gui.actionListener.turnOffUseItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UseListener implements ActionListener {
    private final ListenerBaseData listenerBaseData;

    public UseListener(ListenerBaseData listenerBaseData) {
        this.listenerBaseData = listenerBaseData;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (listenerBaseData.roundManager.getGameObjectWithTurn().getCreature() instanceof Character obj) {
            if (obj.getInventory().getSelectedDisposableItem().isValid()) {
                if (obj.getInventory().getSelectedDisposableItem().getWorkOnEnemy()) {
                    new UseItemOnEnemyListener(listenerBaseData).actionPerformed(e);
                    turnOffUseItem.turnOff(listenerBaseData.roundManager, listenerBaseData.mainPanelGame);
                } else {
                    new UseItemOnYourselfListener(listenerBaseData).actionPerformed(e);
                    turnOffButtons.turnOff(listenerBaseData.roundManager,listenerBaseData.mainPanelGame,0,0);
                }
            }
            ValidatorItemListener.setValid(obj, listenerBaseData);
        }
    }
}
