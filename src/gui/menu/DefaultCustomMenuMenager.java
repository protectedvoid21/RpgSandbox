package gui.menu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DefaultCustomMenuMenager<T extends JComponent> {
    private ComponentPanelMenager<ComponentsSeries<ComponentPanelMenager<ComponentsSeries<ComponentPanelMenager<T>>>>> cmp;///also smells.. 'using' where are you..
    private ComponentsSeries.ComponentsDimension mainSide;
    private ComponentsSeries.ComponentsDimension middleSide;

    public DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension mainSide,
                                    ComponentsSeries.ComponentsDimension middleSide) {
        this.mainSide = mainSide;
        this.middleSide = middleSide;
        cmp = new ComponentPanelMenager<>(new ComponentsSeries<>(mainSide));
    }

    public DefaultCustomMenuMenager(JPanel parent, ComponentsSeries.ComponentsDimension mainSide,
                                    ComponentsSeries.ComponentsDimension middleSide) {
        this(mainSide, middleSide);
        parent.add(cmp);
    }

    public void addMainComponent(double weight) {
        cmp.getComponent().addOption(new ComponentPanelMenager<>(new ComponentsSeries<>(middleSide)), weight);
    }

    public void addMiddleComponent(T newComponent, int mainIndex, double weight) {
        cmp.getComponent().getOption(mainIndex).getComponent().addOption(new ComponentPanelMenager(newComponent),
                weight);
    }

    public ComponentPanelMenager<T> getMiddleComponent(int mainIndex, int middleIndex) {
        return getMainComponent(mainIndex).getComponent().getOption(middleIndex);
    }

    public ComponentPanelMenager<ComponentsSeries<ComponentPanelMenager<T>>> getMainComponent(int index) {
        return cmp.getComponent().getOption(index);
    }

    public void addSpace(int weight, ComponentPanelMenager.Side side) {
        cmp.addSpace(weight, side);
    }

    public void setBackground(Color color) {
        cmp.setBackground(color);
    }

    public ComponentPanelMenager getCmp() {
        return cmp;
    }

    public ArrayList<T> getComponentsList() {
        var array = new ArrayList<T>();
        for (var x : cmp.getComponent().getComponentsList()) {
            x.getComponent().getComponentsList().forEach(e -> array.add(e.getComponent()));
        }
        return array;
    }
}
