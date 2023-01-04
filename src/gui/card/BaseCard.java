package gui.card;

import game.equipment.Item;
import gui.customComponents.*;
import gui.customUI.customUIStyles.borderStrategies.AverageBorderStartegy;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.CustomMenuMenager;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public abstract class BaseCard {

    protected ComponentsSeries<ComponentPanelMenager<AbstractCustomLabel>> titleSeries =
            new ComponentsSeries<>(ComponentsSeries.ComponentsDimension.HORIZONTAL);

    protected DefaultCustomMenuMenager seriesPanel;
    protected GuiFactory factory;
    public BaseCard(GuiFactory factory) {
        this.factory = factory;
        seriesPanel = new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.VERTICAL,
                ComponentsSeries.ComponentsDimension.HORIZONTAL);
        initSeriesPanel(titleSeries, 0, 6);
        initSeriesPanel(ComponentPanelMenager.createEmptyInstance(), 1, 14);

        initializeTitle();
        seriesPanel.getCmp().setBorderData(Color.RED, new AverageBorderStartegy(), 8);
    }




    protected void initSeriesPanel(JComponent content, int mainIndex, int weight) {
        seriesPanel.addMainComponent(weight);
        seriesPanel.addMiddleComponent(content, mainIndex, 10);
    }


    public void setBackgroundImage(String path) throws IOException {
        seriesPanel.getCmp().setBackgroundImage(path);
    }

    public void setBackgroundColor(Color color) {
        seriesPanel.setBackground(color);
    }

    public JPanel getPanel() {
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


    public void initializeTitle() {//zmienia sie
        factory.setLabelType(GuiFactory.LabelType.ICON);
        titleSeries.addOption(new ComponentPanelMenager<>(factory.createLabel(Card.EMPTY_DATA_CONTENT)), 30);
        titleSeries.getOption(0).addSpace(6, ComponentPanelMenager.Side.LEFT, ComponentPanelMenager.Side.TOP);
        titleSeries.getOption(0).addSpace(1, ComponentPanelMenager.Side.RIGHT);
        titleSeries.getOption(0).addSpace(2, ComponentPanelMenager.Side.BOTTOM);

        factory.setLabelType(GuiFactory.LabelType.NORMAL);
        titleSeries.addOption(new ComponentPanelMenager<>(factory.createLabel(Card.EMPTY_DATA_CONTENT)), 30);
        titleSeries.getOption(1).addSpace(6, ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.TOP);
        titleSeries.getOption(1).addSpace(1, ComponentPanelMenager.Side.LEFT);
        titleSeries.getOption(1).addSpace(2, ComponentPanelMenager.Side.BOTTOM);

    }

}
