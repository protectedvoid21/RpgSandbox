package gui.actionListener.scenarioCreating;

import controllers.ControllerManager;
import controllers.scenario.NewScenarioController;
import game.board.*;
import game.creature.Monster;
import game.filehandle.EntityManager;
import gui.views.gamePanel.MainPanelGame;
import gui.views.objectViews.creationViews.CreatorGameView;
import gui.views.objectViews.itemsViews.ShowApplyCreatureView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PutMonsterListener implements ActionListener {

    ArrayList<ScenarioData> scenarioDataList;

    CreatorGameView creatorGameView;
    ShowApplyCreatureView showApplyCreatureView;
    ControllerManager controllerManager;
    NewScenarioController scenarioController;

    public PutMonsterListener(ArrayList<ScenarioData> scenarioData, CreatorGameView creatorGameView,
                              ShowApplyCreatureView showApplyCreatureView, ControllerManager controllerManager,
                              NewScenarioController scenarioController)

    {
        this.scenarioController = scenarioController;
        this.scenarioDataList = scenarioData;
        this.creatorGameView = creatorGameView;
        this.showApplyCreatureView = showApplyCreatureView;
        this.controllerManager = controllerManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Monster dependMonster =
                EntityManager.getInstance().getMonsterList().get(showApplyCreatureView.getClickedIndex());

        ScenarioData scenarioData = new ScenarioData();
        scenarioData.creature = dependMonster;
        scenarioData.position = creatorGameView.getCreatorPanel().getCurrentClickedIndexes();
        scenarioDataList.add(scenarioData);
        creatorGameView.getCreatorPanel().applyNewCreatureOnPosition(dependMonster.getObjectPathPicture(),
                creatorGameView.getCreatorPanel().getCurrentClickedIndexes());
        controllerManager.changeController(scenarioController);
    }
}
