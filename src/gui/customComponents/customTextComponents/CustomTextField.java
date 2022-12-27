package gui.customComponents.customTextComponents;

import gui.customComponents.customTextComponents.CustomTextComponent;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CustomTextField extends CustomTextComponent {

    public CustomTextField(){
        super();
        textField = new JTextField();
        addComponentsToPanel();
        initializeTextField();
        textField.setBackground(new Color(Color.TRANSLUCENT));
    }
}
