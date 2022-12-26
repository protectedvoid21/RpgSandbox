//package gui.factories;
//
//import javax.swing.*;
//import javax.swing.plaf.TextUI;
//import javax.swing.plaf.basic.BasicTextUI;
//import java.awt.*;
//
//public class TextUII extends BasicTextUI {
//    @Override
//    protected String getPropertyPrefix() {
//        return null;
//    }
//    private ICustomUI ui;
//    public TextUII(CustomUI ui){
//        this.ui = ui;
//
//    }
//    @Override
//    public void installUI (JComponent c) {
//        super.installUI(c);
//        ui.installUI(c);
//        super.paint();
//    }
//
//
////    @Override
////    public void paint (Graphics g, JComponent c) {
////        ui.paint(g, c);
////        super.paint(g, c);
////    }
//
//    public void setAdditionaldColor(Color color, CustomUI.Index index) {
//        ui.setAdditionaldColor(color, index);
//    }
//
//    public Color getAdditionalColor(CustomUI.Index index) {
//        return ui.getAdditionalColor(index);
//    }
//}
