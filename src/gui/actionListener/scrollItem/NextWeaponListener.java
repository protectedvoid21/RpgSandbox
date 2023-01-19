package gui.actionListener.scrollItem;

import game.board.RoundManager;
import game.creature.Character;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextWeaponListener implements ActionListener {

    RoundManager roundManager;

    public NextWeaponListener(RoundManager roundManager){
        this.roundManager = roundManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (roundManager.getGameObjectWithTurn().getCreature() instanceof Character){
            ((Character) roundManager.getGameObjectWithTurn().getCreature()).getInventory().nextWeapon();
        }
    }
}
