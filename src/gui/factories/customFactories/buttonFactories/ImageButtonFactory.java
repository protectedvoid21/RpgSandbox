package gui.factories.customFactories.buttonFactories;

/**
 * Abstract button factory for every button factory which use ImageBorderWraper. Contains some attributes which help
 * with scaling images to button size. They can be passed by client in constructor method.
 */
public abstract class ImageButtonFactory implements ButtonFactory {
    protected double scalingSizeValue;
    protected double scalingPositionValue;
    protected boolean isScaled = false;

    public ImageButtonFactory(double scalingSizeValue, double scalingPositionValue) {
        isScaled = true;
        this.scalingPositionValue = scalingPositionValue;
        this.scalingSizeValue = scalingSizeValue;
    }

    public ImageButtonFactory() {
    }
}
