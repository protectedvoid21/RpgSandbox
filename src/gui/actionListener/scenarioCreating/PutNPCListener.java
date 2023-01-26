package gui.actionListener.scenarioCreating;

import game.board.Board;
import game.board.GameObject;
import game.board.RoundManager;
import game.board.ScenarioData;
import game.creature.Monster;
import game.creature.NPC;
import game.filehandle.EntityManager;
import gui.views.objectViews.creationViews.CreatorGameView;
import gui.views.objectViews.itemsViews.ShowApplyCreatureView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PutNPCListener implements ActionListener {

    ArrayList<ScenarioData> scenarioDataList;

    CreatorGameView creatorGameView;

    ShowApplyCreatureView showApplyCreatureView;

    public PutNPCListener(ArrayList<ScenarioData> scenarioDataList, CreatorGameView creatorGameView, ShowApplyCreatureView showApplyCreatureView) {
        this.scenarioDataList = scenarioDataList;
        this.creatorGameView = creatorGameView;
        this.showApplyCreatureView = showApplyCreatureView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        NPC dependNPC = EntityManager.getInstance().getNPCList().get(showApplyCreatureView.getClickedIndex());
        ScenarioData scenarioData = new ScenarioData();
        scenarioData.creature = dependNPC;
        scenarioData.position = creatorGameView.getCreatorPanel().getCurrentClickedIndexes();
        scenarioDataList.add(scenarioData);
        creatorGameView.getCreatorPanel().applyNewCreatureOnPosition(dependNPC.getObjectPathPicture(),creatorGameView.getCreatorPanel().getCurrentClickedIndexes());
    }
}
