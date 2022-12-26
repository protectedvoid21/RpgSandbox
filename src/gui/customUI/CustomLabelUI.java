package gui.customUI;

import gui.margin.ComponentTextMarginMenager;
import gui.margin.IComponentTextMargin;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;

public class CustomLabelUI extends BasicLabelUI implements  IComponentTextMargin {
    private ICustomUI ui;
    private ComponentTextMarginMenager margin;
    public CustomLabelUI(ICustomUI ui){
        this.ui = ui;

    }
    @Override
    public void installUI (JComponent c) {
        margin = new ComponentTextMarginMenager(c);
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
    public ComponentTextMarginMenager getMargin() {
        return margin;
    }
}
