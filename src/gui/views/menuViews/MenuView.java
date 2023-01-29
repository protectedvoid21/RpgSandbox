package gui.views.menuViews;

import gui.bundle.CustomBundle;
import gui.customComponents.booleanComponents.CustomBooleanButton;
import gui.customComponents.booleanComponents.MultiplyButton;
import gui.data.TextData;
import gui.views.utilsViews.BackgroundView;
import gui.card.SharedCmpsFont;
import gui.customComponents.abstractComponents.AbstractCustomButton;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;
import gui.views.PanelContainer;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuView extends BackgroundView implements PanelContainer, TextData {
    private GuiFactory factory;
    private ArrayList<AbstractCustomButton> buttons = new ArrayList<>();
    private CustomBooleanButton audioButton;
    private MultiplyButton multiplyButton;
    private DefaultCustomMenuMenager<JComponent> manager =
            new DefaultCustomMenuMenager<>(ComponentsSeries.ComponentsDimension.VERTICAL,
                    ComponentsSeries.ComponentsDimension.HORIZONTAL);

    public MenuView(GuiFactory factory, String titleGame) {
        this.factory = factory;
        manager.getCmp().addSpace(2, ComponentPanelMenager.Side.BOTTOM, ComponentPanelMenager.Side.TOP);
        manager.getCmp().addSpace(2, ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.LEFT);
        manager.addMainComponent(14);
        factory.setLabelType(GuiFactory.LabelType.NORMAL);
        manager.addMiddleComponent(factory.createLabel(titleGame), 0, 1);
        manager.getMiddleComponent(0, 0).addSpace(3, ComponentPanelMenager.Side.BOTTOM);
        createNormalButton(CustomBundle.getDefaultString(newGameText), 1);
        createNormalButton(CustomBundle.getDefaultString(itemsTextTitle), 2);
        createNormalButton(CustomBundle.getDefaultString(creaturesTextTitle), 3);
        createNormalButton(CustomBundle.getDefaultString(scenarioTextTitle), 4);
        createAudioButton( 5);
        createMultiplyButton( 6);
        createNormalButton(CustomBundle.getDefaultString(exitText), 7);
        SharedCmpsFont.setUniformFont(buttons);
    }

    public void setAudioButtonsListener(ActionListener on, ActionListener off) {
        audioButton.setListeners(on, off);
    }

    private void createNormalButton(String name, int index) {
        factory.setButtonType(GuiFactory.ButtonType.NORMAL);
        AbstractCustomButton button = factory.createButton(name, null);
        setButton(index, button);
    }

    private void createMultiplyButton(int index) {
        factory.setButtonType(GuiFactory.ButtonType.MULTIPLY);
        multiplyButton = factory.createButton();
        setButton(index, multiplyButton);
    }

    private void createAudioButton(int index) {
        factory.setButtonType(GuiFactory.ButtonType.DOUBLE);
        audioButton = factory.createButton(CustomBundle.getDefaultString(soundOn), CustomBundle
            .getDefaultString(soundOff), true);
        setButton(index, audioButton);
    }

    public void addMultipleButtonListeners(ArrayList<String> indexes, ArrayList<ActionListener> listeners){
        multiplyButton.setListeners(indexes, listeners);
    }


    private void setButton(int index, AbstractCustomButton button) {
//        factory.setButtonType(!boolValue ? GuiFactory.ButtonType.NORMAL : GuiFactory.ButtonType.DOUBLE);
//        AbstractCustomButton button;
//        if (!boolValue) {
//            button = factory.createButton(name, null);
//        } else {
//            audioButton = factory.createButton(CustomBundle.getDefaultString(soundOn), CustomBundle
//            .getDefaultString(soundOff), true);
//            button = audioButton;
//        }
        buttons.add(button);
        manager.addMainComponent(10);
        manager.addMiddleComponent(button, index, 10);
        manager.getMiddleComponent(index, 0).addSpace(2, ComponentPanelMenager.Side.TOP,
                ComponentPanelMenager.Side.BOTTOM);
        manager.getMiddleComponent(index, 0).addSpace(1, ComponentPanelMenager.Side.RIGHT,
                ComponentPanelMenager.Side.LEFT);
    }

    public ComponentPanelMenager getPanel() {
        return manager.getCmp();
    }

    public JButton getNewGameButton() {
        return buttons.get(0);
    }

    public JButton getItemsButton() {
        return buttons.get(1);
    }

    public JButton getCreaturesButton() {
        return buttons.get(2);
    }

    public JButton getScenarioButton() {
        return buttons.get(3);
    }

    public JButton getExitButton() {
        return buttons.get(6);
    }

    public int getMultipleButtonIndex(){
        return multiplyButton.getIndex();
    }
    public void settMultipleButtonIndex(int value){
         multiplyButton.setIndex(value);
    }

    @Override
    protected DefaultCustomMenuMenager<JComponent> getMenager() {
        return manager;
    }
}
