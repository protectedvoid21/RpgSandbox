package gui.factories;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.LabelUI;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StyledLabelUI extends BasicLabelUI {
    private boolean componentHovered = false;

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                componentHovered = true;
                c.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                componentHovered = false;
                c.repaint();
            }
        });
        c.setOpaque(false);
//        c.setBorder(new EmptyBorder(5, 15, 5, 15));
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        var b = (JLabel) c;
        paintBackground(g, b, componentHovered ? 5 : 3);
        super.paint(g, c);
    }

    private void paintBackground(Graphics g, JComponent c, int yOffset) {
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(c.getBackground().darker());
        g.fillRoundRect(0, 0, size.width, size.height , 10, 10);
        g.setColor(c.getBackground());
        g.fillRoundRect(yOffset, yOffset, size.width-2*yOffset, size.height -2*yOffset, 10, 10);
    }
}
