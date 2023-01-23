package controllers.creatures;

import controllers.Controller;
import controllers.utils.CreatureType;
import controllers.utils.RedirectListener;
import game.creature.Creature;
import gui.utils.Converter;
import gui.factories.IOverallFactory;

public class CreatureShowController extends Controller {
    private Creature creature;
    private CreatureType creatureType;

    public CreatureShowController(Creature creature, CreatureType creatureType) {
        this.creature = creature;
        this.creatureType = creatureType;
    }
    
    @Override
    public void run(IOverallFactory overallFactory) {
        var view = overallFactory.createBasicCard();
        var contentData = Converter.createFullDataCreature(creature);
        view.uploadNewData(contentData, Converter.createFullDetailDataCreature(creature));

        view.getCancelButton().addActionListener(
                new RedirectListener(controllerManager, new CreatureListController(creatureType))
        );

        mainFrame.add(view.getPanel());
    }
}
