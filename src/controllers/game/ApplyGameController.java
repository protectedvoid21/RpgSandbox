package controllers.game;

import controllers.Controller;
import controllers.MenuController;
import controllers.creatures.CreatureListController;
import controllers.creatures.CreatureTypeController;
import controllers.utils.CreatureType;
import controllers.utils.RedirectListener;
import game.board.ScenarioTester;
import game.filehandle.EntityManager;
import gui.factories.IOverallFactory;
import gui.views.gamePanel.gamePanels.CreatorPanel;
import gui.views.objectViews.AllObjectsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ApplyGameController extends Controller {

    @Override
    public void run(IOverallFactory overallFactory) {
        ScenarioTester.main(null);
        var view = overallFactory.createchoosingCreationGameView();
        view.getCancelButton().addActionListener(
                new RedirectListener(controllerManager, new MenuController())
        );
        var array = new ArrayList<CreatorPanel>();
        for (var scenario : EntityManager.getInstance().getScenarioList()) {
            var p1 = overallFactory.createCreatorPanel();
            for (var item : scenario.getScenarioDataList()) {
                p1.applyNewCreatureOnPosition(item.creature.getObjectPathPicture(), item.position);
            }
            p1.setWholePanelDisabled();
            array.add(p1);
        }
        view.uploadData(array);
        for (int i = 0; i < array.size(); i++) {
            view.addButtonActionListener(AllObjectsView.ButtonType.APPLY, i, new RedirectListener(controllerManager,
                    new MainGameController(EntityManager.getInstance().getScenarioList().get(i))));
        }

        mainFrame.add(view.getPanel());
    }
}
