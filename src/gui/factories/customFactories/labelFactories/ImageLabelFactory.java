package gui.factories.customFactories.labelFactories;

import gui.factories.customFactories.buttonFactories.ButtonFactory;

public abstract class ImageLabelFactory extends LabelFactory {
    protected double scalingSizeValue;
    protected double scalingPositionValue;
    protected boolean isScaled = false;

    public ImageLabelFactory(double scalingSizeValue, double scalingPositionValue) {
        isScaled = true;
        this.scalingPositionValue = scalingPositionValue;
        this.scalingSizeValue = scalingSizeValue;
    }

    public ImageLabelFactory() {
    }
}