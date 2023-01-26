package controllers.scenario;

import controllers.Controller;
import controllers.creatures.CreatureListController;
import controllers.creatures.CreatureShowController;
import controllers.utils.CreatureType;
import controllers.utils.RedirectListener;
import game.board.ScenarioData;
import game.creature.Creature;
import game.filehandle.EntityManager;
import gui.actionListener.scenarioCreating.PutMonsterListener;
import gui.actionListener.scenarioCreating.PutNPCListener;
import gui.actionListener.scenarioCreating.PutPCListener;
import gui.card.fullCards.abstractCards.Card;
import gui.card.fullCards.specificCards.BasicCard;
import gui.factories.IOverallFactory;
import gui.views.objectViews.AllObjectsView;
import gui.views.objectViews.creationViews.CreatorGameView;
import gui.views.objectViews.itemsViews.ShowApplyCreatureView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SetCreatureController extends Controller {
    private NewScenarioController scenarioController;
    private CreatureType creatureType;
    private ArrayList<ScenarioData> data = new ArrayList<>();
    private CreatorGameView mainview;

    public SetCreatureController(CreatorGameView view, NewScenarioController scenarioController,
                                 CreatureType creatureType) {
        this.creatureType = creatureType;
        this.scenarioController = scenarioController;
        this.mainview = view;
    }

    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createCreatorApplyingCharacterView(creatureType);

        view.getCancelButton().addActionListener(
                new RedirectListener(controllerManager, scenarioController)
        );
        ArrayList<ArrayList<String>> array = new ArrayList<>();
        for (var creature : getEntities(creatureType)) {
            array.add(new ArrayList<>(Arrays.asList(creature.getObjectPathPicture(), creature.getName())));
        }
        var map = Map.of(CreatureType.NPC, new PutNPCListener(data, mainview, view, controllerManager,
                        scenarioController), CreatureType.MONSTER,
                new PutMonsterListener(data, mainview, view, controllerManager, scenarioController),
                CreatureType.PLAYER_CHARACTER, new PutPCListener(data,
                        mainview, view, controllerManager, scenarioController));
        var parent = this;
        var entities = getEntities(creatureType);
        for (int i = 0; i < entities.size(); i++) {
            view.addButtonActionListener(AllObjectsView.ButtonType.SHOW, i,
                    e -> controllerManager.changeController(new CreatureShowController(entities.get(view.getClickedIndex()), creatureType) {
                        @Override
                        protected void setCancelButtonListener(BasicCard view1) {
                            view1.getCancelButton().addActionListener(
                                    new RedirectListener(controllerManager, parent));
                        }
                    }));
            view.addButtonActionListener(AllObjectsView.ButtonType.APPLY, i, map.get(creatureType));
        }

        view.uploadData(array);

        mainFrame.add(view.getPanel());
    }


    private ArrayList<? extends Creature> getEntities(CreatureType type) {
        ArrayList<? extends Creature> arrayList = new ArrayList<>();
        switch (type) {
            case PLAYER_CHARACTER ->
                    arrayList = (ArrayList<? extends Creature>) EntityManager.getInstance().getPlayerCharacterList();
            case MONSTER -> arrayList = (ArrayList<? extends Creature>) EntityManager.getInstance().getMonsterList();
            case NPC -> arrayList = (ArrayList<? extends Creature>) EntityManager.getInstance().getNPCList();
        }
        return arrayList;
    }
}
