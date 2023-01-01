package gui.customComponents;

import gui.customUI.componentsUIs.CustomButtonUI;
import gui.customUI.interfaces.ICustomUI;

import javax.swing.*;
import java.awt.*;

/**Custom Button instance used in whole app, has methods which can menage the customButtonUI instance.  */
public class CustomButton extends JButton implements ITextCustomUICmp {
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
            buttonUI.getCustomUI().setAdditionaldColor(color, ICustomUI.Index.BASE_BACKGROUND);
        }
        super.setBackground(color);
    }
    @Override
    protected void paintComponent(Graphics g) {
        if (buttonUI != null) {
            buttonUI.getCustomUI().setRelevantFont(getText());
        }
        super.paintComponent(g);
    }


    public void setMaximumFontSizeStatus(boolean status){
        buttonUI.getCustomUI().setFontMaximized(status);
    }

    @Override
    public ICustomUI getCustomUI() {
        return buttonUI.getCustomUI();
    }

    @Override
    public int getMaximumPossibleFontSize() {
        return getCustomUI().getMaximumPossibleFont(getText()).getSize();
    }
    @Override
    public void setFont(int newFontSize) {
        var f = getFont();
        setFont(new Font(f.getName(), f.getStyle(), newFontSize));
    }

    @Override
    public boolean hasSharedSize() {
        return getCustomUI().hasSharedSize();
    }

}
