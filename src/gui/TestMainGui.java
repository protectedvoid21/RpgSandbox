package gui;

import gui.card.fullCards.abstractCards.Card;
import gui.factories.IOverallFactory;
import gui.factories.WarHammerFactory;
import gui.menu.*;
import gui.views.Point;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.AbstractMap;

public class TestMainGui {
    static Font pixel;

    public static void main(String[] args) throws IOException {
        JFrame ramka = new JFrame();
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(800, 800);
        IOverallFactory f = new WarHammerFactory();
        var x = f.createMainPanelGame();
        x.getActivityOptionsPanel().setDisabledIndexes(1,4);
//        x.getActivityOptionsPanel().setDisabledIndexes(1, 2);
//        x.getGamePanel().applyContent(new AbstractMap.SimpleEntry<>(new Point(3, 4), "src/gui/go.png"));
        ramka.add(x.getPanel());
//        ramka.add(f.createBasicCard().getPanel());
//        ramka.add(f.createEntriesCard().getPanel());
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
//        ramka.add(f.createCreatorApplyingCharacterView().getPanel());


        ramka.setVisible(true);
    }
}
