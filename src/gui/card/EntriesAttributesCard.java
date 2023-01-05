package gui.card;

import gui.customComponents.AbstractCustomLabel;
import gui.customComponents.IContentCustomUICmp;
import gui.customComponents.customTextComponents.CustomTextComponent;
import gui.factories.GuiFactory;

import javax.swing.*;
import java.util.ArrayList;

public class EntriesAttributesCard extends AttributesCard{
    private ArrayList<CustomTextComponent> entriesList = new ArrayList<>();

    public EntriesAttributesCard(GuiFactory factory) {
        super(factory);
    }

    @Override
    protected JComponent createSecondContentComponent() {
//        factory.set(GuiFactory.LabelType.NORMAL);
        var x = factory.createTextField();
        entriesList.add(x);
        return x;
    }


    @Override
    protected ArrayList<? extends IContentCustomUICmp> getSecondContentList() {
        return entriesList;
    }

    @Override
    public void setUniformForm() {
        super.setUniformForm();
        SharedCmpsFont.setUniformFont(entriesList);
    }

    @Override
    protected void updateContent() {
        super.updateContent();
        Card.setAspectVisible(entriesList, true);
    }
}
