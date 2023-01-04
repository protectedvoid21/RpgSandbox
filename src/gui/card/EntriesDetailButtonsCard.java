package gui.card;

import gui.customComponents.IContentCustomUICmp;
import gui.customComponents.customTextComponents.CustomTextArea;
import gui.customComponents.customTextComponents.CustomTextComponent;
import gui.factories.GuiFactory;

import javax.swing.*;
import java.util.ArrayList;

public class EntriesDetailButtonsCard extends DetailButtonsCard{
    private ArrayList<CustomTextComponent> list = new ArrayList<>();
    public EntriesDetailButtonsCard(GuiFactory factory) {
        super(factory);
    }

    @Override
    protected ArrayList<? extends IContentCustomUICmp> getContentList() {
        return list;
    }

    @Override
    protected void initContentSegment() {
        var label = factory.createTextField();
        menager.addMiddleComponent(label, 1, 20);
        menager.getMainComponent(1).getComponent().getLastComponent().addSpace(2);
        list.add(label);
    }

    @Override
    protected void updateContent() {
        super.updateContent();
        Card.setAspectVisible(list, true);
    }
}
