package gui.actionListener.creatureMenagment;

import game.creature.NPC;
import game.creature.PlayerCharacter;
import game.filehandle.FileManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SaveNPCListener implements ActionListener {

    ArrayList<NPC> mockNPC;
    FileManager fileManager;

    public SaveNPCListener(ArrayList<NPC> mockNPC, FileManager fileManager) {
        this.mockNPC = mockNPC;
        this.fileManager = fileManager;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        fileManager.writeToFile(mockNPC, NPC.class);
    }
}
