package gui.actionListener.scenarioCreating;

import controllers.ControllerManager;
import controllers.scenario.NewScenarioController;
import controllers.utils.RedirectListener;
import game.board.*;
import game.creature.Monster;
import game.filehandle.EntityManager;
import gui.factories.IOverallFactory;
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
    IOverallFactory factory;

    public PutMonsterListener(ArrayList<ScenarioData> scenarioData, CreatorGameView creatorGameView,
                              ShowApplyCreatureView showApplyCreatureView, ControllerManager controllerManager,
                              NewScenarioController scenarioController, IOverallFactory factory)

    {
        this.scenarioController = scenarioController;
        this.scenarioDataList = scenarioData;
        this.creatorGameView = creatorGameView;
        this.showApplyCreatureView = showApplyCreatureView;
        this.controllerManager = controllerManager;
        this.factory =factory;
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
//        creatorGameView.getPanel().setVisible(true);
        var scenario = new NewScenarioController(factory);
        new RedirectListener(controllerManager, scenario).actionPerformed(e);
        creatorGameView.getCreatorPanel().disableOptionsPanel();
    }
}
