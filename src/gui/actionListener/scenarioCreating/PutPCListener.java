package gui.actionListener.scenarioCreating;

import controllers.ControllerManager;
import controllers.scenario.NewScenarioController;
import controllers.utils.RedirectListener;
import game.board.Board;
import game.board.GameObject;
import game.board.RoundManager;
import game.board.ScenarioData;
import game.creature.NPC;
import game.creature.PlayerCharacter;
import game.filehandle.EntityManager;
import gui.factories.IOverallFactory;
import gui.views.objectViews.creationViews.CreatorGameView;
import gui.views.objectViews.itemsViews.ShowApplyCreatureView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PutPCListener implements ActionListener {

    ArrayList<ScenarioData> scenarioDataList;

    CreatorGameView creatorGameView;

    ShowApplyCreatureView showApplyCreatureView;
    ControllerManager controllerManager;
    NewScenarioController scenarioController;
    IOverallFactory factory;


    public PutPCListener(ArrayList<ScenarioData> scenarioDataList, CreatorGameView creatorGameView,
                         ShowApplyCreatureView showApplyCreatureView, ControllerManager controllerManager,
                         NewScenarioController scenarioController, IOverallFactory factory) {
        this.scenarioDataList = scenarioDataList;
        this.creatorGameView = creatorGameView;
        this.factory =factory;
        this.showApplyCreatureView = showApplyCreatureView;
        this.controllerManager = controllerManager;
        this.scenarioController = scenarioController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        PlayerCharacter dependPlayerCharacter =
                EntityManager.getInstance().getPlayerCharacterList().get(showApplyCreatureView.getClickedIndex());
        System.out.println(showApplyCreatureView.getClickedIndex());
        ScenarioData scenarioData = new ScenarioData();
        scenarioData.creature = dependPlayerCharacter;
        scenarioData.position = creatorGameView.getCreatorPanel().getCurrentClickedIndexes();
        scenarioDataList.add(scenarioData);
        creatorGameView.getCreatorPanel().applyNewCreatureOnPosition(dependPlayerCharacter.getObjectPathPicture(),
                creatorGameView.getCreatorPanel().getCurrentClickedIndexes());
//        controllerManager.changeController(scenarioController);
        var scenario = new NewScenarioController(factory,scenarioDataList);
        new RedirectListener(controllerManager, scenario).actionPerformed(e);
        creatorGameView.getCreatorPanel().disableOptionsPanel();

    }
}
