package gui.actionListener.itemsMenagment;

import game.creature.Character;
import game.equipment.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemDeleteListener implements ActionListener {

    Character mockCharacter;
    Item dependItem;

    public ItemDeleteListener(Character mockCharacter, Item dependItem){
        this.mockCharacter = mockCharacter;
        this.dependItem = dependItem;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        mockCharacter.getInventory().removeItem(dependItem);
    }
}
