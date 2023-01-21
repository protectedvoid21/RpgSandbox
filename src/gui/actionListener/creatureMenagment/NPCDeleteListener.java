package gui.actionListener.creatureMenagment;

import game.creature.Monster;
import game.creature.NPC;
import game.filehandle.EntityManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NPCDeleteListener implements ActionListener {


    EntityManager entityManager;
   NPC dependNPC;

    public NPCDeleteListener( EntityManager entityManager, NPC dependNPC){
        this.entityManager = entityManager;
        this.dependNPC = dependNPC;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        entityManager.removeNPC(dependNPC);
    }
}
