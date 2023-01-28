package gui.factories.customFactories.labelFactories;

import gui.customComponents.AbstractCustomLabel;
import gui.customComponents.CustomLabel;
import gui.customComponents.iconComponents.IconLabel;
import gui.customUI.componentsUIs.CustomLabelUI;
import gui.customUI.customUIStyles.CustomUI;
import gui.customUI.customUIStyles.DoubleRoundRectangleUI;
import gui.customUI.customUIStyles.RoundedBorderUI;
import gui.customUI.interfaces.ICustomUI;

import javax.swing.*;
import java.awt.*;

public class TitleCardLabelFactory extends LabelFactory {

    private AbstractCustomLabel helpCreatedMethod(AbstractCustomLabel label, CustomUI uiHelper) {
        label.setFont(font);
        label.setForeground(new Color(0xFFFBFB));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBackground(new Color(0x5F17EA));
        uiHelper.setAdditionaldColor(new Color(0x5F17EA), ICustomUI.Index.FIFTH);
        uiHelper.setAdditionaldColor(new Color(0x1F3617), ICustomUI.Index.FIRST);
        var ui2 = new CustomLabelUI(uiHelper);
        ui2.getCustomUI().setFontMaximized(true);
        label.setUI(ui2);
        ui2.getMargin().set(10, (10),
                (int) (10), (int) (10));

        return label;
    }

    @Override
    public AbstractCustomLabel createNormalLabel(String text) {
        return helpCreatedMethod(new CustomLabel(text),
                new RoundedBorderUI(strategy, (5 ), 10));
    }

    @Override
    public AbstractCustomLabel createIconPropLabel(String path) {
        var label = helpCreatedMethod(new IconLabel(path, true),
                new DoubleRoundRectangleUI(strategy, 6 , 10));
        label.getCustomUI().setBackGroundTransparent(true);
        return label;
    }

    @Override
    public AbstractCustomLabel createIconStretchLabel(String path) {
        var label = helpCreatedMethod(new IconLabel(path, false),
                new DoubleRoundRectangleUI(strategy, (int)6 , 10));
        label.getCustomUI().setBackGroundTransparent(true);
        return label;
    }
}
