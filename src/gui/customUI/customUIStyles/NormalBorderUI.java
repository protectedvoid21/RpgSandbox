package gui.customUI.customUIStyles;

import gui.customUI.customUIStyles.borderStrategies.IBorderStrategy;
import gui.customUI.interfaces.ICustomUI;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

/**Normal border style UI, creates to generalize style of UI and components in app */
public class NormalBorderUI extends CustomUI {
    public NormalBorderUI(IBorderStrategy strategy, int offSet) {
        super(strategy, offSet);
    }

    public NormalBorderUI(IBorderStrategy strategy) {
        super(strategy);
    }

    public void paintBackground(Graphics g, JComponent c, int Offset) {
        var yOffset = (int)convertTopBorderSizeToValue(c, Offset);
        var xOffset = (int)convertSideBorderSizeToValue(c, Offset);
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(getAdditionalColor(ICustomUI.Index.FIRST));
        g.fillRect(0, 0, size.width, size.height);
        g.setColor(getAdditionalColor(ICustomUI.Index.BASE_BACKGROUND));
        g.fillRect(xOffset, yOffset, size.width - 2 * xOffset, size.height - 2 * yOffset);

        if (isBackgroundTransparent()) {
            createTransparentRectangle(new Rectangle2D.Double(0, 0, size.width, size.height)
                    , new Rectangle2D.Double(xOffset, yOffset, size.width - 2 * xOffset,
                            size.height - 2 * yOffset), g2);
        } else {
            g.fillRect(0, 0, size.width, size.height);
            g.setColor(getAdditionalColor(ICustomUI.Index.BASE_BACKGROUND));
            g.fillRect(xOffset, yOffset, size.width - 2 * xOffset, size.height - 2 * yOffset);
        }
    }
}
