package gui.customComponents;

import gui.customComponents.iconComponents.IconButton;

import java.awt.*;

public class ChanginBackDisabledButton extends IconButton {
    private Color backgroundColor;
    private Color secondColor;

    public ChanginBackDisabledButton(String iconPath, Color secondColor) {
        super(iconPath);
        this.secondColor = secondColor;
        backgroundColor = getBackground();

    }

    public ChanginBackDisabledButton(String iconPath, boolean prop, Color secondColor) {
        super(iconPath);
        this.secondColor = secondColor;
        backgroundColor = getBackground();
    }


    @Override
    public void setEnabled(boolean b) {
//        super.setEnabled(b);
        System.out.println(getBackground()+"  "+secondColor+"  "+backgroundColor);
        if (!b){
            setOnlySuperBackground(secondColor);
        }else{
            setOnlySuperBackground(backgroundColor);
        }
        super.setEnabled(b);
    }

    private void setOnlySuperBackground(Color color){
        super.setBackground(color);
    }

    @Override
    public void setBackground(Color color) {
        super.setBackground(color);
        backgroundColor = color;
    }
}
