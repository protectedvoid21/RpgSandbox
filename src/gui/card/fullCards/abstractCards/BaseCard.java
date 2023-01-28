package gui.card.fullCards.abstractCards;

import gui.customComponents.*;
import gui.customComponents.abstractComponents.AbstractCustomLabel;
import gui.customUI.customUIStyles.borderStrategies.AverageBorderStartegy;
import gui.factories.GuiFactory;
import gui.data.TextData;
import gui.menu.*;
import gui.views.PanelContainer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;

public abstract class BaseCard implements ICustomBackgorund, PanelContainer, TextData {

    protected DefaultCustomMenuMenager<ComponentPanelMenager<? extends JComponent>> titleSeries =
            new DefaultCustomMenuMenager<>(ComponentsSeries.ComponentsDimension.HORIZONTAL,
                    ComponentsSeries.ComponentsDimension.HORIZONTAL);
    protected ComponentPanelMenager<AbstractCustomLabel> leftTitleComponent;
    protected ComponentPanelMenager<AbstractCustomLabel> rightTitleComponent;

    protected DefaultCustomMenuMenager seriesPanel;
    protected GuiFactory factory;

    public BaseCard(GuiFactory factory) {
        this.factory = factory;
        seriesPanel = new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.VERTICAL,
                ComponentsSeries.ComponentsDimension.HORIZONTAL);
        seriesPanel.getCmp().setHasUniqueColor(true);
        initSeriesPanel(titleSeries.getCmp(), 0, 6);
        initializeTitle();
    }

    public void setBorder(Color color, int size) {
        seriesPanel.getCmp().setBorderData(color, new AverageBorderStartegy(), size);
    }


    protected void initSeriesPanel(JComponent content, int mainIndex, int weight) {
        seriesPanel.addMainComponent(weight);
        seriesPanel.addMiddleComponent(content, mainIndex, 10);
    }

    @Override
    public void setBackgroundImage(String path) {
        try {
            seriesPanel.getCmp().setBackgroundImage(path);
        } catch (IOException e) {
            setBackground(new Color(0x935D3A));
        }
    }

    @Override
    public void setBackground(Color color) {
        seriesPanel.setBackground(color);
    }

    public ComponentPanelMenager getPanel() {
        return seriesPanel.getCmp();
    }

    public abstract void setUniformFont();

    public abstract void setVisibility(boolean value);

    public static <T extends JComponent & IContentCustomUICmp> void setAspectVisible(ArrayList<T> container,
                                                                                     boolean value) {
        for (var cmp : container) {
            cmp.setVisible(cmp.getContent().isEmpty() ? false : value);
        }
    }

    public static <T extends JComponent & IContentCustomUICmp> void setNonDependantAspectVisible(ArrayList<T> container
    ) {
        for (var cmp : container) {
            cmp.setVisible(true);
        }
    }

    public void initializeTitle() {//zmienia sie
        titleSeries.addMainComponent(10);
        titleSeries.addMainComponent(10);
        factory.setLabelType(GuiFactory.LabelType.ICON);
        leftTitleComponent = new ComponentPanelMenager<>(factory.createLabel(Card.EMPTY_DATA_CONTENT));
        initializeLeftTitleComponent(leftTitleComponent, 0);

        factory.setLabelType(GuiFactory.LabelType.NORMAL);
        rightTitleComponent = new ComponentPanelMenager<>(factory.createLabel(Card.EMPTY_DATA_CONTENT));
        initializeRightTitleComponent(rightTitleComponent, 0);
    }

    private void initializeRightTitleComponent(ComponentPanelMenager component, Side side, int middleIndex) {
        int mainIndex = side == Side.LEFT ? 0 : 1;
        titleSeries.addMiddleComponent(component, mainIndex, 30);
        titleSeries.getMiddleComponent(mainIndex, middleIndex).addSpace(6, side == Side.RIGHT ?
                ComponentPanelMenager.Side.RIGHT : ComponentPanelMenager.Side.LEFT, ComponentPanelMenager.Side.TOP);
        titleSeries.getMiddleComponent(mainIndex, middleIndex).addSpace(3, side == Side.LEFT ?
                ComponentPanelMenager.Side.RIGHT : ComponentPanelMenager.Side.LEFT);
        titleSeries.getMiddleComponent(mainIndex, middleIndex).addSpace(2, ComponentPanelMenager.Side.BOTTOM);
    }

    protected void initializeRightTitleComponent(ComponentPanelMenager component, int index) {
        initializeRightTitleComponent(component, Side.RIGHT, index);
    }

    protected void initializeLeftTitleComponent(ComponentPanelMenager component, int index) {
        initializeRightTitleComponent(component, Side.LEFT, index);
    }

    public enum Side {LEFT, RIGHT}

    protected void setTitleOptionsVisible(Side side, int index) {
        var cmp = titleSeries.getMainComponent(side == Side.LEFT ? 0 : 1).getComponent();
        for (var opt : cmp.getComponentsList()) {
            opt.setVisible(false);
        }
        cmp.getOption(index).setVisible(true);
    }


    public abstract void initialize();

}
