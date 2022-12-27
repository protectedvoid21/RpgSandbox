package gui.customUI.customUIStyles;

import gui.customUI.interfaces.ICustomUI;

import javax.swing.*;
import java.awt.*;

public class NormalBorderUI extends BorderUI {
    public NormalBorderUI(int offSet) {
        super(offSet);
    }

    public NormalBorderUI() {
        super();
    }

    public void paintBackground(Graphics g, JComponent c, int yOffset) {
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(getAdditionalColor(ICustomUI.Index.FIRST));
        g.fillRect(0, 0, size.width, size.height);
        g.setColor(getAdditionalColor(ICustomUI.Index.BASE_BACKGROUND));
        g.fillRect(yOffset, yOffset, size.width - 2 * yOffset, size.height - 2 * yOffset);
    }
}
