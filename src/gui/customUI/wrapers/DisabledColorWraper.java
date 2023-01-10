//package gui.customUI.wrapers;
//
//import gui.customUI.interfaces.ICustomUI;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ComponentAdapter;
//import java.awt.event.ComponentEvent;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//
//public class DisabledColorWraper extends BorderDecorator {
//    private Color currentBaseBackgroundHelper;
//
//    public DisabledColorWraper(ICustomUI ui) {
//        super(ui);
//    }
//
//    @Override
//    public void paint(Graphics g, JComponent c) {
//        System.out.println("XDD");
//        if (!c.isEnabled()) {
//            if (getAdditionalColor(Index.BASE_BACKGROUND) != currentBaseBackgroundHelper) {
//                System.out.println("hello");
//                currentBaseBackgroundHelper = getAdditionalColor(Index.BASE_BACKGROUND);
//                setAdditionaldColor(getAdditionalColor(Index.BASE_BACKGROUND).darker(), Index.BASE_BACKGROUND);
//            }
//        } else {
//            setAdditionaldColor(currentBaseBackgroundHelper, Index.BASE_BACKGROUND);
////                currentBaseBackgroundHelper = null;
//            System.out.println("hello2");
//        }
//        super.paint(g, c);
//    }
//}
