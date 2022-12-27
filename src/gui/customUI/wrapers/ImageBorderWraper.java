package gui.customUI.wrapers;

import gui.customUI.interfaces.ICustomUI;
import gui.customUI.interfaces.IRequieredReactionOnMovementComponent;
import gui.customUI.interfaces.IMovementComponent;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageBorderWraper extends RoundedBorderDecorator implements IRequieredReactionOnMovementComponent {
    private Image img;
    private int componentMovement = 0;
    private IMovementComponent.Direction direction;
    private double scalingValue = 0;
    private boolean scalingStatus = false;

    public ImageBorderWraper(ICustomUI ui, String path) {
        super(ui);
        uploadImage(path);
    }


    public void uploadImage(String path) {
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            img = null;
        }
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        paintBackground(g, c, getBorderSize());
    }

    @Override//to do for every shape
    public void paintBackground(Graphics g, JComponent c, int yOffset) {//zrefactoryzowac i dorzucic jakos zmiany pozycji x na start
        super.paintBackground(g, c, yOffset);
        var w = c.getWidth();
        var h = c.getHeight();
        var horizontalMovement = direction == IMovementComponent.Direction.HORIZONTAL ? componentMovement : 0;
        var verticalMovement = direction == IMovementComponent.Direction.VERTICAL ? componentMovement : 0;
        if (!scalingStatus) {
            if (w > h) {
                if (w > 3 * h) {
                    g.drawImage(img.getScaledInstance((int) (0.8 * h), (int) (0.8 * h), Image.SCALE_DEFAULT), (int) (0.2 * h) + horizontalMovement, (int) (0.1 * h) + verticalMovement, null);
                    g.drawImage(img.getScaledInstance((int) (0.8 * h), (int) (0.8 * h), Image.SCALE_DEFAULT), (int) (w - (1 * h)) - horizontalMovement, (int) (0.1 * h) + verticalMovement, null);
                } else {
                    g.drawImage(img.getScaledInstance((int) (0.4 * h), (int) (0.4 * h), Image.SCALE_DEFAULT), (int) (0.05 * h) + horizontalMovement, (int) (0.3 * h) + verticalMovement, null);
                    g.drawImage(img.getScaledInstance((int) (0.4 * h), (int) (0.4 * h), Image.SCALE_DEFAULT), (int) (w - (0.45 * h)) - horizontalMovement, (int) (0.3 * h) + verticalMovement, null);
                }
            } else {
                if (h > 3 * w) {
                    g.drawImage(img.getScaledInstance((int) (0.8 * w), (int) (0.8 * w), Image.SCALE_DEFAULT), (int) (0.1 * w) + horizontalMovement, (int) (0.2 * w) + verticalMovement, null);
                    g.drawImage(img.getScaledInstance((int) (0.8 * w), (int) (0.8 * w), Image.SCALE_DEFAULT), (int) (0.1 * w) + horizontalMovement, (int) (h - (w)) + verticalMovement, null);
                } else {
                    g.drawImage(img.getScaledInstance((int) (0.4 * w), (int) (0.4 * w), Image.SCALE_DEFAULT), (int) (0.3 * w) + horizontalMovement, (int) (0.05 * w) + verticalMovement, null);
                    g.drawImage(img.getScaledInstance((int) (0.4 * w), (int) (0.4 * w), Image.SCALE_DEFAULT), (int) (0.3 * w) + horizontalMovement, (int) (h - (0.45 * w)) + verticalMovement, null);
                }
            }
        } else {//to fix
            if (w > h) {
                g.drawImage(img.getScaledInstance((int) (scalingValue * h), (int) (scalingValue * h), Image.SCALE_DEFAULT), (int) (0.1 * h) + horizontalMovement, (int) (0.5*scalingValue * h) + verticalMovement, null);
                g.drawImage(img.getScaledInstance((int) (scalingValue * h), (int) (scalingValue * h), Image.SCALE_DEFAULT), (int) (w - ((scalingValue + 0.1) * h)) - horizontalMovement, (int) (0.5*scalingValue * h) + verticalMovement, null);
            } else {
                g.drawImage(img.getScaledInstance((int) (scalingValue * w), (int) (scalingValue * w), Image.SCALE_DEFAULT), (int) (0.1 * w) + horizontalMovement, (int) (0.05 * w) + verticalMovement, null);
                g.drawImage(img.getScaledInstance((int) (scalingValue * w), (int) (scalingValue * w), Image.SCALE_DEFAULT), (int) (0.1 * w) + horizontalMovement, (int) (h - ((0.05 + scalingValue) * w)) + verticalMovement, null);
            }
        }

    }

    public void setComponentMovementValue(int value) {
        componentMovement = value;
    }

    @Override
    public void setComponentDirection(IMovementComponent.Direction direction) {
        this.direction = direction;
    }

    public void setScalingStatus(boolean scalingStatus) {
        this.scalingStatus = scalingStatus;
    }

    public void setScalingValue(double scalingValue) {
        this.scalingValue = scalingValue;
    }
}
