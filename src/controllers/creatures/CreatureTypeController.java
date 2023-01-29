package controllers.creatures;

import controllers.Controller;
import controllers.MenuController;
import controllers.utils.CreatureType;
import controllers.utils.RedirectListener;
import gui.bundle.CustomBundle;
import gui.data.TextData;
import gui.factories.IOverallFactory;
import gui.views.utilsViews.TitleView;

public class CreatureTypeController extends Controller implements TextData {
    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createCreaturesPanel();
        var title = new TitleView(overallFactory.getFactory());
        title.initialize(CustomBundle.getDefaultString(creatureTitleManager), view, 12, 20);
        view.getReturnButton().addActionListener(
                new RedirectListener(controllerManager, new MenuController())
        );
        view.getButton(0).addActionListener(
                new RedirectListener(controllerManager, new CreatureActionController(CreatureType.MONSTER))
        );
        view.getButton(1).addActionListener(
                new RedirectListener(controllerManager, new CreatureActionController(CreatureType.PLAYER_CHARACTER))
        );
        view.getButton(2).addActionListener(
                new RedirectListener(controllerManager, new CreatureActionController(CreatureType.NPC))
        );

        mainFrame.add(title.getPanel());
    }
}
