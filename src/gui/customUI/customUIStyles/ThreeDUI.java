package gui.customUI.customUIStyles;

import javax.swing.*;
import java.awt.*;

/**3D (really?) border UI*/
public class ThreeDUI extends BorderUI{
    public ThreeDUI(int offSet) {
        super(offSet);
    }

    public ThreeDUI() {
        super();
    }
    @Override
    public void paintBackground(Graphics g, JComponent c, int yOffset) {
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getAdditionalColor(Index.FIRST));
        g2.fill3DRect(0, 0, size.width, size.height, true);
        g2.setColor(getAdditionalColor(Index.BASE_BACKGROUND));
        g2.fill3DRect(yOffset, yOffset, size.width - 2 * yOffset, size.height - 2 * yOffset, true);

    }
}
