package gui.customUI.customUIStyles.borderStrategies;

import javax.swing.*;

public class DependantHeightBorderStrategy implements IBorderStrategy{
    @Override
    public double convertTOPBorderSizeToValue(JComponent c, double offSetValue) {
        return getHelpValue(c, offSetValue);
    }

    @Override
    public double convertSIDEBorderSizeToValue(JComponent c, double offSetValue) {
        return getHelpValue(c, offSetValue);
    }
    private double getHelpValue(JComponent c, double offSetValue){
        return  (offSetValue*c.getHeight())/100;
    }
    @Override
    public double convertTOPBorderSizeToPercentValue(JComponent c, double offSetValue) {
        return convertTOPBorderSizeToValue(c, offSetValue)/c.getHeight()*100;
    }

    @Override
    public double convertSIDEBorderSizeToPercentValue(JComponent c, double offSetValue) {
        return convertSIDEBorderSizeToValue(c, offSetValue)/c.getWidth()*100;
    }
}
