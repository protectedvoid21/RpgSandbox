package gui.customUI.wrapers;

import gui.customUI.interfaces.ICustomUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChangingBackgroundColorWraper extends RoundedBorderDecorator {
    private Color currentBaseBackgroundHelper;


    public ChangingBackgroundColorWraper(ICustomUI ui) {
        super(ui);
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                currentBaseBackgroundHelper = getAdditionalColor(Index.BASE_BACKGROUND);
                setAdditionaldColor(getAdditionalColor(Index.THIRD), Index.BASE_BACKGROUND);
                super.mousePressed(e);
                c.repaint();
                c.revalidate();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setAdditionaldColor(currentBaseBackgroundHelper, Index.BASE_BACKGROUND);
                currentBaseBackgroundHelper = null;
                super.mousePressed(e);
                c.repaint();
                c.revalidate();
            }
        });
    }
}
