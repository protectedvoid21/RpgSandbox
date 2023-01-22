package controllers.creatures;

import controllers.Controller;
import controllers.utils.CreatureType;
import controllers.utils.RedirectListener;
import game.creature.Creature;
import game.filehandle.EntityManager;
import gui.Converter;
import gui.card.CardContentDataSet;
import gui.factories.IOverallFactory;
import gui.views.objectViews.AllObjectsView;
import gui.views.objectViews.itemsViews.FullSmallView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreatureListController extends Controller {
    private FullSmallView view;
    private CreatureType creatureType;
    private List<? extends Creature> creatureList;

    public CreatureListController(CreatureType creatureType) {
        this.creatureType = creatureType;
    }

    @Override
    public void run(IOverallFactory overallFactory) {
        switch(creatureType) {
            case NPC -> {
                view = overallFactory.createAllNPCView();
                creatureList = EntityManager.getInstance().getNPCList();
            }
            case MONSTER -> {
                view = overallFactory.createAllMonstersView();
                creatureList = EntityManager.getInstance().getMonsterList();
            }
            default -> {
                view = overallFactory.createAllCharactersView();
                creatureList = EntityManager.getInstance().getPlayerCharacterList();
            }
        }

        ArrayList<ArrayList<String>> data = new ArrayList<>();
        for(var creature : creatureList) {
            System.out.println(creature.getName());
            data.add(new ArrayList<>(Arrays.asList(creature.getObjectPathPicture(), creature.getName())));
        }
        for(int i = 0; i < 4; i++) {
            view.addButtonActionListener(AllObjectsView.ButtonType.DELETE, i, new DeleteButtonListener());
            //view.addButtonActionListener(AllObjectsView.ButtonType.SHOW, i, new RedirectListener());
            view.addButtonActionListener(AllObjectsView.ButtonType.EDIT, i, e -> creatureList.remove(view.getClickedIndex()));
            
        }
        view.uploadData(data);
        
        view.getCancelButton().addActionListener(
                new RedirectListener(controllerManager, new CreatureActionController(creatureType))
        );
        
        mainFrame.add(view.getPanel());
    }
    
    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            creatureList.remove(view.getClickedIndex());
            EntityManager.getInstance().saveAllEntities();
        }
    }
}
