package controllers.scenario;

import controllers.Controller;
import controllers.MenuController;
import controllers.utils.CreatureType;
import controllers.utils.RedirectListener;
import game.board.ScenarioData;
import game.filehandle.EntityManager;
import game.generals.Vector2;
import gui.actionListener.scenarioCreating.SaveBoard;
import gui.factories.IOverallFactory;
import gui.views.objectViews.creationViews.CreatorGameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NewScenarioController extends Controller {
    private final CreatorGameView view;
    private ArrayList<ScenarioData> data = new ArrayList<>();

    public NewScenarioController(IOverallFactory overallFactory) {
        view = overallFactory.createCreatorGameView();
    }

    public NewScenarioController(IOverallFactory overallFactory, ArrayList<ScenarioData> data) {
        view = overallFactory.createCreatorGameView();
        this.data = data;
    }


    @Override
    public void run(IOverallFactory overallFactory) {
//        var view = overallFactory.createCreatorGameView();
        for (var d : data) {
            view.getCreatorPanel().applyNewCreatureOnPosition(d.creature.getObjectPathPicture(), d.position);
        }
        view.getExitButton().addActionListener(
                new RedirectListener(controllerManager, new MenuController())
        );
        var cntrl = this;
        var map = Map.of(CreatureType.MONSTER, 0, CreatureType.PLAYER_CHARACTER, 1, CreatureType.NPC, 2);

        for (var key : map.keySet()) {
            view.getCreatorPanel().addOptionsListener(map.get(key),
                    new RedirectListener(controllerManager, new SetCreatureController(view, cntrl, key,
                            data, overallFactory))
            );
        }

//        view.getCreatorPanel().addOptionsListener(0,
//                new RedirectListener(controllerManager, new SetCreatureController(view, cntrl, CreatureType.MONSTER,
//                        data, overallFactory))
//        );
//        view.getCreatorPanel().addOptionsListener(1,
//                new RedirectListener(controllerManager, new SetCreatureController(view, cntrl,
//                        CreatureType.PLAYER_CHARACTER, data, overallFactory))
//        );
//        view.getCreatorPanel().addOptionsListener(2,
//                new RedirectListener(controllerManager, new SetCreatureController(view, cntrl, CreatureType.NPC, data
//                        , overallFactory))
//        );
        view.getSaveButton().addActionListener(e -> {
            new SaveBoard(data).actionPerformed(e);
            controllerManager.changeController(new MenuController());
        });
        mainFrame.add(view.getPanel());
    }
}
