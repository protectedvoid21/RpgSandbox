package gui.customUI.customUIStyles.borderStrategies;

import javax.swing.*;

public interface IBorderStrategy {
    double convertTOPBorderSizeToValue(JComponent c, double offSetValue);
    double convertSIDEBorderSizeToValue(JComponent c, double offSetValue);
    double convertTOPBorderSizeToPercentValue(JComponent c, double offSetValue);
    double convertSIDEBorderSizeToPercentValue(JComponent c, double offSetValue);
}
