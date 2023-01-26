package gui.actionListener.scenarioCreating;

import controllers.ControllerManager;
import controllers.scenario.NewScenarioController;
import controllers.utils.RedirectListener;
import game.board.Board;
import game.board.GameObject;
import game.board.RoundManager;
import game.board.ScenarioData;
import game.creature.Monster;
import game.creature.NPC;
import game.filehandle.EntityManager;
import gui.factories.IOverallFactory;
import gui.views.objectViews.creationViews.CreatorGameView;
import gui.views.objectViews.itemsViews.ShowApplyCreatureView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PutNPCListener implements ActionListener {

    ArrayList<ScenarioData> scenarioDataList;

    CreatorGameView creatorGameView;

    ShowApplyCreatureView showApplyCreatureView;
    ControllerManager controllerManager;
    NewScenarioController scenarioController;
    IOverallFactory factory;

    public PutNPCListener(ArrayList<ScenarioData> scenarioDataList, CreatorGameView creatorGameView,
                          ShowApplyCreatureView showApplyCreatureView, ControllerManager controllerManager,
                          NewScenarioController scenarioController, IOverallFactory factory) {
        this.scenarioDataList = scenarioDataList;
        this.creatorGameView = creatorGameView;
        this.showApplyCreatureView = showApplyCreatureView;
        this.controllerManager = controllerManager;
        this.scenarioController = scenarioController;
        this.factory =factory;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        NPC dependNPC = EntityManager.getInstance().getNPCList().get(showApplyCreatureView.getClickedIndex());
        ScenarioData scenarioData = new ScenarioData();
        scenarioData.creature = dependNPC;
        scenarioData.position = creatorGameView.getCreatorPanel().getCurrentClickedIndexes();
        scenarioDataList.add(scenarioData);
        System.out.println(creatorGameView.getCreatorPanel().getCurrentClickedIndexes().x);
        creatorGameView.getCreatorPanel().applyNewCreatureOnPosition(dependNPC.getObjectPathPicture(),
                creatorGameView.getCreatorPanel().getCurrentClickedIndexes());
//        controllerManager.changeController(scenarioController);
        var scenario = new NewScenarioController(factory,scenarioDataList);
        new RedirectListener(controllerManager, scenario).actionPerformed(e);
        creatorGameView.getCreatorPanel().disableOptionsPanel();

    }
}
