package gui.views;

import gui.customComponents.AbstractCustomLabel;
import gui.customUI.customUIStyles.borderStrategies.DependantHeightBorderStrategy;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;
import java.io.IOException;

public class TitleView {
    private DefaultCustomMenuMenager<JComponent> manager =
            new DefaultCustomMenuMenager<>(ComponentsSeries.ComponentsDimension.VERTICAL,
                    ComponentsSeries.ComponentsDimension.HORIZONTAL);
    private AbstractCustomLabel label;
    private GuiFactory factory;


    public TitleView(GuiFactory factory) {
        this.factory = factory;
    }

    public <T extends PanelContainer> void initialize(String text, T panel, int size, int space) {
        factory.setLabelType(GuiFactory.LabelType.NORMAL);
        manager.addMainComponent(size, 100);
        manager.addMainComponent(100 - size);
        manager.setHasUniqueColor(panel.getPanel().isHasUniqueColor());
        manager.setBackground(panel.getPanel().getBackground());
        try {
            manager.getCmp().setBackgroundImage(panel.getPanel().getBackgroundImage());
        } catch (IOException e) {
        }

        label = factory.createLabel(text);
        label.getCustomUI().changeBorderStrategy(new DependantHeightBorderStrategy());
        manager.addMiddleComponent(label, 0, 10);
        manager.addMiddleComponent(panel.getPanel(), 1, 10);
        manager.getMainComponent(0).addSpace(space, ComponentPanelMenager.Side.LEFT, ComponentPanelMenager.Side.RIGHT);
        manager.getMainComponent(0).addSpace(15, ComponentPanelMenager.Side.TOP);
    }

    public <T extends PanelContainer> void initialize(String text, T panel) {
        initialize(text, panel, 6, 20);
    }

    public <T extends PanelContainer> void initializeBySize(String text, T panel, int size) {
        initialize(text, panel, size, 20);
    }

    public <T extends PanelContainer> void initializeBySpace(String text, T panel, int space) {
        initialize(text, panel, 6, space);
    }


    public ComponentPanelMenager getPanel() {
        return manager.getCmp();
    }
}
