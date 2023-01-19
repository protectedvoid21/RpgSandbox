package gui.actionListener.scenarioCreating;

import game.board.Board;
import game.board.Scenario;
import game.board.ScenarioData;
import game.filehandle.FileManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SaveBoard implements ActionListener {

    ArrayList<ScenarioData> scenarioDataList;
    ArrayList<Scenario> mockScenario;
    FileManager fileManager;

    public SaveBoard (ArrayList<ScenarioData> scenarioData,ArrayList<Scenario> mockScenario, FileManager fileManager){
        this.scenarioDataList = scenarioData;
        this.mockScenario = mockScenario;
        this.fileManager = fileManager;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        mockScenario.add(new Scenario(10,10, scenarioDataList));
        fileManager.writeToFile(mockScenario,Scenario.class);
    }
}
