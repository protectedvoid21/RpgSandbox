//package gui.customUI.customUIStyles;
//
//import gui.customUI.customUIStyles.GrowingBorderStyleUI;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//public class ChangingBackgroundGrowingStyle extends GrowingBorderStyleUI {
//    private Color currentBaseBackgroundHelper;
//
//    @Override
//    public void installUI(JComponent c) {
//        super.installUI(c);
//        c.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                currentBaseBackgroundHelper = getAdditionalColor(Index.BASE_BACKGROUND);
//                setAdditionaldColor(getAdditionalColor(Index.SECOND), Index.BASE_BACKGROUND);
//                super.mousePressed(e);
//                c.repaint();
//                c.revalidate();
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                setAdditionaldColor(currentBaseBackgroundHelper, Index.BASE_BACKGROUND);
//                currentBaseBackgroundHelper = null;
//                super.mousePressed(e);
//                c.repaint();
//                c.revalidate();
//            }
//        });
//    }
//}
