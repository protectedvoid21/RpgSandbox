//package gui.customUI.componentsUIs;
//
//import gui.customUI.customUIStyles.CustomUI;
//import gui.customUI.interfaces.ICustomUI;
//import gui.margin.ComponentTextMarginManager;
//
//import javax.swing.*;
//import javax.swing.plaf.PanelUI;
//import javax.swing.plaf.basic.BasicPanelUI;
//import java.awt.*;
//
//public class CustomPanelUI extends BasicPanelUI {
//    private ICustomUI ui;
//    public CustomPanelUI(ICustomUI ui){
//        this.ui = ui;
//
//    }
//    @Override
//    public void installUI (JComponent c) {
//        super.installUI(c);
//        ui.installUI(c);
//    }
//
//    @Override
//    public void paint (Graphics g, JComponent c) {
//        ui.paint(g, c);
//        super.paint(g, c);
//    }
//
//    public void setAdditionaldColor(Color color, CustomUI.Index index) {
//        ui.setAdditionaldColor(color, index);
//    }
//
//    public Color getAdditionalColor(CustomUI.Index index) {
//        return ui.getAdditionalColor(index);
//    }
//
//}
