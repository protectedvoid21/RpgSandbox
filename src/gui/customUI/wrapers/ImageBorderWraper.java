package gui.customUI.wrapers;

import gui.customUI.interfaces.ICustomUI;
import gui.customUI.interfaces.IRequieredReactionOnMovementComponent;
import gui.customUI.interfaces.IMovementComponent;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Wrapper which can creates two images on component. Their position can be automatic calculated (sometimes it can be
 * a bit suprising...ususally) but also user can specife scalingPositionValue and scalingSizeValue. First attribute
 * determines how far from the edge is this image. Second is used for defining size of imeges. Each value is
 * dependant on smaller of values : width, height of component. To get know whole algorithm I recommend to see
 * paintBackground method. Good luck! :) It will some someone task to make this method simpler...
 */
public class ImageBorderWraper extends BorderDecorator implements IRequieredReactionOnMovementComponent {
    private Image img;
    private Image secondImg;
    private int componentMovement = 0;
    private IMovementComponent.Direction direction;
    private double scalingPositionValue = 0;
    private double scalingSizeValue = 0;
    private boolean scalingStatus = false;


    public ImageBorderWraper(ICustomUI ui, String pathFirstImage) {
        this(ui, pathFirstImage, null);
    }

    public ImageBorderWraper(ICustomUI ui, String pathFirstImage, String pathSecondImage) {
        super(ui);
        img = createImage(pathFirstImage);
        var result = createImage(pathSecondImage);
        secondImg = result == null ? img : result;
    }


    public Image createImage(String path) {
        try {
            var img = ImageIO.read(new File(path));
            return img;
        } catch (IOException | NullPointerException e) {
            return null;
        }
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        paintBackground(g, c, getBorderSize());
    }

//    private void doHelpActivity(Graphics g, double sizeX, double sizeY, double positionX, double positionY) {
//        g.drawImage(img.getScaledInstance((int) (sizeX), (int) (sizeY), Image.SCALE_SMOOTH), (int) positionX, (int)
//        positionY, null);
//    }

    @Override//to refactor
    public void paintBackground(Graphics g, JComponent c, int yOffset) {//zrefactoryzowac i dorzucic jakos zmiany
        // pozycji x na start
        super.paintBackground(g, c, yOffset);
        var w = c.getWidth();
        var h = c.getHeight();

        double scaleFirstImg = img.getWidth(null) / img.getHeight(null);
        double scaleSecondImg = secondImg.getWidth(null) / secondImg.getHeight(null);

        var horizontalMovement = direction == IMovementComponent.Direction.HORIZONTAL ? componentMovement : 0;
        var verticalMovement = direction == IMovementComponent.Direction.VERTICAL ? componentMovement : 0;
        if (!scalingStatus) {
            if (w > h) {
                if (w > 3 * h) {
                    g.drawImage(img.getScaledInstance((int) (scaleFirstImg * 0.8 * h), (int) (0.8 * h),
                                    Image.SCALE_SMOOTH),
                            (int) (0.2 * h) + horizontalMovement, (int) (0.1 * h) + verticalMovement, null);
                    g.drawImage(secondImg.getScaledInstance((int) (scaleSecondImg * 0.8 * h), (int) (0.8 * h),
                                    Image.SCALE_SMOOTH),
                            (int) (w - (scaleSecondImg * 0.8 * h + 0.2 * h)) - horizontalMovement,
                            (int) (0.1 * h) + verticalMovement, null);
                } else {
                    g.drawImage(img.getScaledInstance((int) (scaleFirstImg * 0.4 * h), (int) (0.4 * h),
                                    Image.SCALE_SMOOTH),
                            (int) (0.05 * h) + horizontalMovement, (int) (0.3 * h) + verticalMovement, null);
                    g.drawImage(secondImg.getScaledInstance((int) (scaleSecondImg * 0.4 * h), (int) (0.4 * h),
                                    Image.SCALE_SMOOTH),
                            (int) (w - (0.4 * h * scaleSecondImg + 0.05 * h)) - horizontalMovement,
                            (int) (0.3 * h) + verticalMovement, null);
                }
            } else {
                if (h > 3 * w) {
                    g.drawImage(img.getScaledInstance((int) (0.8 * w), (int) (0.8 * w / scaleFirstImg),
                                    Image.SCALE_SMOOTH),
                            (int) (0.1 * w) + horizontalMovement, (int) (0.2 * w) + verticalMovement, null);
                    g.drawImage(secondImg.getScaledInstance((int) (0.8 * w), (int) (0.8 * w / scaleSecondImg),
                                    Image.SCALE_SMOOTH),
                            (int) (0.1 * w) + horizontalMovement,
                            (int) (h - (0.8 / scaleSecondImg * w + 0.2 * w)) + verticalMovement, null);
                } else {
                    g.drawImage(img.getScaledInstance((int) (0.4 * w), (int) (0.4 * w / scaleFirstImg),
                                    Image.SCALE_SMOOTH),
                            (int) (0.3 * w) + horizontalMovement, (int) (0.05 * w) + verticalMovement, null);
                    g.drawImage(secondImg.getScaledInstance((int) (0.4 * w), (int) (0.4 * w / scaleSecondImg),
                                    Image.SCALE_SMOOTH),
                            (int) (0.3 * w) + horizontalMovement,
                            (int) (h - (0.4 * w / scaleSecondImg + 0.05 * w)) + verticalMovement, null);
                }
            }
        } else {//to fix
            if (w > h) {
                g.drawImage(img.getScaledInstance((int) (scalingSizeValue * h * scaleFirstImg),
                                (int) (scalingSizeValue * h),
                                Image.SCALE_SMOOTH), (int) (scalingPositionValue * h) + horizontalMovement,
                        (int) (0.5 * (1 - scalingSizeValue) * h) + verticalMovement, null);
                g.drawImage(secondImg.getScaledInstance((int) (scalingSizeValue * h * scaleSecondImg),
                                (int) (scalingSizeValue * h),
                                Image.SCALE_SMOOTH),
                        (int) (w - ((scalingPositionValue + scaleSecondImg * scalingSizeValue) * h)) - horizontalMovement,
                        (int) (0.5 * (1 - scalingSizeValue) * h) + verticalMovement, null);
            } else {
                g.drawImage(img.getScaledInstance((int) (scalingSizeValue * w),
                                (int) (scalingSizeValue * w / scaleFirstImg),
                                Image.SCALE_SMOOTH), (int) (0.5 * (1 - scalingSizeValue) * w) + horizontalMovement,
                        (int) (scalingPositionValue * w) + verticalMovement, null);
                g.drawImage(secondImg.getScaledInstance((int) (scalingSizeValue * w),
                                (int) (scalingSizeValue * w / scaleSecondImg),
                                Image.SCALE_SMOOTH), (int) (0.5 * (1 - scalingSizeValue) * w) + horizontalMovement,
                        (int) (h - ((scalingPositionValue + scalingSizeValue / scaleSecondImg) * w)) + verticalMovement, null);
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

    public void setScalingValue(double scalingSizeValue, double scalingPositionValue) {
        this.scalingSizeValue = scalingSizeValue;
        this.scalingPositionValue = scalingPositionValue;
    }
}
