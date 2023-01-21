package gui.actionListener.creatureMenagment;

import game.creature.Monster;
import game.creature.PlayerCharacter;
import game.filehandle.EntityManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PCDeleteListener implements ActionListener {


    PlayerCharacter dependPC;

    public PCDeleteListener( PlayerCharacter dependPC){
        this.dependPC = dependPC;
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        EntityManager.getInstance().removeCreature(dependPC);
    }
}
