package gui.customComponents.iconComponents;

import gui.customUI.interfaces.IMovementComponent;
import gui.customUI.interfaces.IRequieredReactionOnMovementComponent;

import java.awt.*;
import java.awt.image.ImageObserver;
import javax.swing.*;

public class StretchIcon extends ImageIcon implements IRequieredReactionOnMovementComponent {

    protected boolean proportionate;
    private int componentMovement = 0;
    private IMovementComponent.Direction direction;
    private final String path;

    public StretchIcon(String filename) {
        this(filename, false);
    }

    public StretchIcon(String filename, boolean proportionate) {
        super(filename);
        this.path = filename;
        this.proportionate = proportionate;

    }

    public String getPath() {
        return path;
    }

    @Override
    public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
        var horizontalMovement = direction == IMovementComponent.Direction.HORIZONTAL ? componentMovement : 0;
        var verticalMovement = direction == IMovementComponent.Direction.VERTICAL ? componentMovement : 0;
        Image image = getImage();
        if (image == null) {
            return;
        }
        Insets insets = ((Container) c).getInsets();
        x = insets.left;
        y = insets.top;

        int w = c.getWidth() - x - insets.right;
        int h = c.getHeight() - y - insets.bottom;

        if (proportionate) {
            int iw = image.getWidth(c);
            int ih = image.getHeight(c);

            if (iw * h < ih * w) {
                iw = (h * iw) / ih;
                x += (w - iw) / 2;
                w = iw;
            } else {
                ih = (w * ih) / iw;
                y += (h - ih) / 2;
                h = ih;
            }
        }
        ImageObserver io = getImageObserver();
        g.drawImage(image, x + horizontalMovement, y + verticalMovement, w, h, io == null ? c : io);
    }

    public boolean isProportionate() {
        return proportionate;
    }

    @Override
    public int getIconWidth() {
        return 0;
    }

    @Override
    public int getIconHeight() {
        return 0;
    }

    public void setComponentMovementValue(int value) {
        componentMovement = value;
    }

    @Override
    public void setComponentDirection(IMovementComponent.Direction direction) {
        this.direction = direction;
    }
}