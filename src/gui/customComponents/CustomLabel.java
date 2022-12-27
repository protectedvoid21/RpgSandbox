package gui.customComponents;

import gui.customUI.componentsUIs.CustomLabelUI;
import gui.customUI.interfaces.ICustomUI;

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
        if (labelUI != null) {
            labelUI.setAdditionaldColor(color, ICustomUI.Index.BASE_BACKGROUND);
        }
        super.setBackground(color);
    }

    public CustomLabelUI getLabelUI() {
        return labelUI;
    }

}
