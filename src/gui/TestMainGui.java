package gui;

import gui.card.IOverallFactory;
import gui.card.WarHammerFactory;
import gui.card.fullCards.abstractCards.Card;
import gui.menu.*;
import gui.views.objectViews.AllObjectsView;
import gui.views.objectViews.itemsViews.AllItemsEditView;

import javax.swing.*;
import java.io.IOException;

public class TestMainGui {
    public static void main(String[] args) throws IOException {
        JFrame ramka = new JFrame();
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(800, 800);
        IOverallFactory f = new WarHammerFactory();


        var cmp = new ComponentPanelMenager<>(f.createCreatorCard(Card.CreatorTypes.WEAPONS).getPanel());
        var main = f.createMenuView();
        var v= f.createAllItemsShowView();
        v.addButtonActionListener(AllObjectsView.ButtonType.SHOW, 5, e->System.out.println(v.getClickedIndex()));
//        cmp.addSpace(10);
        ramka.add(v.getPanel());
        ramka.setVisible(true);
    }
}
