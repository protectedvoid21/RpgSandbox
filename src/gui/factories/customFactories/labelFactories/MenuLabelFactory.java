package gui.factories.customFactories.labelFactories;

import gui.customComponents.AbstractCustomLabel;
import gui.customComponents.CustomLabel;
import gui.customComponents.iconComponents.IconLabel;
import gui.customUI.componentsUIs.CustomButtonUI;
import gui.customUI.componentsUIs.CustomLabelUI;
import gui.customUI.customUIStyles.RoundedBorderUI;
import gui.customUI.interfaces.ICustomUI;
import gui.customUI.wrapers.ChangingBorderColorWraper;
import gui.customUI.wrapers.DarkerHoverComponentWraper;
import gui.customUI.wrapers.ImageBorderWraper;

import javax.swing.*;
import java.awt.*;

public class MenuLabelFactory extends ImageLabelFactory {
    public MenuLabelFactory(double scalingSizeValue, double scalingPositionValue) {
        super(scalingSizeValue, scalingPositionValue);
    }

    private AbstractCustomLabel helpCreatedMethod(AbstractCustomLabel label) {
        label.setFont(font);
        label.setForeground(new Color(0x1C1515));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBackground(new Color(0x51813D));
        var ui = new RoundedBorderUI(strategy, 10, 10);
        var uiHelper = new ImageBorderWraper(ui, "src/gui/leftsword.png", "src/gui/rightsword.png");
        if (isScaled) {
            uiHelper.setScalingValue(scalingSizeValue, scalingPositionValue);
            uiHelper.setScalingStatus(true);
        }
        uiHelper.setAdditionaldColor(new Color(0x4D0202), ICustomUI.Index.FIRST);
        var ui2 = new CustomLabelUI(uiHelper);
        label.setUI(ui2);
        label.setMaximumFontSizeStatus(true);
        label.getCustomUI().getMargin().set(10, 20, 10, 20);
        ui2.getCustomUI().setRespectionBorder(true);
        return label;
    }

    public AbstractCustomLabel createNormalLabel(String text) {
        return helpCreatedMethod(new CustomLabel(text));
    }

    public AbstractCustomLabel createIconPropLabel(String path) {
        var label = helpCreatedMethod(new IconLabel(path, true));
        label.getCustomUI().setBackGroundTransparent(true);
//        label.getLabelUI().getCustomUI().setRespectionBorder(false);
        return label;
    }

    public AbstractCustomLabel createIconStretchLabel(String path) {
        var label = helpCreatedMethod(new IconLabel(path, false));
        label.getCustomUI().setRespectionBorder(false);
        return label;
    }
}