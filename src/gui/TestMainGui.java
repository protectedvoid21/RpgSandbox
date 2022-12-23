package gui;

import com.kitfox.svg.app.beans.SVGIcon;
import gui.Menu.MainMenu;
import gui.customIcon.StrechIcon2;
import gui.customIcon.StretchIcon;
import gui.factories.IconButton;
import gui.factories.MainMenuBuilder;
import gui.factories.StyledButtonUI;
import gui.factories.StyledLabelUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.awt.image.MultiResolutionImage;
import java.awt.image.BaseMultiResolutionImage;

public class TestMainGui {

    static class Reakcja1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("kliknieto 1");
        }
    }

    public static void main(String[] args) throws MalformedURLException {
        JFrame ramka = new JFrame();
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(800, 800);
//        var lay = new GridBagLayout();
//        var cst = new GridBagConstraints();
//        ramka.setLayout(lay);
//        cst.fill = GridBagConstraints.BOTH;
//        cst.weighty = 1;
//        cst.weightx = 1;
//        cst.gridx = 0;
//        cst.gridy = 0;
//        ramka.add(new JButton("hello"), cst);
//        cst.gridx = 1;
//        cst.gridy = 0;
//        cst.gridwidth = 2;
//        ramka.add(new JButton("hello"), cst);
////        cst.gridx = 2;
////        cst.gridy = 0;
////        ramka.add(new JButton("hello"), cst);
//        cst.gridwidth = 1;
//        cst.weightx = 1;
//        cst.gridx = 0;
//        cst.gridy = 1;
//        ramka.add(new JButton("hello"), cst);
//        cst.gridx = 1;
//        cst.gridy = 1;
//        ramka.add(new JButton("hello"), cst);
//        cst.gridx = 2;
//        cst.gridy = 1;
//        ramka.add(new JButton("hello"), cst);
//        cst.gridx = 1;
//        cst.gridy = 2;
//        ramka.add(new JButton("hello"), cst);
//        cst.gridx = 2;
//        cst.gridy = 2;
//        ramka.add(new JButton("hello"), cst);
//        cst.gridx = 0;
//        cst.gridy = 2;
//        ramka.add(new JButton("hello"), cst);
//        MainMenu menu = new MainMenu(ramka);
//        var pan = new JPanel();
//
//        menu.addOption(pan);
////        var border = new BorderLayout();
////        pan.setLayout(border);
////        var icon = new SVGIcon();
////        var reader = new StringReader("src/gui/classroom-svgrepo-com.svg");
////        var urisvg = SVGCache.getSVGUniverse().loadSVG(reader, SVGCache);
//
////        icon.setSvgURI(urisvg);
//        SVGIcon icon = new SVGIcon();
//        icon.setSvgURI(new File("src/gui/classroom-svgrepo-com.svg").toURI());
//        icon.setAutosize(SVGIcon.AUTOSIZE_BESTFIT);
//        icon.setClipToViewbox(true);
//
//        var button = new JButton();
//        button.setContentAreaFilled(false);
//        button. setFocusPainted(false);
//        button. setBorder(new EmptyBorder(0, 0, 0, 0));
//        button.setIcon(icon);
////        button.setIcon(icon);
//        menu.addOption(button);
//        menu.addOption(new JButton("sfsf"));
//        var buttt = new JButton();
//        buttt.setIcon(new StrechIcon2(buttt,"Ada"));
//        menu.addOption(buttt);


         MainMenu  menu = new MainMenu(ramka);
         menu.addVerticalPanels();

         JButton button = new JButton("Button #");
        button.setFont(new Font("Calibri", Font.PLAIN, 14));
        button.setBackground(new Color(0x2dce98));
        button.setForeground(Color.white);
        // customize the button with your own look
        button.setUI(new StyledButtonUI());
        menu.addOption(button);
         var button2 = new JButton();
         button2.setBackground(Color.CYAN);
        button2.setUI(new StyledButtonUI());
        button2.setPreferredSize(button2.getSize());button2.setMinimumSize(button2.getSize());
        button2.setMaximumSize(button2.getSize());
        button2.setText("Fsfsfsf");

//         button.setPressedIcon(new StrechIcon2(button2, "src/gui/Menu/border.png"));
         button2.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 menu.increaseSize(3,1.5);
             }
         });
         var label = new JLabel();
        label.setFont(new Font("Calibri", Font.PLAIN, 14));
         label.setBackground(Color.white);
         label.setUI(new StyledLabelUI());
         menu.addOption(label);
         menu.addOption(button2);
         menu.addOption(new JButton("sdfsf"));
         menu.addOption(new IconButton("src/gui/Menu/border.png"));
         menu.addOption(new IconButton("src/gui/Menu/border.png"));
         menu.addOption(new IconButton("src/gui/Menu/border.png"));
//         var label = new IconLabel("src/gui/image2.png");
////         var i = new SV("classroom-svgrepo-com.svg", 100, 100);
//         var i = new SVGIcon();
//         i.setSvgResourcePath("classroom-svgrepo-com.svg");
//         var lll = new JButton();
////         lll.putClientProperty( "JButton.buttonType", "roundRect" );
//         lll.setIcon(i);
//         menu.addOption(new IconPanel("classroom-svgrepo-com.svg", 100, 100));
//         lll.repaint();
//         label.getIcon().setText("THIS IS MY TITLE FOR MY BEST GUI EVERfdsgfdsgfsdfsd");
//         var label2 = new JLabel("fdsfads");
//         label2.setOpaque(true);
//         label2.setBackground(Color.BLUE);
//         menu.addOption(label2);
//         label2.setSize(new Dimension(1, 250));
//         label.getIcon().addAttribute(TextAttribute.FOREGROUND, Color.GREEN);
//         label.addMouseListener(new MouseListener() {
//             @Override
//             public void mouseClicked(MouseEvent e) {
//
//             }
//
//             @Override
//             public void mousePressed(MouseEvent e) {
//
//             }
//
//             @Override
//             public void mouseReleased(MouseEvent e) {
//
//             }
//
//             @Override
//             public void mouseEntered(MouseEvent e) {
//                 System.out.println("hello");
//                label.getIcon().addAttribute(TextAttribute.FOREGROUND, Color.RED);
////                 label.getIcon().addAttribute(TextAttribute.FONT, new Font("Arial", Font.BOLD, 14));
//             }
//
//             @Override
//             public void mouseExited(MouseEvent e) {
//                 label.getIcon().addAttribute(TextAttribute.FOREGROUND, Color.GREEN);
//                 label.getIcon().addAttribute(TextAttribute.FONT, new Font("Helvetica", Font.ITALIC, 14));
//             }
//         });
//
//         menu.addOption(label);

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
