package gui.customComponents;

import gui.customUI.CustomLabelUI;
import gui.customUI.ICustomUI;
import gui.margin.ComponentTextMarginMenager;
import gui.margin.IComponentTextMargin;

import javax.swing.*;
import java.awt.*;

public class CustomLabel extends JLabel {
    private CustomLabelUI labelUI;

    public CustomLabel(){
        super("");
    }

    public CustomLabel(String s) {
        super(s);
        setPreferredSize(new Dimension(20, 20));
    }

    public void setUI(CustomLabelUI labelUI) {
        this.labelUI = labelUI;
        setBackground(getBackground());
        super.setUI(labelUI);
    }

    public void setBackground(Color color) {
        System.out.println("wchpodze w settera");
        if (labelUI != null) {
            labelUI.setAdditionaldColor(color, ICustomUI.Index.BASE_BACKGROUND);
        }
        super.setBackground(color);
    }

    CustomLabelUI getLabelUI() {
        return labelUI;
    }

}
