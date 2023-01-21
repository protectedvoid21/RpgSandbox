package controllers.creatures;

import controllers.Controller;
import controllers.utils.CreatureType;
import controllers.utils.RedirectListener;
import gui.Converter;
import gui.card.CardContentDataSet;
import gui.factories.IOverallFactory;
import gui.views.objectViews.creatureViews.AllCreaturesEditView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CreatureEditListController extends Controller {
    private CreatureType creatureType;
    
    private AllCreaturesEditView view;

    public CreatureEditListController(CreatureType creatureType) {
        this.creatureType = creatureType;
    }

    @Override
    public void run(IOverallFactory overallFactory) {
        view = overallFactory.createAllCreatureEditView();

        var cardContentDataSetList = new ArrayList<CardContentDataSet>();
        //todo wait for Converter fixes
        //cardContentDataSetList = Converter.createFromCreatureCard();
        
        //view.uploadData(cardContentDataSetList);
        
        view.getCancelButton().addActionListener(
                new RedirectListener(controllerManager, new CreatureActionController(creatureType))
        );
        
        mainFrame.add(view.getPanel());
    }
    
    private class EditCreatureListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            /*switch(creatureType) {
                case MONSTER: {
                    
                }
            }*/
        }
    }
}
