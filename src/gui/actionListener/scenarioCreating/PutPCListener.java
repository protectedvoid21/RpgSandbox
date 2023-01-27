package gui.actionListener.scenarioCreating;

import controllers.ControllerManager;
import game.board.ScenarioData;
import game.creature.Creature;
import game.filehandle.EntityManager;
import gui.factories.IOverallFactory;
import gui.views.objectViews.creationViews.CreatorGameView;
import gui.views.objectViews.itemsViews.ShowApplyCreatureView;

import java.util.ArrayList;

public class PutPCListener extends PutListener {
    public PutPCListener(ArrayList<ScenarioData> scenarioData, CreatorGameView creatorGameView,
                         ShowApplyCreatureView showApplyCreatureView, ControllerManager controllerManager,
                         IOverallFactory factory) {
        super(scenarioData, creatorGameView, showApplyCreatureView, controllerManager, factory);
    }

    @Override
    protected Creature getClickedCreature() {
        return EntityManager.getInstance().getPlayerCharacterList().get(showApplyCreatureView.getClickedIndex());
    }
}
