package gui.factories.customFactories;

import gui.customUI.customUIStyles.borderStrategies.IBorderStrategy;

import java.awt.*;

public abstract class ComponentFactory {
    protected Font font = new Font("Helvetica", Font.PLAIN, 14);
    protected IBorderStrategy strategy;

    public void setFont(Font font) {
        this.font = font;
    }
    public void setStrategy(IBorderStrategy strategy){
        this.strategy = strategy;
    }
}
