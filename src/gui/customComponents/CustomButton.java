package gui.customComponents;

import gui.customUI.componentsUIs.CustomButtonUI;
import gui.customUI.interfaces.ICustomUI;

import javax.swing.*;
import java.awt.*;

public class CustomButton extends JButton {
    private CustomButtonUI buttonUI;
    public CustomButton(){
        super("");
    }
    public CustomButton(String s) {
        super(s);
        setPreferredSize(new Dimension(20, 20));
    }

    public void setUI(CustomButtonUI buttonUI) {
        this.buttonUI = buttonUI;
        setBackground(getBackground());
        super.setUI(buttonUI);
    }

    public void setBackground(Color color) {
        if (buttonUI != null) {
            buttonUI.setAdditionaldColor(color, ICustomUI.Index.BASE_BACKGROUND);
        }
        super.setBackground(color);
    }

    CustomButtonUI getButtonUI() {
        return buttonUI;
    }

}
