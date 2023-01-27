package gui.card.fullCards.specificCards.onlyVisibleCards;

import gui.card.SharedCmpsFont;
import gui.customComponents.AbstractCustomButton;
import gui.factories.GuiFactory;

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
        showbutton = factory.createButton(showText, null);
        editButton = factory.createButton(editText, null);
        deleteButton = factory.createButton(deleteText, null);
        var list = Arrays.asList(editButton, deleteButton, showbutton);
        for (var but : list){
            int i = 0;
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
