package gui.customUI.componentsUIs;

import gui.customUI.customUIStyles.CustomUI;
import gui.customUI.interfaces.ICustomUI;
import gui.margin.ComponentTextMarginManager;
import gui.margin.IComponentTextMargin;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;

/**
 * Custom Label UI Adapter which, class has to be created because QLabel has to receive BasicLabelUI instance during
 * setting UI.
 */
public class CustomLabelUI extends BasicLabelUI implements IComponentTextMargin {
    private ICustomUI ui;

    public CustomLabelUI(ICustomUI ui) {
        this.ui = ui;
    }


    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        ui.installUI(c);
        c.repaint();
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        ui.paint(g, c);
        super.paint(g, c);
    }

    public ICustomUI getCustomUI() {
        return ui;
    }

    @Override
    public ComponentTextMarginManager getMargin() {
        return ui.getMargin();
    }

}
