package gui.actionListener.scenarioCreating;

import game.board.Board;
import game.board.GameObject;
import game.board.RoundManager;
import game.board.ScenarioData;
import game.creature.Monster;
import game.creature.NPC;
import gui.views.objectViews.creationViews.CreatorGameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PutNPCListener implements ActionListener {

    ArrayList<ScenarioData> scenarioDataList;

    CreatorGameView creatorGameView;

    NPC dependNPC;

    public PutNPCListener(ArrayList<ScenarioData> scenarioDataList, CreatorGameView creatorGameView, NPC dependNPC) {
        this.scenarioDataList = scenarioDataList;
        this.creatorGameView = creatorGameView;
        this.dependNPC = dependNPC;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ScenarioData scenarioData = new ScenarioData();
        scenarioData.creature = dependNPC;
        scenarioData.position = creatorGameView.getCreatorPanel().getCurrentClickedIndexes();
        scenarioDataList.add(scenarioData);
        creatorGameView.getCreatorPanel().applyNewCreatureOnPosition(dependNPC.getObjectPathPicture(),creatorGameView.getCreatorPanel().getCurrentClickedIndexes());
    }
}
