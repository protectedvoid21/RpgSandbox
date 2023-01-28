package gui.customUI.wrapers;

import gui.customUI.interfaces.ICustomUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Wraper which changes background color when mouse is hovering component. New color is dependant on previous
 * background color of component, it is always its darker variety.
 */
public class DarkerHoverComponentWraper extends BorderDecorator {
    private Color currentBaseBackgroundHelper;

    public DarkerHoverComponentWraper(ICustomUI ui) {
        super(ui);
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                setAdditionaldColor(currentBaseBackgroundHelper, Index.BASE_BACKGROUND);
                c.repaint();
                c.revalidate();
            }
        });

        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (isOn()) {
                    currentBaseBackgroundHelper = getAdditionalColor(Index.BASE_BACKGROUND);
                    setAdditionaldColor(getAdditionalColor(Index.BASE_BACKGROUND).darker(), Index.BASE_BACKGROUND);
                    c.repaint();
                    c.revalidate();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setAdditionaldColor(currentBaseBackgroundHelper, Index.BASE_BACKGROUND);
                c.repaint();
                c.revalidate();
            }
        });
    }
}
