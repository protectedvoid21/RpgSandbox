package controllers.items;

import controllers.*;
import controllers.utils.RedirectListener;
import gui.factories.IOverallFactory;

public class ItemActionController extends Controller {
    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createOverallItemPanel();
        view.getReturnButton().addActionListener(
                new RedirectListener(controllerManager, new MenuController())
        );
        view.getButton(0).addActionListener(
                new RedirectListener(controllerManager, new ItemTypeMenuController())
        );
        view.getButton(1).addActionListener(
                new RedirectListener(controllerManager, new CreateItemTypeController())
        );
        
        mainFrame.add(view.getPanel());
    }
}
