package gui.customUI.wrapers;

import gui.customUI.interfaces.ICustomUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DarkerHoverComponentWraper extends RoundedBorderDecorator{
    private Color currentBaseBackgroundHelper;
    public DarkerHoverComponentWraper(ICustomUI ui) {
        super(ui);
    }
    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                currentBaseBackgroundHelper = getAdditionalColor(Index.BASE_BACKGROUND);
                setAdditionaldColor(getAdditionalColor(Index.BASE_BACKGROUND).darker(), Index.BASE_BACKGROUND);
                c.repaint();
                c.revalidate();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setAdditionaldColor(currentBaseBackgroundHelper, Index.BASE_BACKGROUND);
                currentBaseBackgroundHelper = null;
                c.repaint();
                c.revalidate();
            }
        });
    }
}
