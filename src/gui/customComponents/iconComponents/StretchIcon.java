package gui.customComponents.iconComponents;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.HashMap;
import javax.swing.*;
//import org.jfree.graphics2d.svg.SVGGraphics2D;
//import org.jfree;
//import

public class StretchIcon extends ImageIcon {

    protected HashMap<TextAttribute, Object> attrsMap = new HashMap<>();
    protected boolean proportionate;

    protected AttributedString text;
    private JComponent parent;


    public void setText(String textContent) {
        text = textContent == null ? null : new AttributedString(textContent);
        if (!isTextEmpty()) {
            for (var attr : attrsMap.keySet()) {
                text.addAttribute(attr, attrsMap.get(attr));
            }
        }
    }

    public void removeText() {
        text = null;
    }

    public boolean isTextEmpty() {
        return text == null;
    }

    public void resetText() {
        var textContent = getPlainText();
        attrsMap.clear();
        addBasicAttributes();
        setText(textContent);
    }

    private void addBasicAttributes() {
        addAttributeToMap(TextAttribute.FONT, new Font("Arial", Font.BOLD, 18));
        addAttributeToMap(TextAttribute.FOREGROUND, Color.BLACK);
    }


    private void addAttributeToMap(TextAttribute attributeType, Object attribute) {
        if (attrsMap.containsKey(attributeType)) {
            attrsMap.replace(attributeType, attribute);
        } else {
            attrsMap.put(attributeType, attribute);
        }
    }

    public void addAttribute(TextAttribute attributeType, Object attribute) {
        addAttributeToMap(attributeType, attribute);
        text.addAttribute(attributeType, attribute);
        parent.repaint();
    }

    private String getPlainText() {
        String string = "";
        var itr = text.getIterator();
        string += itr.current();
        while (itr.getIndex() < itr.getEndIndex())
            string += itr.next();
        return string.substring(0, string.length() - 1);
    }


    public StretchIcon(JComponent parent, String filename) {
        this(parent, filename, null, false);
    }

    public StretchIcon(JComponent parent, String filename, String textContent) {
        this(parent, filename, textContent, false);
    }

    public StretchIcon(JComponent parent, String filename, boolean proportionate) {
        this(parent, filename, null, proportionate);
    }

    public StretchIcon(JComponent parent, String filename, String textContent, boolean proportionate) {
        super(filename);
        this.parent = parent;
        addBasicAttributes();
        setText(textContent);
        this.proportionate = proportionate;

    }


    @Override
    public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
        Image image = getImage();
        if (image == null) {
            return;
        }
        Insets insets = ((Container) c).getInsets();
        x = insets.left;
        y = insets.top;

        int w = c.getWidth() - x - insets.right;
        int h = c.getHeight() - y - insets.bottom;

        if (proportionate) {
            int iw = image.getWidth(c);
            int ih = image.getHeight(c);

            if (iw * h < ih * w) {
                iw = (h * iw) / ih;
                x += (w - iw) / 2;
                w = iw;
            } else {
                ih = (w * ih) / iw;
                y += (h - ih) / 2;
                h = ih;
            }
        }
        ImageObserver io = getImageObserver();
        g.drawImage(image, x, y, w, h, io == null ? c : io);
        if (text != null) {
            FontMetrics metrics = g.getFontMetrics((Font) text.getIterator().getAttribute(TextAttribute.FONT));
            int positionX = (c.getWidth() - metrics.stringWidth(getPlainText())) / 2;
            int positionY = (c.getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
            g.drawString(text.getIterator(), positionX, positionY);
        }
    }

    @Override
    public int getIconWidth() {
        return 0;
    }

    @Override
    public int getIconHeight() {
        return 0;
    }
}