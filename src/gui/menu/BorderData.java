package gui.menu;

import gui.customUI.customUIStyles.borderStrategies.DefaultBorderStrategy;
import gui.customUI.customUIStyles.borderStrategies.IBorderStrategy;

import java.awt.*;

public class BorderData {
    public IBorderStrategy borderStrategy;
    public double borderValue = 0;
    public Color borderColor;

    public BorderData(IBorderStrategy borderStrategy, double borderValue, Color borderColor) {
        this.borderStrategy = borderStrategy;
        this.borderValue = borderValue;
        this.borderColor = borderColor;
    }
    public BorderData(){
        this.borderStrategy = new DefaultBorderStrategy();
        this.borderValue = 0;
        this.borderColor = null;
    }
}
