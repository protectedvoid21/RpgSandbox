package gui.customUI.customUIStyles;

import gui.card.SharedCmpsFont;
import gui.customUI.customUIStyles.borderStrategies.*;
import gui.customUI.interfaces.ICustomUI;
import gui.margin.ComponentTextMarginManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Area;
import java.util.HashMap;
import java.util.function.Function;


public abstract class CustomUI implements ICustomUI {
    private ComponentTextMarginManager margin;
    private ComponentTextMarginManager activeMargin;
    private HashMap<ComponentTextMarginManager.Side, Double> previousCmpMarginValues;
    private boolean isBorderedRespected = false;
    private int offSet;

    private boolean isFontMaximized = false;
    private boolean isFontRelevantToHeight = false;

    private JComponent parent;
    private HashMap<ICustomUI.Index, Color> additionalColors = new HashMap<>();
    private boolean transparentStatus = false;
    private IBorderStrategy borderStrategy;
    private SharedCmpsFont cmpsShared = null;

    private int lastFontSize = 0;
    private int lastButOneFontSize = 0;

    public CustomUI(IBorderStrategy borderStrategy, int offSet) {
        this.offSet = offSet;
        this.borderStrategy = borderStrategy;
    }

    public CustomUI(IBorderStrategy borderStrategy) {
        this(borderStrategy, 6);
    }

    public boolean isFontMaximized() {
        return isFontMaximized;
    }

    public void setOffSet(int value){
        this.offSet = value;
    }


    @Override
    public int getBorderSize() {
        return offSet;
    }

    @Override
    public double convertTopBorderSizeToValue(JComponent c, int offSetValue) {
        return borderStrategy.convertTOPBorderSizeToValue(c, offSetValue);
    }

    @Override
    public double convertSideBorderSizeToValue(JComponent c, int offSetValue) {
        return borderStrategy.convertSIDEBorderSizeToValue(c, offSetValue);
    }

