package gui.factories.customFactories.labelFactories;

import gui.customComponents.CustomLabel;
import gui.customUI.componentsUIs.CustomLabelUI;
import gui.customUI.customUIStyles.ThreeDUI;
import gui.customUI.interfaces.ICustomUI;
import gui.customUI.wrapers.DarkerHoverComponentWraper;

import javax.swing.*;
import java.awt.*;

/**
 * Implementation of label factory which cretes specific kind of winter label (only for testing and to show
 * possibilities of using factories for creating new objects). It is created based on implementation of
 * ThreeDUI class. It is simple 3D CustomUI implementation . Also this label contains few more features like changing
 * color when hovering, setting text in middle of component.
 */
public class WinterDarkerBackgroundLabelFactory implements ILabelFactory {
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
