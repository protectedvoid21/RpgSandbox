package controllers.items;

import controllers.Controller;
import controllers.RedirectListener;
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
                new RedirectListener(controllerManager, new CreateItemTypeController())
        );
        
        mainFrame.add(view.getPanel());
    }
}
