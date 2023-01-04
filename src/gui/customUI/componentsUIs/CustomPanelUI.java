//package gui.customUI.componentsUIs;
//
//import gui.customUI.customUIStyles.CustomUI;
//import gui.customUI.interfaces.ICustomUI;
//import gui.margin.ComponentTextMarginManager;
//import gui.margin.IComponentTextMargin;
//
//import javax.swing.*;
//import javax.swing.plaf.PanelUI;
//import javax.swing.plaf.basic.BasicPanelUI;
//import javax.swing.plaf.basic.BasicTextUI;
//import java.awt.*;
//
//public class CustomPanelUI extends BasicTextUI implements IComponentTextMargin {
//    private ICustomUI ui;
//    public CustomPanelUI(ICustomUI ui){
//        this.ui = ui;
//
//    }
//
//    @Override
//    protected String getPropertyPrefix() {
//        return null;
//    }
//
//    @Override
//    public void installUI (JComponent c) {
//        super.installUI(c);
//        ui.installUI(c);
//        System.out.println("cos tu ronie");
//        var run = new Runnable(){
//            @Override
//            public void run() {
//                for (var side : ComponentTextMarginManager.Side.values()){
//                    getMargin().set(side, ui.getMargin().get(side));
//                }
//                System.out.println("hellloooo");
//            }
//        };
////        getMargin().addActionOnMarginChecked(run);
//        c.repaint();
//    }
//
//    @Override
//    public void update(Graphics g, JComponent c) {
//        ui.paint(g, c);
//        super.update(g, c);
//    }
//
//
//    public void setAdditionaldColor(Color color, CustomUI.Index index) {
//        ui.setAdditionaldColor(color, index);
//    }
//
//    public Color getAdditionalColor(CustomUI.Index index) {
//        return ui.getAdditionalColor(index);
//    }
//
//    @Override
//    public ComponentTextMarginManager getMargin() {
//        return ui.getMargin();
//    }
//}
