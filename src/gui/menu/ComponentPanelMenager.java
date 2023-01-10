package gui.menu;

import gui.customComponents.CustomButton;
import gui.customUI.customUIStyles.borderStrategies.DefaultBorderStrategy;
import gui.customUI.customUIStyles.borderStrategies.IBorderStrategy;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class ComponentPanelMenager<T extends JComponent> extends JPanel {
    public enum Side {RIGHT, LEFT, BOTTOM, TOP}

    private GridBagConstraints cst = new GridBagConstraints();
    protected T component;
    private Image backgroundImage;
    private HashMap<Side, Component> freeSpaces = new HashMap<>();
    private double borderValue = 0;
    private Color borderColor;
    private IBorderStrategy strategy = new DefaultBorderStrategy();
    private boolean hasUniqueColor = false;

    public void setHasUniqueColor(boolean hasUniqueColor) {
        this.hasUniqueColor = hasUniqueColor;
    }

    private int intiialWeight;


    public ComponentPanelMenager(T component, int intiialWeight) {
        this.component = component;
        this.intiialWeight = intiialWeight;
        setOpaque(false);
        component.setPreferredSize(new Dimension(1, 1));
        setLayout(new GridBagLayout());
        cst.fill = GridBagConstraints.BOTH;
        addMainComponent(component);

        Arrays.asList(Side.values()).forEach(side -> freeSpaces.put(side, null));
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    }

    public ComponentPanelMenager(T component) {
        this(component, 10);
    }

    public static ComponentPanelMenager createEmptyInstance() {
        var p = new JPanel();
        p.setOpaque(false);
        return new ComponentPanelMenager(p);
    }

    private void addMainComponent(T cmp) {
        cst.gridx = 1;
        cst.weightx = intiialWeight;
        cst.weighty = intiialWeight;
        cst.gridy = 1;
        add(component, cst);
    }


    private void initCstForVerticalBox(int weight, Side side) {
        cst.weighty = 1;
        cst.weightx = weight;
        cst.gridy = 1;
        cst.gridx = side == Side.LEFT ? 0 : 2;
    }

    private void initCstForHorizontalBox(int weight, Side side) {
        cst.weightx = 1;
        cst.weighty = weight;
        cst.gridx = 1;
        cst.gridy = side == Side.TOP ? 0 : 2;

    }

    public void addSpace(int weight, Side side) {
        switch (side) {
            case TOP, BOTTOM -> initCstForHorizontalBox(weight, side);
            case LEFT, RIGHT -> initCstForVerticalBox(weight, side);
        }
        var box = Box.createGlue();
//        box.setBackground(new Color(0,0,0,0));
//box.setOpaque(false);//niebezpieccznie zmienione tylko pierdolilo background
        removeAddedSpace(side);
        add(box, cst);
        freeSpaces.put(side, box);
    }

    public void addSpace(int weight) {
        Arrays.asList(Side.values()).forEach(side -> addSpace(weight, side));
    }

    public void addSpace(int weight, Side... sides) {
        for (var side : sides) {
            addSpace(weight, side);
        }
    }

    public void removeAddedSpace(Side... sides) {
        for (var side : sides) {
            var space = freeSpaces.get(side);
            if (space != null) {
                remove(space);
                freeSpaces.put(side, null);
            }
        }
    }

    public T getComponent() {
        return component;
    }

    public void changeContent(T newComponent) {
        remove(component);
        component = newComponent;
        addMainComponent(newComponent);
        repaint();
        revalidate();
    }

    @Override//it really smells, i know
    public void setBackground(Color bg) {
        super.setBackground(bg);
//        if(bg.getRed()==238&&bg.getBlue()==238))
        System.out.println(bg);
//        if (component instanceof JPanel) {
//            component.setBackground(bg);
//        }
//        if (component instanceof DefaultCustomMenuMenager<? extends JComponent>>) {
//            component.setBackground(bg);
//        }to opaque pamietac moze cos z tym wspolnym interfejsem
    }

    public void setBackgroundImage(String fileName) throws IOException {
//        try{
        backgroundImage = ImageIO.read(new File(fileName));
//        }finally {
//            if(backgroundImage==null){
//                setOpaque(true);
//            }else{
//                setOpaque(false);
//            }
//        }
        repaint();
        revalidate();

    }

    @Override
    public void paintComponent(Graphics g) {
        System.out.println(backgroundImage);
//        setOpaque(backgroundImage==null?false:true);
        super.paintComponent(g);

        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        } else {
            if (hasUniqueColor) {
                g.setColor(getBackground());
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
            }

        }
    }

    /**
     * Border value is given in per mille
     */
    public void setBorderData(Color color, IBorderStrategy strategy, int borderValue) {
        this.strategy = strategy;
        this.borderColor = color;
        this.borderValue = ((double) borderValue) / 10;
    }

    public void removeBorderData() {
        strategy = new DefaultBorderStrategy();
        this.borderColor = null;
        this.borderValue = 0;
    }

    @Override
    protected void paintBorder(Graphics g) {
        var top = (int) strategy.convertTOPBorderSizeToValue(this, borderValue);
        var side = (int) strategy.convertSIDEBorderSizeToValue(this, borderValue);
        if (!(getBorder().getBorderInsets(this).top == top && getBorder().getBorderInsets(this).left == side) && borderColor != null) {
            setBorder(BorderFactory.createMatteBorder(top, side, top, side, borderColor));
        }
        super.paintBorder(g);
    }
}