package gui.menu;

import javax.swing.*;
import java.awt.*;

public class ComponentPanelMenager<T extends JComponent> extends JPanel {
    public enum Side {RIGHT, LEFT, BOTTOM, TOP}

    private GridBagConstraints cst = new GridBagConstraints();
    protected T component;

    public ComponentPanelMenager(T component) {
        this.component = component;
        setLayout(new GridBagLayout());
        cst.fill = GridBagConstraints.BOTH;
        cst.gridx = 1;
        cst.weightx = 10;
        cst.weighty = 10;
        cst.gridy = 1;
        add(component, cst);

    }

    private void initCstForVerticalBox(int weight, Side side) {
        cst.weightx = weight;
        cst.gridy = 1;
        cst.gridx = side == Side.LEFT ? 0 : 2;
    }
    private void initCstForHorizontalBox(int weight, Side side) {
        cst.weighty = weight;
        cst.gridx = 1;
        cst.gridy = side == Side.TOP ? 0 : 2;

    }

    public void addSpace(int weight, Side side) {
        switch (side){
            case TOP, BOTTOM -> initCstForHorizontalBox(weight, side);
            case LEFT, RIGHT -> initCstForVerticalBox(weight, side);
        }
        add(Box.createVerticalBox(), cst);
    }

    public T getComponent(){
        return component;
    }

    @Override//it really smells, i know
    public void setBackground(Color bg) {
        super.setBackground(bg);
        if (component instanceof JPanel){
            component.setBackground(bg);
        }
    }
}