//package gui.factories;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//
//
//
//public class MenuButtonFactory implements IButtonFactory{
//    private JButton button;
//
//
//    @Override
//    public JButton createButton(String data, ActionListener method) {
//         button = new JButton(data);
//        button.addActionListener(method);
//        button.setOpaque(true);
//        button.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                button.setBackground(ButtonStyle.PRIMARY.background);
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                super.mouseReleased(e);
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                super.mouseEntered(e);
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                super.mouseExited(e);
//            }
//        });
//
//
//        return button;
//
//    }
//
//    public enum ButtonStyle {
//        PRIMARY(new Color(0, 172, 126), new Color(238, 238, 238), new Color(2, 111, 82), new Color(4, 205, 151)),
//        SECONDARY(new Color(203, 209, 219), new Color(58, 70, 81), new Color(81, 92, 108), new Color(230, 239, 255)),
//        DESTRUCTIVE(new Color(255, 138, 48), new Color(238, 238, 238), new Color(198, 86, 0), new Color(255, 161, 90));
//
//        private Color background;
//        private Color foreground;
//        private Color backgroundHover;
//        private Color backgroundPress;
//        private ButtonStyle(Color background, Color foreground, Color backgroundHover, Color backgroundPress) {
//            this.background = background;
//            this.foreground = foreground;
//            this.backgroundHover = backgroundHover;
//            this.backgroundPress = backgroundPress;
//        }
//    }
//
//}
