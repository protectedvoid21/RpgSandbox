package gui.menu;

import javax.swing.*;
import java.awt.*;

public class CustomMenuMenager {
    private ComponentPanelMenager<ComponentsSeries<ComponentPanelMenager<ComponentsSeries<ComponentPanelMenager>>>> cmp;///also smells.. 'using' where are you..
    private ComponentsSeries.ComponentsDimension mainSide;
    private ComponentsSeries.ComponentsDimension middleSide;

    public CustomMenuMenager(ComponentsSeries.ComponentsDimension mainSide, ComponentsSeries.ComponentsDimension middleSide) {
        this.mainSide = mainSide;
        this.middleSide = middleSide;
        cmp = new ComponentPanelMenager<>(new ComponentsSeries<>(mainSide));
    }

    public void addMainComponent(double weight) {
        cmp.getComponent().addOption(new ComponentPanelMenager<>(new ComponentsSeries<>(middleSide)), weight);
    }

    public void addMiddleComponent(JComponent newComponent, int mainIndex, double weight) {
        cmp.getComponent().getOption(mainIndex).getComponent().addOption(new ComponentPanelMenager(newComponent), weight);
    }

    public ComponentPanelMenager getMiddleComponent(int mainIndex, int middleIndex) {
        return getMainComponent(mainIndex).getComponent().getOption(middleIndex);
    }

    public ComponentPanelMenager<ComponentsSeries<ComponentPanelMenager>> getMainComponent(int index) {
        return cmp.getComponent().getOption(index);
    }

    public void addSpace(int weight, ComponentPanelMenager.Side side){
        cmp.addSpace(weight, side);
    }

    public void setBackground(Color color){
        cmp.setBackground(color);
    }

    public ComponentPanelMenager getCmp(){
        return cmp;
    }
}
