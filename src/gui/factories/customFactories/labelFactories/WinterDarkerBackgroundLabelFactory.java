package gui.factories.customFactories.labelFactories;

import gui.customComponents.AbstractCustomLabel;
import gui.customComponents.CustomLabel;
import gui.customComponents.iconComponents.IconLabel;
import gui.customUI.componentsUIs.CustomLabelUI;
import gui.customUI.customUIStyles.RoundedBorderUI;
import gui.customUI.customUIStyles.ThreeDUI;
import gui.customUI.interfaces.ICustomUI;
import gui.customUI.wrapers.DarkerHoverComponentWraper;
import gui.factories.GuiFactory;

import javax.swing.*;
import java.awt.*;

/**
 * Implementation of label factory which cretes specific kind of winter label (only for testing and to show
 * possibilities of using factories for creating new objects). It is created based on implementation of
 * ThreeDUI class. It is simple 3D CustomUI implementation . Also this label contains few more features like changing
 * color when hovering, setting text in middle of component.
 */
public class WinterDarkerBackgroundLabelFactory extends LabelFactory {

    private AbstractCustomLabel helpCreatedMethod(AbstractCustomLabel label){
        label.setFont(font);
        label.setForeground(new Color(0xFFFBFB));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        var uiHelper = new RoundedBorderUI( strategy,10, 10);
        label.setBackground(new Color(0x3994D3));
        uiHelper.setAdditionaldColor(new Color(0x720F14), ICustomUI.Index.FIRST);
        var ui2 = new CustomLabelUI(new DarkerHoverComponentWraper(uiHelper));
        ui2.getCustomUI().setFontMaximized(true);
        label.setUI(ui2);
        ui2.getCustomUI().setRespectionBorder(false);
//        ui2.getMargin().set(10, 10, 10, 10);


        return label;
    }
    @Override
    public AbstractCustomLabel createNormalLabel(String text) {
        var label =  helpCreatedMethod(new CustomLabel(text));
//        label.getLabelUI().getCustomUI().setRespectionBorder(false);
        label.getMargin().set(0, 0, 0, 0);
        return label;
    }

    @Override
    public AbstractCustomLabel createIconPropLabel(String path) {
        var label = helpCreatedMethod(new IconLabel(path, true));
        label.getMargin().set(0, 0, 0, 0);
        return label;
    }

    @Override
    public AbstractCustomLabel createIconStretchLabel(String path) {
        var label = helpCreatedMethod(new IconLabel(path, false));
        return label;
    }
}
