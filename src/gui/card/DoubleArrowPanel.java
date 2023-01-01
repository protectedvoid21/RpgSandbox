package gui.card;

import gui.customComponents.CustomButton;
import gui.customComponents.CustomLabel;
import gui.customComponents.iconComponents.StretchIcon;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class DoubleArrowPanel {
    private DefaultCustomMenuMenager<CustomButton> menager =
            new DefaultCustomMenuMenager<>(ComponentsSeries.ComponentsDimension.VERTICAL,
                    ComponentsSeries.ComponentsDimension.HORIZONTAL);

    private GuiFactory factory;

    public enum Side {LEFT, RIGHT}

    public DoubleArrowPanel(GuiFactory factory, Map<Side, AbstractMap.SimpleEntry<String, String>> arrowPaths) {
        this.factory = factory;
        menager.addMainComponent(10);
        createArrowPanel(arrowPaths);

    }

    public DoubleArrowPanel(GuiFactory factory) {

        this(factory, Map.of(Side.LEFT, new AbstractMap.SimpleEntry<>("src/gui/leftarrowactive.png", "src/gui" +
                "/leftarrowdisabled.png"), Side.RIGHT, new AbstractMap.SimpleEntry<>("src/gui/rightarrowactive.png",
                "src/gui/rightarrowdisabled.png")));

    }


    public JPanel getPanel() {
        return menager.getCmp();
    }

    private CustomButton getButton(Side side) {
        return menager.getMiddleComponent(0, side == Side.LEFT ? 0 : 1).getComponent();
    }

    private void addCmp(String pathEnabled, String pathDisabled) {
        factory.setButtonType(GuiFactory.ButtonType.DISABLED_STRETCH_ICON);
        menager.addMiddleComponent(factory.createButton(pathEnabled, pathDisabled, null), 0, 10);
    }

    public void setListener(Side side, ActionListener listener) {
        getButton(side).addActionListener(listener);
    }

    private void createArrowPanel(Map<Side, AbstractMap.SimpleEntry<String, String>> arrowPaths) {
        addCmp(arrowPaths.get(Side.LEFT).getKey(), arrowPaths.get(Side.LEFT).getValue());
        menager.getMiddleComponent(0, 0).addSpace(3, ComponentPanelMenager.Side.RIGHT);
        addCmp(arrowPaths.get(Side.RIGHT).getKey(), arrowPaths.get(Side.RIGHT).getValue());
        menager.getMiddleComponent(0, 1).addSpace(3, ComponentPanelMenager.Side.LEFT);

        System.out.println(getButton(Side.LEFT).getDisabledIcon() + "   heeee");
        System.out.println(getButton(Side.RIGHT).getDisabledIcon() + "   heeee");
    }

    public void setSpace(int value, ComponentPanelMenager.Side... sides) {
        menager.getCmp().addSpace(value, sides);
    }

    public void setSpace(int value) {
        menager.getCmp().addSpace(value);
    }

    public void turnOffButton(Side side) {
        getButton(side).setEnabled(false);
    }

    public void turnOnButton(Side side) {
        getButton(side).setEnabled(true);
    }

}
