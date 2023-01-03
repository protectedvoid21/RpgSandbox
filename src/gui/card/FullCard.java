//package gui.card;
//
//import gui.factories.GuiFactory;
//
//import javax.swing.*;
//import java.awt.event.ActionListener;
//import java.util.AbstractMap;
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class FullCard {
//    GuiFactory factory;
//    private Card card;
//
//    private HashMap<Card.CardTypes, AbstractCard> cards = new HashMap<>();
//
//    public FullCard(Card card, GuiFactory factory) {
//        this.card = card;
//        this.factory = factory;
//        initializeCards();
//    }
//
//    private void initializeCards() {
//        cards.put(Card.CardTypes.ATTRIBUTE, new AttributesCard(factory));
//        cards.put(Card.CardTypes.WEAPONS, new DetailButtonsCard(factory));
//        cards.put(Card.CardTypes.MOUNT, new DetailButtonsCard(factory));
//        cards.put(Card.CardTypes.ARMOR, new DetailButtonsCard(factory));
//
//        var map = new HashMap<Card.CardTypes, ActionListener>();
//
//        for (var key : Card.CardTypes.values()) {
//            map.put(key, e -> card.switchSide(key));
//        }
////        var overallCard = new OverallCard(factory, map);
//
////        cards.put(Card.CardTypes.OVERALL, overallCard);
//
//    }
//
//
//    public void changeCard(Card newCard) {
//        card = newCard;
//        card.initializeWholeCard();
//    }
//
//    public void initializeContentOfCard(Card.CardTypes type, ArrayList<ArrayList<String>> dataMap) {
//        cards.get(type).initializeCardData(dataMap);
//    }
//
//    public void initializeTitleOfCard(Card.CardTypes type, AbstractMap.SimpleEntry<String, String> titleIconPathName) {
//        cards.get(type).initializeCardData(titleIconPathName);
//    }
//
//    public JPanel getPanel(){
//        return card.getPanel();
//    }
//
//}
