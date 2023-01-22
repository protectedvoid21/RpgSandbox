package controllers.creatures;

import controllers.Controller;
import gui.factories.IOverallFactory;

public class CreatureShowController extends Controller {
    public CreatureShowController() {
        
    }
    
    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createEntriesCard();
    }
}
