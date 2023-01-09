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

    public void setScalingSizeValue(double scalingSizeValue) {
        this.scalingSizeValue = scalingSizeValue;
    }

    public void setScalingPositionValue(double scalingPositionValue) {
        this.scalingPositionValue = scalingPositionValue;
    }

    public void setScaled(boolean scaled) {
        isScaled = scaled;
    }
}