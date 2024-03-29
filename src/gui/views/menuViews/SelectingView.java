package gui.views.menuViews;

import gui.views.utilsViews.BackgroundView;
import gui.card.SharedCmpsFont;
import gui.customComponents.abstractComponents.AbstractCustomButton;
import gui.customComponents.abstractComponents.AbstractCustomLabel;
import gui.customUI.customUIStyles.borderStrategies.DependantHeightBorderStrategy;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;
import gui.views.PanelContainer;

import javax.swing.*;
import java.util.AbstractMap;
import java.util.ArrayList;

public class SelectingView extends BackgroundView implements PanelContainer {
    private final GuiFactory factory;
    private final ArrayList<AbstractCustomButton> buttons = new ArrayList<>();
    private final ArrayList<AbstractCustomLabel> labels = new ArrayList<>();
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
        manager.getCmp().addSpace(2, ComponentPanelMenager.Side.TOP);
        manager.getCmp().addSpace(1, ComponentPanelMenager.Side.BOTTOM);
        int i = 0;
        for (var pair : content) {
            createPanel(pair.getKey(), pair.getValue(), i++);
        }
        createReturnButton();
        SharedCmpsFont.setUniformFont(labels);
    }

    public ComponentPanelMenager getPanel() {
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
        button.getCustomUI().setOffSet(3);
        buttons.add(button);
        manager.addMiddleComponent(button, 0, 10);

        manager.getMiddleComponent(0, index).addSpace(1);

        var label = factory.createLabel(text);
        label.getCustomUI().setOffSet(2);
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
