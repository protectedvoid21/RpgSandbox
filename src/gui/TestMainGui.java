package gui;

import gui.card.fullCards.abstractCards.Card;
import gui.card.fullCards.specificCards.GodCard;
import gui.factories.IOverallFactory;
import gui.factories.WarHammerFactory;
import gui.menu.*;
import gui.views.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        x.getGamePanel().setOptionsDisabledIndexes(new Point(2, 3),2,4);
        x.getGamePanel().setOptionsDisabledIndexes(new Point(2, 5),1);
        x.getGamePanel().setOptionsDisabledIndexes(new Point(1, 3),3, 4);
        x.getGamePanel().setOptionsDisabledIndexes(new Point(1, 3));
        x.getActivityOptionsPanel().setDisabledIndexes(1, 2);
        x.getGamePanel().applyContent(new AbstractMap.SimpleEntry<>(new Point(3, 4), "src/gui/go.png"));

//        ramka.add(f.createCreatingEditingItemsPanel().getPanel());
//        ramka.add(x.getPanel());
        var z = f.createBasicCard();
        ((GodCard)z).setItemAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("xxx");
            }
        });
//        ((GodCard)z).setItemViewStatus(Card.CardTypes.MOUNT, 2);
//        ((GodCard)z).removeItemViewStatus();
        ramka.add(x.getPanel());
//        ramka.add(f.createEntriesCard().getPanel());
//        ramka.add(f.createAllCreatureShowView().getPanel());
//        ramka.add(f.createCreatorApplyingCharacterView().getPanel());
//        ramka.add(f.createAllCreatureEditView().getPanel());
//        ramka.add(f.createAllItemsShowView().getPanel());
//        ramka.add(f.createAllItemsShowView().getPanel());
//        var pa = f.createGodCard();
//        pa.setItemViewStatus(Card.CardTypes.ARMOR, 3);
//        ramka.add(pa.getPanel());
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
//        ramka.add(f.createCreatorCard(Card.CreatorTypes.ARMOR).getPanel());


        ramka.setVisible(true);
    }
}
