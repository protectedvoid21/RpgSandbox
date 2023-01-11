package gui;

import com.kitfox.svg.A;
import gui.card.IOverallFactory;
import gui.card.WarHammerFactory;
import gui.menu.*;
import gui.views.gamePanel.MainPanelGame;
import gui.views.gamePanel.gamePanels.CreatorPanel;
import gui.views.gamePanel.Point;
import gui.views.gamePanel.gamePanels.GamePanel;
import gui.views.objectViews.AllObjectsView;
import gui.views.objectViews.CardCancelView;
import gui.views.objectViews.CreatorGameView;
import gui.views.objectViews.ItemPicker;
import gui.views.objectViews.creatureViews.ChoosingCreationGameView;
import gui.views.selectingCreatureViews.SelectingView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class TestMainGui {
    public static void main(String[] args) throws IOException {
        JFrame ramka = new JFrame();
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(800, 800);
        IOverallFactory f = new WarHammerFactory();


//        var cmp = new ComponentPanelMenager<>(f.createCreatorCard(Card.CreatorTypes.WEAPONS).getPanel());
//        var main = f.createMenuView();
        var v = f.createBasicCard();
////        v.addButtonActionListener(AllObjectsView.ButtonType.SHOW, 5, e->System.out.println(v.getClickedIndex()));
////        cmp.addSpace(10);
//        var panel = new MainGamePanel(f.getFactory(), 10, 10);
//        DefaultCustomMenuMenager customPanelAttackChoser =
//                new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.HORIZONTAL,
//                        ComponentsSeries.ComponentsDimension.VERTICAL, 10);
//        customPanelAttackChoser.addMainComponent(10);
////        customPanelAttackChoser.setBackground(Color.RED);
//        customPanelAttackChoser.addMiddleComponent(new JButton("sdf"), 0, 10);
//        customPanelAttackChoser.getCmp().addSpace(40);
//        var cmp2 = new ComponentPanelMenager<>(new JButton("dfafa"));
//        cmp2.addSpace(10);
//        cmp2.addSpace(40);
//        panel.colorButtons(new ArrayList<>(Arrays.asList(new AbstractMap.SimpleEntry<Integer, Integer>(4, 3),
//                new AbstractMap.SimpleEntry<Integer, Integer>(5, 3), new AbstractMap.SimpleEntry<Integer, Integer>(1,
//                        1))));
//        var pan = new OptionsPanel(f.getFactory());
//        var pan = new MainGamePanel(f.getFactory(), 10, 10);
//        pan.initialize(new ArrayList<>(Arrays.asList("src/gui/rightarrowdisabled.png", "src/gui/snowman.png", "src" +
//                "/gui/playerimage.png", "src/gui/playerimage.png", "src/gui/monsterimage.png")));
//        pan.initialize(new ArrayList<>(Arrays.asList(new AbstractMap.SimpleEntry<>("src/gui/rightarrowdisabled.png",
//                        "2"), new AbstractMap.SimpleEntry<>("src/gui/snowman.png", "0"),
//                new AbstractMap.SimpleEntry<>("/gui/playerimage.png", "1"), new AbstractMap.SimpleEntry<>(
//                        "src/gui/playerimage.png", "2"), new AbstractMap.SimpleEntry<>(
//                        "src/gui/playerimage.png", "3"))));

        var x = new ComponentPanelMenager<>(v.getPanel());
        x.setHasUniqueColor(true);
        x.setBackgroundImage("src/gui/monsterimage.png");
//        x.setBackground(Color.RED);
        x.addSpace(10);
//        x.setBackground(Color.RED);
        var xxx = new CreatorPanel(f, 10);
        xxx.initialize();
        xxx.setOptionsDisabledIndexes(1, 4);
        xxx.applyNewCreatureOnPosition("src/gui/monsterimage.png", new Point(5, 7));
        xxx.addOptionsListener(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(xxx.getCurrentClickedIndexes());
            }
        });
        var pann = new CreatorGameView(f, 10);
        pann.getCreatorPanel().applyNewCreatureOnPosition("src/gui/monsterimage.png", new Point(4, 5));
//        pann.getCreatorPanel().setWholePanelDisabled();
//        xxx.applyDefendActionsContent(new Point(5, 6));
//        xxx.applyAttackActionsContent(new Point(6, 6));
        var ppp = new DefaultCustomMenuMenager<JComponent>(ComponentsSeries.ComponentsDimension.VERTICAL,
                ComponentsSeries.ComponentsDimension.HORIZONTAL);
        var z = new ChoosingCreationGameView(f);
        var rr = new GamePanel(f, 10);
        rr.initialize();
        z.initialize();
        z.addButtonActionListener(AllObjectsView.ButtonType.APPLY, 5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(z.getClickedIndex());
            }
        });
//        ppp.addMainComponent(20, 20);
//        ppp.addMiddleComponent(new JButton(), 0,10);
//        ppp.getMainComponent(0).addSpace(10);
        var picker = new ItemPicker(f.getFactory());
        var t = new MainPanelGame(f);
//        var panel = new MainGamePanel(f, 10);
        picker.uploadData(new ArrayList<>(Arrays.asList("src/gui/ave.jpg", "src/gui/ave22.png", "src/gui/aveeee.jpg")));
        var xxxxx = f.createGameCard();
        ramka.add(t.getPanel());
        ramka.setVisible(true);
    }
}
