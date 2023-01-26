package gui.actionListener.scenarioCreating;

import controllers.ControllerManager;
import controllers.scenario.NewScenarioController;
import controllers.utils.RedirectListener;
import game.board.ScenarioData;
import game.creature.Creature;
import game.creature.Monster;
import game.filehandle.EntityManager;
import gui.factories.IOverallFactory;
import gui.views.objectViews.creationViews.CreatorGameView;
import gui.views.objectViews.itemsViews.ShowApplyCreatureView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public abstract class PutListener implements ActionListener {
    private final ArrayList<ScenarioData> scenarioDataList;
    //
    private final CreatorGameView creatorGameView;
    protected final ShowApplyCreatureView showApplyCreatureView;
    private final ControllerManager controllerManager;
    private final IOverallFactory factory;

    public PutListener(ArrayList<ScenarioData> scenarioData, CreatorGameView creatorGameView,
                       ShowApplyCreatureView showApplyCreatureView, ControllerManager controllerManager,
                       IOverallFactory factory) {
        this.scenarioDataList = scenarioData;
        this.creatorGameView = creatorGameView;
        this.showApplyCreatureView = showApplyCreatureView;
        this.controllerManager = controllerManager;
        this.factory = factory;
    }

    protected abstract Creature getClickedCreature();

    @Override
    public void actionPerformed(ActionEvent e) {

//        Monster dependMonster =
//                EntityManager.getInstance().getMonsterList().get(showApplyCreatureView.getClickedIndex());
        var creature = getClickedCreature();

        ScenarioData scenarioData = new ScenarioData();
        scenarioData.creature = creature;
        scenarioData.position = creatorGameView.getCreatorPanel().getCurrentClickedIndexes();
        scenarioDataList.add(scenarioData);
        creatorGameView.getCreatorPanel().applyNewCreatureOnPosition(creature.getObjectPathPicture(),
                creatorGameView.getCreatorPanel().getCurrentClickedIndexes());
//        creatorGameView.getPanel().setVisible(true);
        var scenario = new NewScenarioController(factory, scenarioDataList);
        new RedirectListener(controllerManager, scenario).actionPerformed(e);
        creatorGameView.getCreatorPanel().disableOptionsPanel();
    }
}
