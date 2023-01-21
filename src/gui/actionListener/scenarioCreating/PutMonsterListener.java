package gui.actionListener.scenarioCreating;

import game.board.*;
import game.creature.Monster;
import gui.views.gamePanel.MainPanelGame;
import gui.views.objectViews.creationViews.CreatorGameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PutMonsterListener implements ActionListener {

    ArrayList<ScenarioData> scenarioDataList;

    CreatorGameView creatorGameView;
    Monster dependMonster;

    public PutMonsterListener(ArrayList<ScenarioData> scenarioData, CreatorGameView creatorGameView,Monster dependMonster) {
        this.scenarioDataList = scenarioData;
        this.creatorGameView = creatorGameView;
        this.dependMonster = dependMonster;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        ScenarioData scenarioData = new ScenarioData();
        scenarioData.creature = dependMonster;
        scenarioData.position = creatorGameView.getCreatorPanel().getCurrentClickedIndexes();
        scenarioDataList.add(scenarioData);
        creatorGameView.getCreatorPanel().applyNewCreatureOnPosition(dependMonster.getObjectPathPicture(),creatorGameView.getCreatorPanel().getCurrentClickedIndexes());
    }
}
