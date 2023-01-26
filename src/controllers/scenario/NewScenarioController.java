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

public class NewScenarioController extends Controller {
    private CreatorGameView view;
    private ArrayList<ScenarioData> data = new ArrayList<>();

    public NewScenarioController(IOverallFactory overallFactory) {
        view = overallFactory.createCreatorGameView();
    }



    @Override
    public void run(IOverallFactory overallFactory) {
//        var view = overallFactory.createCreatorGameView();
        System.out.println("wykonuje");
        view.getCreatorPanel().applyNewCreatureOnPosition("", new Vector2(2, 2));
        view.getExitButton().addActionListener(
                new RedirectListener(controllerManager, new MenuController())
        );
        var cntrl = this;

        view.getCreatorPanel().addOptionsListener(0,
                new RedirectListener(controllerManager, new SetCreatureController(view, cntrl, CreatureType.MONSTER,
                        data))
        );
        view.getCreatorPanel().addOptionsListener(1,
                new RedirectListener(controllerManager, new SetCreatureController(view, cntrl,
                        CreatureType.PLAYER_CHARACTER, data))
        );
        view.getCreatorPanel().addOptionsListener(2,
                new RedirectListener(controllerManager, new SetCreatureController(view, cntrl, CreatureType.NPC, data))
        );
        view.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SaveBoard(data).actionPerformed(e);
                controllerManager.changeController(new MenuController());
            }
        });
        mainFrame.add(view.getPanel());
    }
}
