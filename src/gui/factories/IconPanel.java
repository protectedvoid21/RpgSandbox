//package gui.factories;
//
//import com.kitfox.svg.SVGUniverse;
//import com.kitfox.svg.app.beans.SVGIcon;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class IconPanel extends JPanel {
//
//    final SVGIcon icon;
//
//    public IconPanel(String name, int scalex, int scaley) {
//        icon = new SVGIcon();
//        icon.setSvgResourcePath("classroom-svgrepo-com.svg");
//        icon.setPreferredSize(new Dimension(scalex, scaley));
//        icon.setScaleToFit(true);
//        icon.setAntiAlias(true);
//    }
//
//    public void paintComponent(Graphics g) {
//
//        icon.paintIcon(this, g, 0, 0);
//        icon.isScaleToFit();
//    }
//}
