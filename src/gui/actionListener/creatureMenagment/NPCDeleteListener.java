package gui.actionListener.creatureMenagment;

import game.creature.Monster;
import game.creature.NPC;
import game.filehandle.EntityManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NPCDeleteListener implements ActionListener {



   NPC dependNPC;

    public NPCDeleteListener( NPC dependNPC){

        this.dependNPC = dependNPC;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        EntityManager.getInstance().removeCreature(dependNPC);
    }
}
