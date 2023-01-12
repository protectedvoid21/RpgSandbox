package gui.views.menuViews;

import gui.views.BackgroundView;
import gui.card.SharedCmpsFont;
import gui.customComponents.AbstractCustomButton;
import gui.customUI.customUIStyles.borderStrategies.DefaultBorderStrategy;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuView extends BackgroundView {
    private GuiFactory factory;
//    private AbstractCustomLabel customLabel;
    private ArrayList<AbstractCustomButton> buttons = new ArrayList<>();
    private DefaultCustomMenuMenager manager = new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.VERTICAL, ComponentsSeries.ComponentsDimension.HORIZONTAL);

    public MenuView(GuiFactory factory){
        this.factory =factory;
        manager.getCmp().addSpace(2, ComponentPanelMenager.Side.BOTTOM, ComponentPanelMenager.Side.TOP);
        manager.getCmp().addSpace(2, ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.LEFT);
        manager.addMainComponent(14);
        manager.addMiddleComponent( factory.createLabel("RPG ENGINE"), 0, 1);
        manager.getMiddleComponent(0,0).addSpace(3, ComponentPanelMenager.Side.BOTTOM);
        createButton("NEW GAME", 1);
        createButton("ITEMS", 2);
        createButton("CREATURES", 3);
        createButton("SCENARIO", 4);
        createButton("EXIT", 5);
        SharedCmpsFont.setUniformFont(buttons);
        manager.getCmp().setBorderData(new Color(0x4D0202), new DefaultBorderStrategy(), 10);

    }

    private void createButton(String name, int index){
        factory.setButtonType(GuiFactory.ButtonType.NORMAL);
        var button = factory.createButton(name, null);
        buttons.add(button);
        manager.addMainComponent(10);
        manager.addMiddleComponent(button, index, 10);
        manager.getMiddleComponent(index, 0).addSpace(2, ComponentPanelMenager.Side.TOP, ComponentPanelMenager.Side.BOTTOM);
        manager.getMiddleComponent(index, 0).addSpace(1, ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.LEFT);
    }
    public JPanel getPanel(){
        return manager.getCmp();
    }

    public JButton getButton(int index){
        return buttons.get(index);
    }

    @Override
    protected DefaultCustomMenuMenager getMenager() {
        return manager;
    }
}
