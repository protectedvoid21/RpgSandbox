package gui.card;

import gui.customComponents.AbstractCustomLabel;
import gui.customComponents.IContentCustomUICmp;
import gui.customComponents.customTextComponents.CustomTextComponent;
import gui.factories.GuiFactory;

import java.util.ArrayList;

public class NormalDetailButtonsCard extends DetailButtonsCard{

    private ArrayList<AbstractCustomLabel> list = new ArrayList<>();
    public NormalDetailButtonsCard(GuiFactory factory) {
        super(factory);
    }

    @Override
    protected ArrayList<? extends IContentCustomUICmp> getContentList() {
        return list;
    }

    @Override
    protected void initContentSegment() {
        factory.setLabelType(GuiFactory.LabelType.NORMAL);
        var label = factory.createLabel(Card.EMPTY_DATA_CONTENT);
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
