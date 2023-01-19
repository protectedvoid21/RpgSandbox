package gui.actionListener.creatureMenagment;

import game.board.Scenario;
import game.board.ScenarioData;
import game.creature.Monster;
import game.filehandle.FileManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SaveMonstersListener implements ActionListener {

    ArrayList<Monster> mockMonster;
    FileManager fileManager;

    public SaveMonstersListener(ArrayList<Monster> mockMonster, FileManager fileManager) {
        this.mockMonster = mockMonster;
        this.fileManager = fileManager;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        fileManager.writeToFile(mockMonster, Monster.class);
    }
}
