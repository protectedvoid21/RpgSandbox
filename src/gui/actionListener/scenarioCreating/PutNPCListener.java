package gui.actionListener.scenarioCreating;

import controllers.ControllerManager;
import controllers.scenario.NewScenarioController;
import controllers.utils.RedirectListener;
import game.board.Board;
import game.board.GameObject;
import game.board.RoundManager;
import game.board.ScenarioData;
import game.creature.Creature;
import game.creature.Monster;
import game.creature.NPC;
import game.filehandle.EntityManager;
import gui.factories.IOverallFactory;
import gui.views.objectViews.creationViews.CreatorGameView;
import gui.views.objectViews.itemsViews.ShowApplyCreatureView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PutNPCListener extends PutListener {
    public PutNPCListener(ArrayList<ScenarioData> scenarioData, CreatorGameView creatorGameView,
                          ShowApplyCreatureView showApplyCreatureView, ControllerManager controllerManager,
                          IOverallFactory factory) {
        super(scenarioData, creatorGameView, showApplyCreatureView, controllerManager, factory);
    }

    @Override
    protected Creature getClickedCreature() {
        return EntityManager.getInstance().getNPCList().get(showApplyCreatureView.getClickedIndex());
    }
}
