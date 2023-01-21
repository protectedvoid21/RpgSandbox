package gui.actionListener.creatureMenagment;

import game.creature.Monster;
import game.creature.PlayerCharacter;
import game.filehandle.EntityManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PCDeleteListener implements ActionListener {

    EntityManager entityManager;
    PlayerCharacter dependPC;

    public PCDeleteListener( EntityManager entityManager, PlayerCharacter dependPC){
        this.entityManager = entityManager;
        this.dependPC = dependPC;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
       entityManager.removePC(dependPC);
    }
}
