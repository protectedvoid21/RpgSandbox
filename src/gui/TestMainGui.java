package gui;

import gui.Menu.MainMenu;
import gui.factories.IconButton;
import gui.customIcon.StretchIcon;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestMainGui {

     static class Reakcja1 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("kliknieto 1");
        }
    }
     public static void main(String[] args) {
         JFrame ramka = new JFrame();
         ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         ramka.setSize(800, 800);
         MainMenu  menu = new MainMenu(ramka);
         menu.addVerticalPanels();
         var button = new IconButton("src/gui/fsfs.png");
         button.setPressedIcon(new StretchIcon("src/gui/image2.png"));
         menu.addOption(button);
         menu.addOption(new IconButton("src/gui/fsfs.png"));
         menu.addOption(new IconButton("src/gui/fsfs.png"));
         menu.addOption(new IconButton("src/gui/fsfs.png"));
         menu.addOption(new IconButton("src/gui/fsfs.png"));

//         IButtonFactory factory1 = new MenuButtonFactory();
//         menu.addOption(factory1.createButton("hello", new Reakcja1() ));
//         var butt = new JButton("Fsfsa");
//         menu.addOption(butt);
//         butt.setBackground(Color.RED);
//         var buttt = new JButton();
////         buttt.setBackground(Color.BLUE);
//         String path = "src/gui/fsfs.png";
//         var img = (new ImageIcon(path));
//         Image i = img.getImage();
////         System.out.println(img.getImageLoadStatus());
//         Icon icon = new StretchIcon("src/gui/fsfs.png");
//
//         String path2 = "src/gui/image2.png";
//         var img2 = (new ImageIcon(path2));
//         Image i2 = img2.getImage();
////         System.out.println(img.getImageLoadStatus());
//         StretchIcon icon2 = new StretchIcon("src/gui/image2.png", false);
//         icon2.setText("Hello java");
//         butt.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 if (!icon2.isTextEmpty()){
//                 icon2.removeText();}else{
//                     icon2.setText("HELLO BOY");
//                 }
//             }
//         });
////         StretchIcon iconx =
////         buttt.setPreferredSize(new Dimension(100, 100));
////         Icon icon = new ImageIcon(i.getScaledInstance(150,50, 4));
//
//         boolean pressed = false;
//         buttt.setPressedIcon(icon2);
//         buttt.setDisabledIcon(icon);
////        buttt.addMouseListener(new MouseListener() {
////            @Override
////            public void mouseClicked(MouseEvent e) {
////                butt.setText("hhhhhhhhdsfafhwerarw");
////                System.out.println("xxx222x");
////                buttt.setIcon(icon);
////            }
////
////            @Override
////            public void mousePressed(MouseEvent e) {
////                butt.setText("hhhhhhhhdsfafh");
////                buttt.setIcon(icon);
////                System.out.println("Faaf");
////            }
////
////            @Override
////            public void mouseReleased(MouseEvent e) {
////                System.out.println("xxxx");
////                buttt.setIcon(icon2);
////            }
////
////            @Override
////            public void mouseEntered(MouseEvent e) {
////                butt.setText("hhhhhhhhh");
////                buttt.setIcon(icon2);
////            }
////
////            @Override
////            public void mouseExited(MouseEvent e) {
////                butt.setText("sfssfs");
////                buttt.setIcon(icon);
////            }
////        });
//         IconButton b = new IconButton("xxx");
//         buttt.setIcon(icon);
//         buttt.setPressedIcon(icon2);
//         buttt.setContentAreaFilled(false);
//         buttt.setFocusPainted(false);
////         buttt.setSize(0, 0);
//         buttt.setBorder(new EmptyBorder(0, 0, 0, 0));
//         menu.addOption(buttt);
//         menu.addOption(new JButton());
////         buttt.setPreferredSize(new Dimension(100, 100));
//         System.out.println(buttt.getPreferredSize());
//
//         butt.addActionListener(new Reakcja1());
//         var xx = new JButton("fsss");
//         menu.addOption(xx);
//         xx.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 icon2.addAttribute(TextAttribute.FOREGROUND, Color.RED);
//             }
//         });
//         var next = new JButton("ddddddddddddd");
//         next.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 icon2.resetText();
//                 icon2.setText("HELLO GIRL");
//             }
//         });
//         menu.addOption(next);
         ramka.setVisible(true);
    }
}
