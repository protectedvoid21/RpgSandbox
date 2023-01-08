package gui.customUI.wrapers;

import gui.customUI.interfaces.ICustomUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Wraper which provides possibility of changing borders color when mouse presses component. It uses Index.SECOND
 * enum to specifies color which should be applied during this activity
 */
public class ChangingBorderColorWraper extends BorderDecorator {
    private Color currentBaseBackgroundHelper;

    public ChangingBorderColorWraper(ICustomUI ui) {
        super(ui);
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (c.isEnabled()) {
                    currentBaseBackgroundHelper = getAdditionalColor(Index.FIRST);
                    setAdditionaldColor(getAdditionalColor(Index.SECOND), Index.FIRST);
                    c.repaint();
                    c.revalidate();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mousePressed(e);
//                if (c.isEnabled()) {
                    setAdditionaldColor(currentBaseBackgroundHelper, Index.FIRST);
//                    currentBaseBackgroundHelper = null;
                    c.repaint();
                    c.revalidate();
//                }
            }
        });
    }
}
