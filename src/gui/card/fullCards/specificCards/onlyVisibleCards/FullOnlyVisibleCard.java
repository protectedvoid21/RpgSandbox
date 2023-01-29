package gui.card.fullCards.specificCards.onlyVisibleCards;

import gui.bundle.CustomBundle;
import gui.card.SharedCmpsFont;
import gui.customComponents.abstractComponents.AbstractCustomButton;
import gui.factories.GuiFactory;
import gui.margin.ComponentTextMarginManager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FullOnlyVisibleCard extends OnlyVisibleCard{
    private AbstractCustomButton editButton;
    private AbstractCustomButton deleteButton;
    private AbstractCustomButton showbutton;
    public FullOnlyVisibleCard(GuiFactory factory) {
        super(factory);
    }

    protected void initializeDownPanel(){
        showbutton = factory.createButton(CustomBundle.getString(showText), null);
        editButton = factory.createButton(CustomBundle.getString(editText), null);
        deleteButton = factory.createButton(CustomBundle.getString(deleteText), null);
        var list = Arrays.asList(editButton, deleteButton, showbutton);
        for (var but : list){
            but.getCustomUI().getMargin().set(ComponentTextMarginManager.Side.LEFT, 3);
            but.getCustomUI().getMargin().set(ComponentTextMarginManager.Side.RIGHT, 3);
            seriesPanel.addMiddleComponent(but, 2, 10);
            seriesPanel.getMiddleComponent(2, list.indexOf(but)).addSpace(4);
        }
    }
    public boolean containsButton(JButton button){
        return button==deleteButton || button==editButton || button==showbutton;
    }
    public AbstractCustomButton getEditButton() {
        return editButton;
    }
    public AbstractCustomButton getDeleteButton() {
        return deleteButton;
    }

    public AbstractCustomButton getShowbutton(){
        return showbutton;
    }
    @Override
    public void setUniformFont() {
        SharedCmpsFont.setUniformFont(new ArrayList<>(Arrays.asList(editButton, deleteButton, showbutton)));
    }
}
