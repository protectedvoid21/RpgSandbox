package gui.customUI.customUIStyles;

import gui.customUI.customUIStyles.borderStrategies.IBorderStrategy;
import gui.customUI.interfaces.ICustomUI;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class DoubleRoundRectangleUI extends CustomUI {
    final private int arcWidth;

    public DoubleRoundRectangleUI(IBorderStrategy strategy, int offSet, int arcWidth) {
        super(strategy, offSet);
        this.arcWidth = arcWidth;

    }

    public DoubleRoundRectangleUI(IBorderStrategy strategy) {
        this(strategy, 6, 10);
    }

    public void paintBackground(Graphics g, JComponent c, int Offset) {
       var yOffset = (int)convertTopBorderSizeToValue(c, Offset);
        var xOffset = (int)convertSideBorderSizeToValue(c, Offset);
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(getAdditionalColor(ICustomUI.Index.FIRST));

        if (isBackgroundTransparent()) {
            createTransparentRectangle(new RoundRectangle2D.Double(0, 0, size.width, size.height, arcWidth, arcWidth)
                    , new RoundRectangle2D.Double(xOffset, yOffset, size.width - 2 * xOffset,
                            size.height - 2 * yOffset, arcWidth, arcWidth), g2);
            g.setColor(getAdditionalColor(Index.FIFTH));
            createTransparentRectangle(new RoundRectangle2D.Double(xOffset, yOffset, size.width - 2 * xOffset,
                    size.height - 2 * yOffset, arcWidth, arcWidth), new RoundRectangle2D.Double(2 * xOffset,
                    2 * yOffset, size.width - 4 * xOffset,
                    size.height - 4 * yOffset, arcWidth, arcWidth), g2);
        } else {
            g.fillRoundRect(0, 0, size.width, size.height, arcWidth, arcWidth);
            g.setColor(getAdditionalColor(Index.FIFTH));
            g.fillRoundRect(xOffset, yOffset, size.width - 2 * xOffset, size.height - 2 * yOffset, arcWidth, arcWidth);
            g.setColor(getAdditionalColor(ICustomUI.Index.BASE_BACKGROUND));
            g.fillRoundRect(2*xOffset, 2*yOffset, size.width - 4 * xOffset, size.height - 4 * yOffset, arcWidth, arcWidth);
        }
    }

}
