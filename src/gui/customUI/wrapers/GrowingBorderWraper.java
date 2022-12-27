package gui.customUI.wrapers;

import gui.customUI.interfaces.ICustomUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GrowingBorderWraper extends RoundedBorderDecorator {
    private boolean componentHovered = false;

    public GrowingBorderWraper(ICustomUI ui){
        super(ui);
    }

    @Override
    public void installUI(JComponent c) {
       super.installUI(c);
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                componentHovered = true;
                c.repaint();
                c.revalidate();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                componentHovered = false;
                c.repaint();
                c.revalidate();
            }
        });
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        paintBackground(g, c, getBorderSize());
    }

    @Override
    public int getBorderSize() {
        return componentHovered ? 2*super.getBorderSize() : (int) (super.getBorderSize());
    }
}
