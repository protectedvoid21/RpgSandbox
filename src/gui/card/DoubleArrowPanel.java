package gui.card;

import gui.customComponents.AbstractCustomButton;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;
import gui.utils.StringAdapter;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.AbstractMap;
import java.util.Map;

public class DoubleArrowPanel {

    private SwitchableComponent switchableComponent;
    private DefaultCustomMenuMenager<AbstractCustomButton> menager =
            new DefaultCustomMenuMenager<>(ComponentsSeries.ComponentsDimension.VERTICAL,
                    ComponentsSeries.ComponentsDimension.HORIZONTAL);

    private GuiFactory factory;

    public enum Side {LEFT, RIGHT}

    public DoubleArrowPanel(GuiFactory factory, SwitchableComponent cmp, Map<Side,
            AbstractMap.SimpleEntry<String, String>> arrowPaths) {
        this.factory = factory;
        this.switchableComponent = cmp;
        menager.addMainComponent(10);
        createArrowPanel(arrowPaths);

        getButton(Side.RIGHT).addActionListener(e -> arrowMethod(Side.RIGHT));
        getButton(Side.LEFT).addActionListener(e -> arrowMethod(Side.LEFT));

    }

    private void arrowMethod(Side side ){
        if (switchableComponent.isSwitchingSidePossible(side)) {
            switchableComponent.switchSide(side);
            updateSwitchingButtons();
        }
    }

    public void updateSwitchingButtons(){
        checkTurningButton(Side.LEFT);
        checkTurningButton(Side.RIGHT);
    }

    private void checkTurningButton(Side side){
        if (!switchableComponent.isSwitchingSidePossible(side)) {
            getButton(side).setEnabled(false);
        } else {
            getButton(side).setEnabled(true);
        }
    }

    public void setSwitchableComponent(SwitchableComponent cmp){
        switchableComponent = cmp;
        updateSwitchingButtons();
    }

    public DoubleArrowPanel(GuiFactory factory, SwitchableComponent switchableComponent) {

        this(factory, switchableComponent, Map.of(Side.LEFT, new AbstractMap.SimpleEntry<>(StringAdapter.getRelativePath("leftarrowactive" +
                ".png"), StringAdapter.getRelativePath("leftarrowdisabled.png")), Side.RIGHT, new AbstractMap.SimpleEntry<>(StringAdapter.getRelativePath("rightarrowactive.png"),
                StringAdapter.getRelativePath("rightarrowdisabled.png"))));

    }


    public ComponentPanelMenager<JComponent> getPanel() {
        return menager.getCmp();
    }

    private AbstractCustomButton getButton(Side side) {
        return menager.getMiddleComponent(0, side == Side.LEFT ? 0 : 1).getComponent();
    }

    private void addCmp(String pathEnabled, String pathDisabled) {
        factory.setButtonType(GuiFactory.ButtonType.DISABLED_ICON);
        menager.addMiddleComponent(factory.createButton(pathEnabled, pathDisabled, null), 0, 10);
    }

    public void addListener(Side side, ActionListener listener) {
        getButton(side).addActionListener(listener);
    }

    private void createArrowPanel(Map<Side, AbstractMap.SimpleEntry<String, String>> arrowPaths) {
        addCmp(arrowPaths.get(Side.LEFT).getKey(), arrowPaths.get(Side.LEFT).getValue());
        menager.getMiddleComponent(0, 0).addSpace(3, ComponentPanelMenager.Side.RIGHT);
        addCmp(arrowPaths.get(Side.RIGHT).getKey(), arrowPaths.get(Side.RIGHT).getValue());
        menager.getMiddleComponent(0, 1).addSpace(3, ComponentPanelMenager.Side.LEFT);

    }

    public void setSpace(int value, ComponentPanelMenager.Side... sides) {
        menager.getCmp().addSpace(value, sides);
    }

    public void setSpace(int value) {
        menager.getCmp().addSpace(value);
    }


}