    public void installUI(JComponent c) {
        parent = c;
        margin = new ComponentTextMarginManager(c);
        activeMargin = new ComponentTextMarginManager(c);
        parent.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                if (isBorderedRespected && activeMargin != null) {
                    activeMargin.checkValidation();
                }
                if (margin != null) {
                    margin.checkValidation();
                }
            }
        });
        c.setOpaque(false);
        c.setBorder(new EmptyBorder(0, 0, 0, 0));
    }

    @Override
    public void changeBorderStrategy(IBorderStrategy newStrategy) {
        borderStrategy = newStrategy;
    }

    public void setAdditionaldColor(Color color, ICustomUI.Index index) {
        additionalColors.put(index, color);
    }

    public Color getAdditionalColor(ICustomUI.Index index) {
        return additionalColors.get(index) != null ? additionalColors.get(index) :
                additionalColors.get(Index.BASE_BACKGROUND);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        paintBackground(g, c, offSet);
    }

    @Override
    public ComponentTextMarginManager getMargin() {
        return margin;
    }

    @Override
    public boolean getMarginRespection() {
        return isBorderedRespected;
    }

    @Override
    public void setRespectionBorder(boolean value) {
        isBorderedRespected = value;
        if (margin != null && activeMargin != null) {
            if (value) {
                activeMargin.reset();
            } else {
                margin.reset();
            }
        }

    }

    private double initActiveMarginAndGetSizeDiff(ComponentTextMarginManager.Side side) {
        double diff, size, borderSize;
        size = borderSize = 0;
        switch (side) {
            case TOP, BOTTOM -> {
                size = parent.getHeight();
                borderSize = convertTopBorderSizeToValue(parent, offSet);
            }
            case LEFT, RIGHT -> {
                size = parent.getWidth();
                borderSize = convertSideBorderSizeToValue(parent, offSet);
            }
        }
        diff = Math.max(margin.get(side), borderSize);
        activeMargin.set(side, (diff * 100 / size));
        return diff;
    }

    @Override
    public void setFontRelevantToHeight(boolean val) {
        isFontRelevantToHeight = val;
        if (parent != null) {
            parent.repaint();
            parent.revalidate();
        }
    }

    @Override
    public boolean isFontRelevantToHeight() {
        return isFontRelevantToHeight;
    }


    public void calculateMargins() {
        for (var side :ComponentTextMarginManager.Side.values()){
            initActiveMarginAndGetSizeDiff(side);
        }
    }

    @Override
    public Font getRelevantFont(String labelText) {

        if (margin != null && borderStrategy != null) {
            Font labelFont = parent.getFont();
            int stringWidth = parent.getFontMetrics(labelFont).stringWidth(labelText);
            int componentWidth = parent.getWidth();
            int componentHeight = parent.getHeight();
            if (margin != null) {
                if (isBorderedRespected) {
                    componentWidth -= initActiveMarginAndGetSizeDiff(ComponentTextMarginManager.Side.LEFT);
                    componentWidth -= initActiveMarginAndGetSizeDiff(ComponentTextMarginManager.Side.RIGHT);
                    componentHeight -= initActiveMarginAndGetSizeDiff(ComponentTextMarginManager.Side.BOTTOM);
                    componentHeight -= initActiveMarginAndGetSizeDiff(ComponentTextMarginManager.Side.TOP);
                } else {
                    componentWidth -= (margin.get(ComponentTextMarginManager.Side.LEFT) + margin.get
                            (ComponentTextMarginManager.Side.RIGHT));
                    componentHeight -= (margin.get(ComponentTextMarginManager.Side.BOTTOM) + margin.get
                            (ComponentTextMarginManager.Side.TOP));
                }
            }


            if (isFontRelevantToHeight) {
                return findFont2(parent, new Dimension(componentWidth, componentHeight), parent.getFont(),
                        labelText);
            }
            if (isFontMaximized) {
                if (stringWidth > componentWidth || parent.getFontMetrics(parent.getFont()).getAscent() > componentHeight) {
                    return findFont(parent, new Dimension(componentWidth, componentHeight), parent.getFont(),
                            labelText, false);
                } else {
                    return findFont(parent, new Dimension(componentWidth, componentHeight), parent.getFont(),
                            labelText, true);
                }
            }
            return parent.getFont();

        }
        return new Font(parent.getFont().getName(), parent.getFont().getStyle(), 1);
    }

    /**
     * Set cmp on null if you want to remove sharing component size
     */
    public void setSharedComponentSize(SharedCmpsFont cmpShared) {
        if (cmpShared == null) {
            if (this.cmpsShared != null) {
                this.cmpsShared.removeComponentFromList(parent);
            }
        }
        this.cmpsShared = cmpShared;
    }

    public boolean hasSharedSize() {
        return cmpsShared != null;
    }

    public void setRelevantFont(String labelText) {
        if (margin != null && borderStrategy != null) {
            parent.setFont(getRelevantFont(labelText));
            if (hasSharedSize()) {
                cmpsShared.setSharedFontSize();
            }
        }
    }

    private Dimension getFontSize(FontMetrics metrics, String text) {
        return new Dimension(metrics.stringWidth(text), metrics.getAscent());
    }

    private Font findFont(Component component, Dimension componentSize, Font oldFont, String text, boolean increased
    ) {
        Font savedFont = oldFont;
        Function<Integer, Font> getCurrentFont = (var size) -> new Font(oldFont.getFontName(), oldFont.getStyle(),
                size);
        Function<Font, Dimension> getCurrentDimension = (var font) -> getFontSize(component.getFontMetrics(font), text);
        if (increased) {
            for (int i = oldFont.getSize(); i < 300; i += 1) {
                var newFont = getCurrentFont.apply(i);
                Dimension d = getCurrentDimension.apply(newFont);
                if (componentSize.height < d.height || componentSize.width < d.width) {
                    return savedFont;
                }
                savedFont = newFont;
            }
        } else {
            for (int i = oldFont.getSize(); i > 0; i--) {
                var newFont = getCurrentFont.apply(i);
                Dimension d = getCurrentDimension.apply(newFont);
                savedFont = newFont;
                if (componentSize.height > d.height && componentSize.width > d.width) {
                    return savedFont;
                }
            }
        }
        return oldFont;
    }

    @Override
    public ComponentTextMarginManager getCurrentActivatedMargin() {
        return activeMargin;
    }

    private Font findFont2(Component component, Dimension componentSize, Font oldFont, String text
    ) {
        Font savedFont = oldFont;
        Function<Integer, Font> getCurrentFont = (var size) -> new Font(oldFont.getFontName(), oldFont.getStyle(),
                size);
        Function<Font, Dimension> getCurrentDimension = (var font) -> getFontSize(component.getFontMetrics(font), text);
        for (int i = 0; i < 300; i += 1) {
            var newFont = getCurrentFont.apply(i);
            Dimension d = getCurrentDimension.apply(newFont);
            if (componentSize.height < d.height) {
                return savedFont;
            }
            savedFont = newFont;
        }
        return oldFont;
    }


    public void setFontMaximized(boolean fontMaximized) {
        isFontMaximized = fontMaximized;
        if (parent != null) {
            parent.repaint();
            parent.revalidate();
        }
    }

    @Override
    public boolean isBackgroundTransparent() {
        return transparentStatus;
    }

    @Override
    public void setBackGroundTransparent(boolean newStatus) {
        transparentStatus = newStatus;
    }

    protected void createTransparentRectangle(Shape firstShape, Shape secondShape, Graphics2D g2) {
        var area = new Area(firstShape);
        var area2 = new Area(secondShape);
        area.subtract(area2);
        g2.fill(area);
    }

}
