//package gui.card.contentCards.detailCards;
//
//import gui.card.fullCards.abstractCards.Card;
//import gui.customComponents.IContentCustomUICmp;
//import gui.customComponents.customTextComponents.CustomTextComponent;
//import gui.factories.GuiFactory;
//
//import javax.swing.*;
//import java.util.ArrayList;
//
//public class EntriesDetailButtonsCard extends DetailButtonsCard {
//    private ArrayList<CustomTextComponent> list = new ArrayList<>();
//    public EntriesDetailButtonsCard(GuiFactory factory) {
//        super(factory);
//    }
//
//    @Override
//    protected ArrayList<? extends IContentCustomUICmp> getContentList() {
//        return list;
//    }
//
//
//    @Override
//    protected void updateContent() {
//        super.updateContent();
//        Card.setAspectVisible(list, true);
//    }
//
//    @Override
//    protected JComponent createContentSegment() {
//        var textField = factory.createTextField();
//        list.add(textField);
//        return textField;
//    }
//}
