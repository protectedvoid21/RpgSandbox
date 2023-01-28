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
import gui.factories.TextData;
import gui.factories.WarhammerData;
import gui.utils.StringAdapter;

import javax.swing.*;
import java.awt.*;

public class MenuLabelFactory extends ImageLabelFactory implements WarhammerData {
    private String pathLeft = "";
    private String pathRight = smallSward3;

    public MenuLabelFactory(double scalingSizeValue, double scalingPositionValue) {
        super(scalingSizeValue, scalingPositionValue);
    }


    private AbstractCustomLabel helpCreatedMethod(AbstractCustomLabel label) {
        label.setFont(font);
        label.setForeground(new Color(0x1C1515));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBackground(new Color(0x51813D));
        var ui = new RoundedBorderUI(strategy, 7, 10);
        CustomLabelUI ui2;
        if (!pathLeft.isEmpty() && !pathRight.isEmpty()) {
            var uiHelper = new ImageBorderWraper(ui, pathLeft, pathRight);
            if (isScaled) {
                uiHelper.setScalingValue(scalingSizeValue, scalingPositionValue);
                uiHelper.setScalingStatus(true);
            }
            ui2 = new CustomLabelUI(uiHelper);
        } else {
            ui2 = new CustomLabelUI(ui);
        }
        ui.setAdditionaldColor(new Color(0x4D0202), ICustomUI.Index.FIRST);
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
        return label;
    }

    public AbstractCustomLabel createIconStretchLabel(String path) {
        var label = helpCreatedMethod(new IconLabel(path, false));
        label.getCustomUI().setRespectionBorder(false);
        return label;
    }

    public void setPaths(String pathLeft, String pathRight) {
        this.pathLeft = pathLeft;
        this.pathRight = pathRight;
    }

}