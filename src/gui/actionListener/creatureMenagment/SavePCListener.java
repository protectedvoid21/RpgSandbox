package gui.actionListener.creatureMenagment;

import game.creature.Monster;
import game.creature.PlayerCharacter;
import game.filehandle.FileManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SavePCListener implements ActionListener {

    ArrayList<PlayerCharacter> mockPC;
    FileManager fileManager;

    public SavePCListener(ArrayList<PlayerCharacter> mockPC, FileManager fileManager) {
        this.mockPC = mockPC;
        this.fileManager = fileManager;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        fileManager.writeToFile(mockPC, PlayerCharacter.class);
    }
}
