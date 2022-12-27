package gui.customUI.wrapers;

import gui.customUI.interfaces.ICustomUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChangingBorderColorWraper extends RoundedBorderDecorator {
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
                currentBaseBackgroundHelper = getAdditionalColor(Index.FIRST);
                setAdditionaldColor(getAdditionalColor(Index.SECOND), Index.FIRST);
                c.repaint();
                c.revalidate();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mousePressed(e);
                setAdditionaldColor(currentBaseBackgroundHelper, Index.FIRST);
                currentBaseBackgroundHelper = null;
                c.repaint();
                c.revalidate();
            }
        });
    }
}
