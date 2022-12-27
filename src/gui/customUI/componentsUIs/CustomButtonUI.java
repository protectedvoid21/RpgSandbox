package gui.customUI.componentsUIs;

import gui.customUI.customUIStyles.CustomUI;
import gui.customUI.interfaces.ICustomUI;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class CustomButtonUI extends BasicButtonUI {

    private ICustomUI ui;
    public CustomButtonUI(ICustomUI ui){
        this.ui = ui;

    }
    @Override
    public void installUI (JComponent c) {
        super.installUI(c);
        ui.installUI(c);
    }

    @Override
    public void paint (Graphics g, JComponent c) {
        ui.paint(g, c);
        super.paint(g, c);
    }

    public void setAdditionaldColor(Color color, CustomUI.Index index) {
        ui.setAdditionaldColor(color, index);
    }

    public Color getAdditionalColor(CustomUI.Index index) {
        return ui.getAdditionalColor(index);
    }

}
