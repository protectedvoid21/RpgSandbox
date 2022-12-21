//package gui.factories;
//
//import java.awt.*;
//import java.awt.font.TextAttribute;
//import java.awt.image.ImageObserver;
//import java.net.URL;
//import java.text.AttributedCharacterIterator;
//import java.text.AttributedString;
//import javax.swing.ImageIcon;
//
//public class StretchIcon extends ImageIcon {
//    final static String emptyStringContent = " ";
//    protected boolean proportionate;
//
//    protected AttributedString text;
//
//
//    public void setText(String textContent) {
//        text = new AttributedString(textContent);
//        addAttribute(TextAttribute.FONT, new Font("Arial", Font.BOLD, 18));
//        addAttribute(TextAttribute.FOREGROUND, Color.BLACK);
//    }
//
//
//    public void  addAttribute(TextAttribute attributeType, Object attribute) {
//        text.addAttribute(attributeType, attribute);
//    }
//    private String getPlainText(){
//        String string = "";
//        var itr = text.getIterator();
//        string+=itr.current();
//        while (itr.getIndex() < itr.getEndIndex())
//            string += itr.next();
//        return string.substring(0,string.length()-1);
//    }
//
//
//    public StretchIcon(String filename) {
//        this(filename, emptyStringContent, false);
//    }
//
//    public StretchIcon(String filename, String textContent) {
//        this(filename, textContent, false);
//    }
//
//    public StretchIcon(String filename, boolean proportionate) {
//        this(filename, emptyStringContent, proportionate);
//    }
//    public StretchIcon(String filename, String textContent, boolean proportionate) {
//        super(filename);
//        setText(textContent);
//        this.proportionate = proportionate;
//    }
//
//
//
//    /**
//     * Paints the icon.  The image is reduced or magnified to fit the component to which
//     * it is painted.
//     * <P>
//     * If the proportion has not been specified, or has been specified as <code>true</code>,
//     * the aspect ratio of the image will be preserved by padding and centering the image
//     * horizontally or vertically.  Otherwise the image may be distorted to fill the
//     * component it is painted to.
//     * <P>
//     * If this icon has no image observer,this method uses the <code>c</code> component
//     * as the observer.
//     *
//     * @param c the component to which the Icon is painted.  This is used as the
//     *          observer if this icon has no image observer
//     * @param g the graphics context
//     * @param x not used.
//     * @param y not used.
//     *
//     * @see ImageIcon#paintIcon(java.awt.Component, java.awt.Graphics, int, int)
//     */
//    @Override
//    public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
//
//        Image image = getImage();
//        if (image == null) {
//            return;
//        }
//        Insets insets = ((Container) c).getInsets();
//        x = insets.left;
//        y = insets.top;
//
//        int w = c.getWidth() - x - insets.right;
//        int h = c.getHeight() - y - insets.bottom;
//
//        if (proportionate) {
//            int iw = image.getWidth(c);
//            int ih = image.getHeight(c);
//
//            if (iw * h < ih * w) {
//                iw = (h * iw) / ih;
//                x += (w - iw) / 2;
//                w = iw;
//            } else {
//                ih = (w * ih) / iw;
//                y += (h - ih) / 2;
//                h = ih;
//            }
//        }
//        System.out.println("tu dojd222e");
//        ImageObserver io = getImageObserver();
//        g.drawImage(image, x, y, w, h, io == null ? c : io);
//////        Font font = new Font(fontType, Font.BOLD, 18);
////
//////        AttributedString attributedText = new AttributedString(text);
////        attributedText.addAttribute(Attribute.);
////        attributedText.addAttribute(TextAttribute.FONT, font);
////        attributedText.addAttribute(TextAttribute.FOREGROUND, Color.GREEN);
//        System.out.println("tu dojde");
//        FontMetrics metrics = g.getFontMetrics((Font) text.getIterator().getAttribute(TextAttribute.FONT));
//        System.out.println("tu doj3333de");
//        int positionX = (c.getWidth() - metrics.stringWidth(getPlainText())) / 2;
//        int positionY = (c.getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
//        g.drawString(text.getIterator(), positionX, positionY);
//    }
//
//    /**
//     * Overridden to return 0.  The size of this Icon is determined by
//     * the size of the component.
//     *
//     * @return 0
//     */
//    @Override
//    public int getIconWidth() {
//        return 0;
//    }
//
//    /**
//     * Overridden to return 0.  The size of this Icon is determined by
//     * the size of the component.
//     *
//     * @return 0
//     */
//    @Override
//    public int getIconHeight() {
//        return 0;
//    }
//}