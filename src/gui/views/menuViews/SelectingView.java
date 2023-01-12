package gui.views.menuViews;

import gui.views.BackgroundView;
import gui.card.SharedCmpsFont;
import gui.customComponents.AbstractCustomButton;
import gui.customComponents.AbstractCustomLabel;
import gui.customUI.customUIStyles.borderStrategies.DefaultBorderStrategy;
import gui.customUI.customUIStyles.borderStrategies.DependantHeightBorderStrategy;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;
import java.awt.*;
import java.util.AbstractMap;
import java.util.ArrayList;

public class SelectingView extends BackgroundView {
    private GuiFactory factory;
    private ArrayList<AbstractCustomButton> buttons = new ArrayList<>();
    private ArrayList<AbstractCustomLabel> labels = new ArrayList<>();
    private AbstractCustomButton returnButton;
    private DefaultCustomMenuMenager manager =
            new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.VERTICAL,
                    ComponentsSeries.ComponentsDimension.HORIZONTAL);

    public SelectingView(GuiFactory factory, ArrayList<AbstractMap.SimpleEntry<String, String>> content) {
        this.factory = factory;
        manager.addMainComponent(20);
        manager.addMainComponent(10);
        manager.addMainComponent(5);

        factory.setButtonType(GuiFactory.ButtonType.ICON);
        factory.setLabelType(GuiFactory.LabelType.NORMAL);
        manager.getCmp().addSpace(4, ComponentPanelMenager.Side.TOP);
        manager.getCmp().addSpace(2, ComponentPanelMenager.Side.BOTTOM);
        int i = 0;
        for (var pair : content) {
            createPanel(pair.getKey(), pair.getValue(), i++);
        }
        createReturnButton();
        SharedCmpsFont.setUniformFont(labels);
        manager.getCmp().setBorderData(new Color(0x4D0202), new DefaultBorderStrategy(), 10);
    }

    public JPanel getPanel() {
        return manager.getCmp();
    }

    public void createReturnButton() {
        factory.setButtonType(GuiFactory.ButtonType.NORMAL);
        factory.setBorderStrategy(new DependantHeightBorderStrategy());
        returnButton = factory.createButton("RETURN", null);
        manager.addMiddleComponent(returnButton, 2, 10);
        manager.getMiddleComponent(2, 0).addSpace(5, ComponentPanelMenager.Side.RIGHT,
                ComponentPanelMenager.Side.LEFT, ComponentPanelMenager.Side.TOP);
    }

    public JButton getButton(int index) {
        return buttons.get(index);
    }

    public AbstractCustomButton getReturnButton() {
        return returnButton;
    }

    public void createPanel(String path, String text, int index) {
        var button = factory.createButton(path, null);
        buttons.add(button);
        manager.addMiddleComponent(button, 0, 10);

        manager.getMiddleComponent(0, index).addSpace(1);

        var label = factory.createLabel(text);
        labels.add(label);
        manager.addMiddleComponent(label, 1, 10);

        manager.getMiddleComponent(1, index).addSpace(2);
        manager.getMiddleComponent(1, index).addSpace(10, ComponentPanelMenager.Side.BOTTOM);
    }

    @Override
    protected DefaultCustomMenuMenager getMenager() {
        return manager;
    }
}
