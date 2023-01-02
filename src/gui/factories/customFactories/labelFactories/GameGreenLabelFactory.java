package gui.factories.customFactories.labelFactories;

import gui.customComponents.AbstractCustomLabel;
import gui.customComponents.CustomLabel;
import gui.customComponents.iconComponents.IconLabel;
import gui.customUI.componentsUIs.CustomLabelUI;
import gui.customUI.customUIStyles.RoundedBorderUI;
import gui.customUI.interfaces.ICustomUI;
import gui.customUI.wrapers.EnteredChangingBorderColorWraper;
import gui.factories.GuiFactory;
import gui.margin.ComponentTextMarginManager;

import javax.swing.*;
import java.awt.*;

public class GameGreenLabelFactory extends LabelFactory {

    private AbstractCustomLabel helpCreatedMethod(AbstractCustomLabel label){
        label.setForeground(new Color(0xFFFBFB));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(font);
        var uiHelper = new RoundedBorderUI(strategy, 5, 10);
        label.setBackground(new Color(0x1F3617));
        uiHelper.setAdditionaldColor(new Color(0x0F2672), ICustomUI.Index.FIRST);
        var ui2 = new CustomLabelUI(uiHelper);
        label.setUI(ui2);
        label.setMaximumFontSizeStatus(true);
        ui2.getCustomUI().setRespectionBorder(true);
        ui2.getMargin().set(0, 30, 10, 0);
        return label;
    }

    public  AbstractCustomLabel createNormalLabel(String text){
        return helpCreatedMethod(new CustomLabel(text));
    }
    public  AbstractCustomLabel createIconPropLabel(String path){
        var label = helpCreatedMethod(new IconLabel(path, true));
        label.getCustomUI().setBackGroundTransparent(true);
//        label.getLabelUI().getCustomUI().setRespectionBorder(false);
        return label;
    }
    public  AbstractCustomLabel createIconStretchLabel(String path){
        var label = helpCreatedMethod(new IconLabel(path, false));
        label.getCustomUI().setRespectionBorder(false);
        return label;
    }
}
