package gui.actionListener.scenarioCreating;

import controllers.ControllerManager;
import controllers.scenario.NewScenarioController;
import controllers.utils.RedirectListener;
import game.board.*;
import game.creature.Creature;
import game.creature.Monster;
import game.filehandle.EntityManager;
import gui.factories.IOverallFactory;
import gui.views.gamePanel.MainPanelGame;
import gui.views.objectViews.creationViews.CreatorGameView;
import gui.views.objectViews.itemsViews.ShowApplyCreatureView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PutMonsterListener extends PutListener {
    public PutMonsterListener(ArrayList<ScenarioData> scenarioData, CreatorGameView creatorGameView,
                              ShowApplyCreatureView showApplyCreatureView, ControllerManager controllerManager,
                              IOverallFactory factory) {
        super(scenarioData, creatorGameView, showApplyCreatureView, controllerManager, factory);
    }

    @Override
    protected Creature getClickedCreature() {
        return EntityManager.getInstance().getMonsterList().get(showApplyCreatureView.getClickedIndex());
    }

//    private final ArrayList<ScenarioData> scenarioDataList;
////
//    private final CreatorGameView creatorGameView;
//    private final ShowApplyCreatureView showApplyCreatureView;
//    private final ControllerManager controllerManager;
//    private final IOverallFactory factory;

//    public PutMonsterListener(ArrayList<ScenarioData> scenarioData, CreatorGameView creatorGameView,
//                              ShowApplyCreatureView showApplyCreatureView, ControllerManager controllerManager,
//                              IOverallFactory factory)
//
//    {
//        this.scenarioDataList = scenarioData;
//        this.creatorGameView = creatorGameView;
//        this.showApplyCreatureView = showApplyCreatureView;
//        this.controllerManager = controllerManager;
//        this.factory =factory;
}
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//        Monster dependMonster =
//                EntityManager.getInstance().getMonsterList().get(showApplyCreatureView.getClickedIndex());
//
//        ScenarioData scenarioData = new ScenarioData();
//        scenarioData.creature = dependMonster;
//        scenarioData.position = creatorGameView.getCreatorPanel().getCurrentClickedIndexes();
//        scenarioDataList.add(scenarioData);
//        creatorGameView.getCreatorPanel().applyNewCreatureOnPosition(dependMonster.getObjectPathPicture(),
//                creatorGameView.getCreatorPanel().getCurrentClickedIndexes());
////        creatorGameView.getPanel().setVisible(true);
//        var scenario = new NewScenarioController(factory,scenarioDataList);
//        new RedirectListener(controllerManager, scenario).actionPerformed(e);
//        creatorGameView.getCreatorPanel().disableOptionsPanel();
//    }

