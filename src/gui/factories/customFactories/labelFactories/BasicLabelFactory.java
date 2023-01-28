package gui.factories.customFactories.labelFactories;

import gui.customComponents.abstractComponents.AbstractCustomLabel;
import gui.customComponents.baseCustomComponents.CustomLabel;
import gui.customComponents.iconComponents.IconLabel;
import gui.customUI.componentsUIs.CustomLabelUI;
import gui.customUI.customUIStyles.RoundedBorderUI;
import gui.customUI.interfaces.ICustomUI;

import javax.swing.*;
import java.awt.*;

public class BasicLabelFactory extends LabelFactory{

    private AbstractCustomLabel helpCreatedMethod(AbstractCustomLabel label){
        label.setFont(font);
        label.setForeground(new Color(0x000000));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        var uiHelper = new RoundedBorderUI(strategy, 5, 10);
        label.setBackground(new Color(0x89E56D));
        uiHelper.setAdditionaldColor(new Color(0x3F096B), ICustomUI.Index.FIRST);
        var ui2 = new CustomLabelUI(uiHelper);
        label.setUI(ui2);
        label.setMaximumFontSizeStatus(true);
        ui2.getCustomUI().setRespectionBorder(true);
        ui2.getCustomUI().getMargin().set(10,10,10,10);
        return label;
    }

    public  AbstractCustomLabel createNormalLabel(String text){
        return helpCreatedMethod(new CustomLabel(text));
    }
    public  AbstractCustomLabel createIconPropLabel(String path){
        var label = helpCreatedMethod(new IconLabel(path, true));
        label.getCustomUI().setBackGroundTransparent(true);
        return label;
    }
    public  AbstractCustomLabel createIconStretchLabel(String path){
        var label = helpCreatedMethod(new IconLabel(path, false));
        label.getCustomUI().setRespectionBorder(false);
        return label;
    }
}
