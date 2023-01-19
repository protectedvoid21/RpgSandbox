package gui.actionListener.creatureMenagment;

import game.creature.Monster;
import game.creature.NPC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NPCDeleteListener implements ActionListener {

    ArrayList<NPC> mockNPC;
   NPC dependNPC;

    public NPCDeleteListener( ArrayList<Monster> mockMonster, NPC dependNPC){
        this.mockNPC = mockNPC;
        this.dependNPC = dependNPC;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        mockNPC.remove(dependNPC);
    }
}
