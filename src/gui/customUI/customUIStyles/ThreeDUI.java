package gui.customUI.customUIStyles;

import gui.customUI.customUIStyles.borderStrategies.IBorderStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

/**3D (really?) border UI*/
public class ThreeDUI extends CustomUI{
    public ThreeDUI(IBorderStrategy strategy, int offSet) {
        super(strategy, offSet);
    }

    public ThreeDUI(IBorderStrategy strategy) {
        super(strategy);
    }
    @Override
    public void paintBackground(Graphics g, JComponent c, int Offset) {
        var yOffset = (int)convertTopBorderSizeToValue(c, Offset);
        var xOffset = (int)convertSideBorderSizeToValue(c, Offset);
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getAdditionalColor(Index.FIRST));
        g2.fill3DRect(0, 0, size.width, size.height, true);
        g2.setColor(getAdditionalColor(Index.BASE_BACKGROUND));
        g2.fill3DRect(xOffset, yOffset, size.width - 2 * xOffset, size.height - 2 * yOffset, true);

        if (isBackgroundTransparent()) {
            createTransparentRectangle(new Rectangle2D.Double(0, 0, size.width, size.height)
                    , new Rectangle2D.Double(xOffset, yOffset, size.width - 2 * xOffset,
                            size.height - 2 * yOffset), g2);
        } else {
            g2.fill3DRect(0, 0, size.width, size.height, true);
            g2.setColor(getAdditionalColor(Index.BASE_BACKGROUND));
            g2.fill3DRect(xOffset, yOffset, size.width - 2 * xOffset, size.height - 2 * yOffset, true);
        }

    }
}
