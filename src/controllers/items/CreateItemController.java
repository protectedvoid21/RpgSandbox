package controllers.items;

import controllers.Controller;
import controllers.utils.RedirectListener;
import gui.card.fullCards.abstractCards.Card;
import gui.factories.IOverallFactory;

public class CreateItemController extends Controller {
    private Card.CreatorTypes creatorType;
    
    public CreateItemController(Card.CreatorTypes creatorType) {
        this.creatorType = creatorType;
    }
    
    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createCreatorCard(creatorType);
        
        view.getCancelButton().addActionListener(
                new RedirectListener(controllerManager, new ItemTypeMenuController())
        );
        
        mainFrame.add(view.getPanel());
    }
}
