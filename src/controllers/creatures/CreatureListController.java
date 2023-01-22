package controllers.creatures;

import controllers.Controller;
import controllers.utils.CreatureType;
import controllers.utils.RedirectListener;
import game.creature.Creature;
import game.filehandle.EntityManager;
import gui.Converter;
import gui.card.CardContentDataSet;
import gui.factories.IOverallFactory;
import gui.views.objectViews.itemsViews.FullSmallView;

import java.util.List;

public class CreatureListController extends Controller {
    private CreatureType creatureType;

    public CreatureListController(CreatureType creatureType) {
        this.creatureType = creatureType;
    }

    @Override
    public void run(IOverallFactory overallFactory) {
        FullSmallView view;
        
        switch(creatureType) {
            case NPC -> view = overallFactory.createAllNPCView();
            case MONSTER -> {
                view = overallFactory.createAllMonstersView();
                var monsterList = EntityManager.getInstance().getMonsterList();
            }
            default -> view = overallFactory.createAllCharactersView();
        }
        
        view.getCancelButton().addActionListener(
                new RedirectListener(controllerManager, new CreatureActionController(creatureType))
        );
        
        mainFrame.add(view.getPanel());
    }
}
