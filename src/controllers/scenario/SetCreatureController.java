package controllers.scenario;

import controllers.Controller;
import controllers.utils.CreatureType;
import controllers.utils.RedirectListener;
import gui.card.fullCards.abstractCards.Card;
import gui.factories.IOverallFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetCreatureController extends Controller {
    private NewScenarioController scenarioController;
    private CreatureType creatureType;

    public SetCreatureController(NewScenarioController scenarioController, CreatureType creatureType) {
        this.creatureType = creatureType;
        this.scenarioController = scenarioController;
    }

    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createCreatorApplyingCharacterView();
        
        view.getCancelButton().addActionListener(
                new RedirectListener(controllerManager, scenarioController)
        );
        view.uploadData(new ArrayList<>(List.of(new ArrayList<>(Arrays.asList("gowno", "gowno123")))));

        mainFrame.add(view.getPanel());
    }
}
