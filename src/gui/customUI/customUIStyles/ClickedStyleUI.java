package gui.customUI.customUIStyles;

import gui.customUI.customUIStyles.borderStrategies.IBorderStrategy;
import gui.customUI.interfaces.IMovementComponent;
import gui.customUI.interfaces.IRequieredReactionOnMovementComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Specific UI used buttons.
 */
public class ClickedStyleUI extends CustomUI implements IMovementComponent {
    final private int arcWidth;
    private boolean isPressed = false;
    private ArrayList<IRequieredReactionOnMovementComponent> componentsList = new ArrayList<>();

    public ClickedStyleUI(IBorderStrategy strategy) {
        this(strategy, 10, 10);
    }

    public ClickedStyleUI(IBorderStrategy strategy, int offSet, int arcWidth) {
        super(strategy, offSet);
        this.arcWidth = arcWidth;
    }

    @Override
    public void installUI(JComponent c) {
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (c.isEnabled())
                    isPressed = true;
                c.repaint();
                c.revalidate();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                isPressed = false;
                c.repaint();
                c.revalidate();
            }
        });
        super.installUI(c);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        paintBackground(g, c, getBorderSize());
        super.paint(g, c);
    }

    public void paintBackground(Graphics g, JComponent c, int Offset) {
        var yOffset = (int) convertTopBorderSizeToValue(c, Offset) / 2;
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        var xx = isPressed ? yOffset : 0;
        notifyComponents(xx);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(getAdditionalColor(Index.FIRST));
        if (!isBackgroundTransparent()) {
            g.fillRoundRect(0, xx, size.width, size.height - xx, arcWidth, arcWidth);
            g.setColor(getAdditionalColor(Index.BASE_BACKGROUND));
            g.fillRoundRect(0, xx, size.width, size.height + xx - (2 * yOffset + 1), arcWidth, arcWidth);
        }
    }

    @Override
    public void notifyComponents(int offSetValue) {
        for (var component : componentsList) {
            component.setComponentMovementValue(offSetValue);
        }
    }

    @Override
    public void addComponent(IRequieredReactionOnMovementComponent component) {
        componentsList.add(component);
        component.setComponentDirection(Direction.VERTICAL);
    }
}