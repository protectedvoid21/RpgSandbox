package gui.actionListener.itemsMenagment;

import game.creature.Character;
import game.equipment.Item;
import game.filehandle.EntityManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemDeleteListener implements ActionListener {

    EntityManager entityManager;
    Item dependItem;

    public ItemDeleteListener(EntityManager entityManager, Item dependItem){
        this.entityManager = entityManager;
        this.dependItem = dependItem;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        entityManager.removeItem(dependItem);
    }
}
