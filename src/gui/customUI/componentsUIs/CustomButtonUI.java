package gui.customUI.componentsUIs;

import gui.customUI.customUIStyles.CustomUI;
import gui.customUI.interfaces.ICustomFontSize;
import gui.customUI.interfaces.ICustomUI;
import gui.margin.ComponentTextMarginManager;
import gui.margin.IComponentTextMargin;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

/**Custom Button UI Adapter, class has to be created because QButton has to receive BasicButtonUI instance during setting UI. */
public class CustomButtonUI extends BasicButtonUI implements IComponentTextMargin {
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

    public ICustomUI getCustomUI(){
        return ui;
    }

    @Override
    public ComponentTextMarginManager getMargin() {
        return ui.getMargin();
    }

}
