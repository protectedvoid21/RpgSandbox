package gui.customUI.componentsUIs;

import gui.customUI.customUIStyles.CustomUI;
import gui.customUI.interfaces.ICustomUI;
import gui.margin.ComponentTextMarginManager;
import gui.margin.IComponentTextMargin;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;

/**Custom Label UI Adapter which, class has to be created because QLabel has to receive BasicLabelUI instance during setting UI. */
public class CustomLabelUI extends BasicLabelUI implements  IComponentTextMargin {
    private ICustomUI ui;
    private ComponentTextMarginManager margin;
    public CustomLabelUI(ICustomUI ui){
        this.ui = ui;

    }
    @Override
    public void installUI (JComponent c) {
        margin = new ComponentTextMarginManager(c);
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

    @Override
    public ComponentTextMarginManager getMargin() {
        return margin;
    }
}
