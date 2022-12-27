package gui.customComponents.customTextComponents;

import gui.customComponents.customTextComponents.CustomTextComponent;

import javax.swing.*;

public class CustomTextField extends CustomTextComponent {

    public CustomTextField(){
        super();
        textField = new JTextField();
        addComponentsToPanel();
        initializeTextField();
    }
}
