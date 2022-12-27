package gui.factories.customFactories.labelFactories;

import gui.customComponents.CustomLabel;
import gui.customUI.componentsUIs.CustomLabelUI;
import gui.customUI.customUIStyles.NormalBorderUI;
import gui.customUI.customUIStyles.RoundedBorderUI;
import gui.customUI.customUIStyles.ThreeDUI;
import gui.customUI.interfaces.ICustomUI;
import gui.customUI.wrapers.DarkerHoverComponentWraper;
import gui.factories.customFactories.labelFactories.LabelFactory;

import javax.swing.*;
import java.awt.*;

public class WinterDarkerBackgroundLabelFactory implements LabelFactory {
    @Override
    public JLabel create(String text) {
        var label = new CustomLabel(text);
        label.setForeground(new Color(0xFFFBFB));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        var uiHelper = new ThreeDUI(6);
        label.setBackground(new Color(0x3994D3));
        uiHelper.setAdditionaldColor(new Color(0x720F14), ICustomUI.Index.FIRST);
        var ui2 = new CustomLabelUI(new DarkerHoverComponentWraper(uiHelper));
        label.setUI(ui2);
        return label;
    }
}
