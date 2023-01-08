package gui.menuViews;

import gui.card.SharedCmpsFont;
import gui.customComponents.AbstractCustomButton;
import gui.customComponents.AbstractCustomLabel;
import gui.customComponents.CustomLabel;
import gui.customUI.customUIStyles.borderStrategies.DefaultBorderStrategy;
import gui.customUI.customUIStyles.borderStrategies.DependantHeightBorderStrategy;
import gui.factories.GuiFactory;
import gui.factories.customFactories.buttonFactories.MenuButtonsFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;
import gui.menu.ICustomBackgorund;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class MenuView implements ICustomBackgorund {
    private GuiFactory factory;
//    private AbstractCustomLabel customLabel;
    private ArrayList<AbstractCustomButton> buttons = new ArrayList<>();
    private DefaultCustomMenuMenager manager = new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.VERTICAL, ComponentsSeries.ComponentsDimension.HORIZONTAL);

    public MenuView(GuiFactory factory){
        this.factory =factory;
        manager.getCmp().addSpace(2, ComponentPanelMenager.Side.BOTTOM, ComponentPanelMenager.Side.TOP);
        manager.getCmp().addSpace(2, ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.LEFT);
        manager.addMainComponent(14);
        manager.addMiddleComponent( factory.createLabel("OUR GAME TITLE"), 0, 1);
        manager.getMiddleComponent(0,0).addSpace(3, ComponentPanelMenager.Side.BOTTOM);
        createButton("NEW GAME", 1);
        createButton("CREATOR", 2);
        createButton("DATABASE", 3);
        createButton("SETTINGS", 4);
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
    public void setBackgroundImage(String path) {
        try {
            System.out.println("xx");
            manager.getCmp().setBackgroundImage(path);
        } catch (IOException e) {
            System.out.println("xx");
            setBackground(new Color(0x935D3A));
        }
    }

    @Override
    public void setBackground(Color color) {
manager.setBackground(color);
    }
}
