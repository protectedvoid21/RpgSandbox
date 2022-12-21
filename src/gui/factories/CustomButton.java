package gui.factories;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

public class CustomButton extends JButton {
//    Animation animation;

    public CustomButton() {
        super();
//        setBorder(new EmptyBorder(20 / 2, 20 / 2, 20 / 2, 20 / 2));
//        revalidate();
//        repaint();

//        setBorder(new RoundedBorder(Color.ORANGE,22));
        setOpaque(false);
//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                repaint();
//                revalidate();
//                super.mousePressed(e);
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                repaint();
//                revalidate();
//                super.mouseReleased(e);
//            }
//        });
//        setContentAreaFilled(false);
//        this.setContentAreaFilled(false);
//        this.setFocusPainted(false);
//        this.setOpaque(false);
//        setContentAreaFilled(false);
//        setContentAreaFilled(false);
//        setBackground(Color.BLUE);
//        setUI(new BasicButtonUI() {
//            @Override
//            public void update(Graphics g, JComponent c) {
//
////                setFocusPainted(false);
//                if (c.isOpaque()) {
////                    g.clearRect(0, 0, c.getWidth(),c.getHeight());
//                    Color fillColor = c.getBackground();
//
//                    AbstractButton button = (AbstractButton) c;
//                    ButtonModel model = button.getModel();
//
//                    if (model.isPressed()) {
//                        fillColor = fillColor.darker();
//                    } else if (model.isRollover()) {
//                        fillColor = fillColor.brighter();
//                    }
//
//                    g.setColor(fillColor);
//                    g.fillRoundRect(0, 0, c.getWidth(),c.getHeight(), 55, 55);
//
//                }
//                paint(g, c);
//            }
//        });
//        animation = new Animation(this);

    }
//    @Override
//    protected void paintComponent(Graphics gd) {
//        super.paintComponent(gd);
//
//        Area area = new Area(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(),20, 20));
//        GradientPaint gp = new GradientPaint(
//                0, 0, Color.white,
//                0, 20, Color.white);
//        Graphics2D g = (Graphics2D)gd;
//
//        g.setPaint( gp );
////        area.subtract(new Area(new RoundRectangle2D.Float(10, 10, getWidth() - 20, getHeight() - 20, 20, 20)));
//
//        Graphics2D g2d = (Graphics2D) g.create();
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g2d.setColor(Color.BLACK);
//        g2d.fill(area);
//        g2d.dispose();
//    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        var x = 0;
        var y = 0;
        Graphics2D g2 = (Graphics2D)g;
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(x, y, getWidth(), getHeight(), 10, 10);
        g2.fill(roundedRectangle);
        RoundRectangle2D roundedRectangle2 = new RoundRectangle2D.Float(x + 5, y + 5, getWidth() - 10, getHeight() - 10, 10, 10);
        g2.fill(roundedRectangle2);
    }

//    @Override
//    protected void paintComponent(Graphics grphcs) {
//        super.paintComponent(grphcs);
//        animation.paint(grphcs);
//    }
//
//    @Override
//    protected void paintBorder(Graphics g) {
//        super.paintBorder(g);
//        animation.paint2(g);
//    }
}
