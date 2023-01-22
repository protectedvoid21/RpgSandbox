package controllers.creatures;

import controllers.Controller;
import gui.Converter;
import gui.factories.IOverallFactory;

public class CreatureEditController extends Controller {
    public CreatureEditController() {
        
    }
    
    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createEntriesCard();
        
        //view.uploadNewData();
    }
}
