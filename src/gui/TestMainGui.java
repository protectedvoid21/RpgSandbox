package gui;

import gui.card.IOverallFactory;
import gui.card.WarHammerFactory;
import gui.menu.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TestMainGui {
    public static void main(String[] args) throws IOException {
        JFrame ramka = new JFrame();
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(800, 800);




//        System.out.println(mapa.size());

        IOverallFactory f = new WarHammerFactory();
//        var card = f.createCard(new AbstractMap.SimpleEntry<>("src/gui/witch.png", "WITCH"), mapa);//metoda change

        var c = f.createFullCard(
        );
        // size do gotowej karty i zmiana calosci danych

//        var menu = new CustomMenuMenager(ComponentsSeries.ComponentsDimension.HORIZONTAL,
//                ComponentsSeries.ComponentsDimension.VERTICAL);
//
//        var factory = new GuiFactory();
//        factory.setButtonFactory(new ArrowButtonFactory());d
//        factory.setLabelFactory(new WinterDarkerBackgroundLabelFactory());
//        factory.setTextFactory(new TextFieldFactory());
//        menu.addMainComponent(10);2
//        menu.addSpace(5, ComponentPanelMenager.Side.LEFT);
//        menu.setBackground(Color.ORANGE);
//        menu.addMiddleComponent(factory.createButton("WINTER TIME", null), 0, 20);
//        menu.addMiddleComponent(factory.createTextArea(), 0, 20);d
//        menu.addMiddleComponent(factory.createTextField(), 0, 20);s
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
            }

            private Image back;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (back != null) {
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
//        var x = new TransparentPanel(menu.getCmp());A
//        ramka.setVisible(true);
//        var x = new ComponentPanelMenager<>(new JButton());
//        x.addSpace(10);
//        x.setBackgroundImage("src/gui/warback.jpg");
//        ramka.add(menu.getCmp());s
//        menu.getCmp().setBackgroundImage("src/gui/warback.jpg");
//        card.getPanel().getCmp().addSpace(10);

        var cmp = new ComponentPanelMenager<>(f.createFullCard().getPanel());
//        cmp.addSpace(10);
        ramka.add(cmp);
        ramka.setVisible(true);
    }
}
