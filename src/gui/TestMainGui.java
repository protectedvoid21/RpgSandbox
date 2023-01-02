package gui;

import gui.card.Card;
import gui.card.IOverallFactory;
import gui.card.WarHammerFactory;
import gui.customUI.customUIStyles.RoundedBorderUI;
import gui.customUI.interfaces.ICustomUI;
import gui.factories.*;
import gui.factories.customFactories.buttonFactories.ArrowButtonFactory;
import gui.factories.customFactories.buttonFactories.WinterClickedButtonFactory;
import gui.factories.customFactories.buttonFactories.WinterGrowingBorderButtonFactory;
import gui.factories.customFactories.labelFactories.GameGreenLabelFactory;
import gui.factories.customFactories.labelFactories.TitleCardLabelFactory;
import gui.factories.customFactories.labelFactories.WinterDarkerBackgroundLabelFactory;
import gui.factories.customFactories.textComponentFactory.TextFieldFactory;
import gui.menu.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TestMainGui {
    public static void main(String[] args) throws IOException {
        JFrame ramka = new JFrame();
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(800, 800);


        var mapa = new ArrayList<ArrayList<String>>();
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATRYBUT1", "10"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"XDDD", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATRYBUT1", "10"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"XDDD", "1fd0"})));


        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));

        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATRYBUT1", "10"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"XDDD", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));

        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));


//        System.out.println(mapa.size());

        IOverallFactory f = new WarHammerFactory();
        var card = f.createCard(new AbstractMap.SimpleEntry<>("src/gui/witch.png", "WITCH"), mapa);//metoda change
        // size do gotowej karty i zmiana calosci danych

//        var menu = new CustomMenuMenager(ComponentsSeries.ComponentsDimension.HORIZONTAL,
//                ComponentsSeries.ComponentsDimension.VERTICAL);
//
//        var factory = new GuiFactory();
//        factory.setButtonFactory(new ArrowButtonFactory());
//        factory.setLabelFactory(new WinterDarkerBackgroundLabelFactory());
//        factory.setTextFactory(new TextFieldFactory());
//        menu.addMainComponent(10);
//        menu.addSpace(5, ComponentPanelMenager.Side.LEFT);
//        menu.setBackground(Color.ORANGE);
//        menu.addMiddleComponent(factory.createButton("WINTER TIME", null), 0, 20);
//        menu.addMiddleComponent(factory.createTextArea(), 0, 20);
//        menu.addMiddleComponent(factory.createTextField(), 0, 20);
//        var m = new ComponentsSeries<>(ComponentsSeries.ComponentsDimension.HORIZONTAL);
//        menu.addMiddleComponent(m, 0, 40);
//        menu.addMainComponent(5);
////        menu.getColumn(1).getOption(0).addSpace(10, ComponentMenager.Side.TOP);
//        menu.addMiddleComponent(factory.createLabel("WINTER TIME"), 1, 1);
//        menu.getMiddleComponent(1, 0).addSpace(20, ComponentPanelMenager.Side.LEFT);
//        menu.addMiddleComponent(factory.createButton("HELLO WORLD", null), 1, 1);
//        factory.setButtonFactory(new WinterGrowingBorderButtonFactory(0.6, 0.2));
//        menu.getMiddleComponent(0, 3).addSpace(10, ComponentPanelMenager.Side.LEFT);
//        menu.getMiddleComponent(0, 3).addSpace(20, ComponentPanelMenager.Side.TOP);
//        menu.addMiddleComponent(factory.createButton("HELLO WORLD", new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                JButton[] buttons = { factory.createButton("hello", new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//
//                    }
//                }) };
//                JOptionPane.showOptionDialog(null, "Test Message", "Dialog", JOptionPane.OK_OPTION, JOptionPane
//                .INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
//            }
//        }), 0, 20);

        class X extends JPanel {
            public X() throws IOException {
                back = ImageIO.read(new File("src/gui/warback.jpg"));
                repaint();
                revalidate();
                System.out.println("hellll????");
            }

            private Image back;

            @Override
            protected void paintComponent(Graphics g) {
                System.out.println("hellll");
                super.paintComponent(g);
                if (back != null) {
                    System.out.println("jjjfdssdfsdfsdfsdfjj");
                    System.out.println(this.getWidth());
                    g.drawImage(back, 0, 0, this.getWidth(), this.getHeight(), this);
                }
            }
        }
        var panel = new X();
//        panel.setBackground(Color.BLUE);
//        var panel = new JPanel()
//        menu.setBackground(Color.ORANGE);
//        menu.getCmp().setBorder(new LineBorder(Color.RED));
//        var ui = new RoundedBorderUI();
//        ui.setAdditionaldColor(Color.RED, ICustomUI.Index.FIRST);
//        menu.getCmp().setUI(new CustomPanelUI(new RoundedBorderUI()));
//        var x = new TransparentPanel(menu.getCmp());
//        ramka.setVisible(true);
//        var x = new ComponentPanelMenager<>(new JButton());
//        x.addSpace(10);
//        x.setBackgroundImage("src/gui/warback.jpg");
//        ramka.add(menu.getCmp());
//        menu.getCmp().setBackgroundImage("src/gui/warback.jpg");
//        card.getPanel().getCmp().addSpace(10);

        var cmp = new ComponentPanelMenager<>(card.getPanel());
//        cmp.addSpace(10);
        ramka.add(cmp);
        ramka.setVisible(true);
    }
}
