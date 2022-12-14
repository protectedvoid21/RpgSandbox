package gui.card.fullCards.abstractCards;

import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.*;
import gui.customComponents.customTextComponents.CustomTextComponent;
import gui.customUI.customUIStyles.borderStrategies.AverageBorderStartegy;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;
import gui.menu.ICustomBackgorund;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;

public abstract class BaseCard implements ICustomBackgorund {

    protected ComponentsSeries<ComponentPanelMenager<? extends JComponent>> titleSeries =
            new ComponentsSeries<>(ComponentsSeries.ComponentsDimension.HORIZONTAL);
    protected ComponentPanelMenager<AbstractCustomLabel> leftTitleComponent;
    protected ComponentPanelMenager<AbstractCustomLabel> rightTitleComponent;
    protected ComponentPanelMenager<CustomTextComponent> rightEntryTitleComponent;

    protected DefaultCustomMenuMenager seriesPanel;
    protected GuiFactory factory;

    public BaseCard(GuiFactory factory) {
        this.factory = factory;
        seriesPanel = new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.VERTICAL,
                ComponentsSeries.ComponentsDimension.HORIZONTAL);
        initSeriesPanel(titleSeries, 0, 6);
//        initSeriesPanel(ComponentPanelMenager.createEmptyInstance(), 1, 14);

        initializeTitle();
        seriesPanel.getCmp().setBorderData(Color.RED, new AverageBorderStartegy(), 8);
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
        leftTitleComponent = new ComponentPanelMenager<>(factory.createLabel(Card.EMPTY_DATA_CONTENT));
        titleSeries.addOption(leftTitleComponent, 30);
        titleSeries.getOption(0).addSpace(6, ComponentPanelMenager.Side.LEFT, ComponentPanelMenager.Side.TOP);
        titleSeries.getOption(0).addSpace(1, ComponentPanelMenager.Side.RIGHT);
        titleSeries.getOption(0).addSpace(2, ComponentPanelMenager.Side.BOTTOM);

        factory.setLabelType(GuiFactory.LabelType.NORMAL);
        rightTitleComponent = new ComponentPanelMenager<>(factory.createLabel(Card.EMPTY_DATA_CONTENT));
        rightEntryTitleComponent = new ComponentPanelMenager<>(factory.createTextField());

        int index = 1;
        for (var title : Arrays.asList(rightTitleComponent, rightEntryTitleComponent)) {
            titleSeries.addOption(title, 30);
            titleSeries.getOption(index).addSpace(6, ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.TOP);
            titleSeries.getOption(index).addSpace(1, ComponentPanelMenager.Side.LEFT);
            titleSeries.getOption(index).addSpace(2, ComponentPanelMenager.Side.BOTTOM);
            index = 2;
        }
        rightEntryTitleComponent.setVisible(false);

    }


    public abstract void initialize();

}
