//package gui.customUI.customUIStyles;
//
//import gui.customUI.CustomUI;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//public class GrowingBorderStyleUI extends CustomUI {
//    final private int offSet;
//    final private int arcWidth;
//    private boolean componentHovered = false;
//
//    public GrowingBorderStyleUI(int offSet, int arcWidth) {
//        this.offSet = offSet;
//        this.arcWidth = arcWidth;
//    }
//
//    public GrowingBorderStyleUI() {
//        this(6,10);
//    }
//
//    @Override
//    public void installUI(JComponent c) {
//        super.installUI(c);
//        c.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                super.mouseEntered(e);
//                componentHovered = true;
//                c.repaint();
//                c.revalidate();
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                super.mouseEntered(e);
//                componentHovered = false;
//                c.repaint();
//                c.revalidate();
//            }
//        });
//    }
//
//    @Override
//    public void paint(Graphics g, JComponent c) {
//        paintBackground(g, c, componentHovered ? offSet : (int) (0.5 * offSet));
//    }
//
//    @Override
//    public int getBorderSize() {
//        return 0;
//    }
//
//
//    public void paintBackground(Graphics g, JComponent c, int yOffset) {
//        Dimension size = c.getSize();
//        Graphics2D g2 = (Graphics2D) g;
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g.setColor(getAdditionalColor(Index.FIRST));
//        g.fillRoundRect(0, 0, size.width, size.height, arcWidth, arcWidth);
//        g.setColor(getAdditionalColor(Index.BASE_BACKGROUND));
//        g.fillRoundRect(yOffset, yOffset, size.width - 2 * yOffset, size.height - 2 * yOffset, arcWidth, arcWidth);
//    }
//
//}
