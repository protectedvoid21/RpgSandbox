package gui;

import gui.card.fullCards.abstractCards.Card;
import gui.factories.IOverallFactory;
import gui.factories.WarHammerFactory;
import gui.menu.*;

import javax.swing.*;
import java.io.IOException;

public class TestMainGui {
    public static void main(String[] args) throws IOException {
        JFrame ramka = new JFrame();
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(800, 800);
        IOverallFactory f = new WarHammerFactory();
        ramka.add(f.createMainPanelGame().getPanel());
//        ramka.add(f.createBasicCard().getPanel());
//        ramka.add(f.createAllCreatureShowView().getPanel());
//        ramka.add(f.createCreatorApplyingCharacterView().getPanel());
//        ramka.add(f.createAllCreatureEditView().getPanel());
//        ramka.add(f.createAllItemsEditView().getPanel());
//        ramka.add(f.createAllItemsShowView().getPanel());
//        ramka.add(f.createCardCancelView(f.createBasicCard()).getPanel());
//        ramka.add(f.createchoosingCreationGameView().getPanel());
//        ramka.add(f.createCreaturesPanel().getPanel());
//        ramka.add(f.createSmallEditItemCard().getPanel());
//        ramka.add(f.createGameCard().getPanel());
//        ramka.add(f.createMenuView().getPanel());
//        ramka.add(f.createViewingItemsPanel().getPanel());
//        ramka.add(f.createCreatorGameView().getPanel());
//        ramka.add(f.createAllCreatureShowView().getPanel());
//        ramka.add(f.createCreaturesPanel().getPanel());


        ramka.setVisible(true);
    }
}
