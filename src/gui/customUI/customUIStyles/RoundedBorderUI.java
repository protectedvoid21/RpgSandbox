package gui.customUI.customUIStyles;

import javax.swing.*;
import java.awt.*;

public class RoundedBorderUI extends BorderUI {
    final private int arcWidth;

    public RoundedBorderUI(int offSet, int arcWidth) {
        super(offSet);
        this.arcWidth = arcWidth;

    }

    public RoundedBorderUI() {
        this(6, 10);
    }

    public void paintBackground(Graphics g, JComponent c, int yOffset) {
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(getAdditionalColor(Index.FIRST));
        g.fillRoundRect(0, 0, size.width, size.height, arcWidth, arcWidth);
        g.setColor(getAdditionalColor(Index.BASE_BACKGROUND));
        g.fillRoundRect(yOffset, yOffset, size.width - 2 * yOffset, size.height - 2 * yOffset, arcWidth, arcWidth);
    }
}
