package gui.actionListener.creatureMenagment;

import game.creature.Monster;
import game.filehandle.EntityManager;
import game.filehandle.FileManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SaveCreatures implements ActionListener {



    public SaveCreatures() {
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        EntityManager.getInstance().saveAllEntities();
    }
}
