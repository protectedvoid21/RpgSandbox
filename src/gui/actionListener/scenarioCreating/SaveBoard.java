package gui.actionListener.scenarioCreating;

import game.board.Scenario;
import game.board.ScenarioData;
import game.filehandle.EntityManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SaveBoard implements ActionListener {

   private final ArrayList<ScenarioData> scenarioDataList;
    public SaveBoard(ArrayList<ScenarioData> scenarioData) {
        this.scenarioDataList = scenarioData;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        EntityManager.getInstance().addScenario(new Scenario(10, 10, scenarioDataList));
        EntityManager.getInstance().saveAllEntities();
    }
}
