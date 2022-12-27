package gui.factories.customFactories.buttonFactories;

public abstract class ImageButtonFactory implements ButtonFactory {
    protected double scalingSizeValue;
    protected double scalingPositionValue;
    protected boolean isScaled = false;

    public ImageButtonFactory(double scalingSizeValue, double scalingPositionValue) {
        isScaled = true;
        this.scalingPositionValue = scalingPositionValue;
        this.scalingSizeValue = scalingSizeValue;
    }

    public ImageButtonFactory(){}
}
