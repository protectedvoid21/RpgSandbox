package gui.card.fullCards.specificCards;

import gui.card.CardContentDataSet;
import gui.card.contentCards.attributesCards.AttributesCard;
import gui.card.contentCards.attributesCards.EntriesAttributesCard;
import gui.card.contentCards.attributesCards.LabelAttributeCard;
import gui.card.contentCards.detailCards.AddingButtonCard;
import gui.card.contentCards.detailCards.AddingItemButtonCard;
import gui.card.contentCards.detailCards.DetailButtonsCard;
import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.AbstractCustomButton;
import gui.customComponents.customTextComponents.CustomTextComponent;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class EntriesCard extends Card {
    public enum EntryType {SPINNER, ENTRY}

    //    private HashMap<CardTypes, CardContentDataSet> baseAddingTypesData = new HashMap<>();
//    private HashMap<CardTypes, ArrayList<CardContentDataSet>> addingTypesData = new HashMap<>();
    private CustomTextComponent textComponentTitle;
    private AddingButtonCard choserEqCard2 = null;
    private ChoserCard choserCard;
    protected ComponentPanelMenager<AbstractCustomButton> addButton;
    private JComponent helpPanelVariable;

    public EntriesCard(GuiFactory factory) {
        super(factory);
    }

    public HashMap<CardTypes, CardContentDataSet> generateContentData() {
        var newMapa = new HashMap<CardTypes, CardContentDataSet>();
//        var attr= new CardContentDataSet();
//        attr.titlePath = allCards.get(CardTypes.ATTRIBUTE).getData().titlePath;
//        attr.titlePath = allCards.get(CardTypes.ATTRIBUTE).getData().titlePath;
        newMapa.put(CardTypes.ATTRIBUTE, allCards.get(CardTypes.ATTRIBUTE).getData());
        for (var type : allCards.keySet()){
            newMapa.put(type, allCards.get(type).getData());
        }

//        for (var key : allCards.keySet()) {
//            var database = new Content
////            database.get
//        }
        return newMapa;
    }
    public HashMap<CardTypes, CardContentDataSet> getIndexesData(){
        var newMapa = new HashMap<CardTypes, CardContentDataSet>();
        for (var type : Arrays.asList(CardTypes.ARMOR, CardTypes.WEAPONS, CardTypes.MOUNT, CardTypes.ITEMS)){
            newMapa.put(type, choserCard.getGameSelectedCard(type).getOnlyAddedIndexesData());
        }//niepotrzebn ale kto wie...
        return newMapa;

    }

    public HashMap<CardTypes, ArrayList<Integer>> generateIndexesNumberData(){
        var newMapa = new HashMap<CardTypes, ArrayList<Integer>>();
        for (var type : Arrays.asList(CardTypes.ARMOR, CardTypes.WEAPONS, CardTypes.MOUNT, CardTypes.ITEMS)){
            newMapa.put(type, choserCard.getGameSelectedCard(type).getAddedIndexes());
        }
        return newMapa;
    }


    @Override
    protected DetailButtonsCard createDetailButtonCard(CardTypes type) {
        var card = new AddingItemButtonCard(factory);

        card.getPlusButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
////                choserEqCard2.initializeCardData(baseAddingTypesData.get(type));
////        equipmentCard.initializeCardData(allCards.get(type).getData(), allCards.get());
//                updateContent(choserEqCard2);
//                arrowMenager.getOption(1).changeContent(addButton);//yyyyto fix
//                showCancelButton(false);
                choserCard.switchSide(type);
                System.out.println(allCards.get(type).getData());
                System.out.println(allCards.get(type).getDetailData());
                System.out.println(type);
                System.out.println(getIndexesData());
                System.out.println(generateContentData());
//                helpPanelVariable= getPanel();

                seriesPanel.getCmp().changeContent(choserCard.getPanel());
//               seriesPanel.getMiddleComponent(1, 0).changeContent(choserCard.getSecondContentPanel());
//                seriesPanel.getMiddleComponent(2, 0).changeContent(choserCard.getThirdContentPanel());}
            }
        });
        return card;
    }

    public void setCurrentCardType(CardTypes type) {
        choserCard.setCurrentType(type);
    }

    @Override
    public void initialize() {
        super.initialize();
        choserCard = new ChoserCard(factory);
        choserCard.initialize();
        helpPanelVariable = seriesPanel.getCmp().getComponent();
        choserCard.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seriesPanel.getCmp().changeContent(helpPanelVariable);
                allCards.get(choserCard.getCurrentCardType()).initializeCardData(choserCard.getCurrentData(),
                        choserCard.getCurrentDetailData());
                updateContent();
//                detailTypesData.replace(choserCard.getCurrentCardType(),choserCard.getCurrentDetailData() );
            }
        });
//        choserCard.uploadNewData(detailTypesData2,detailTypesData );
    }


    @Override
    public void uploadNewData(LinkedHashMap<CardTypes, CardContentDataSet> newData, HashMap<CardTypes,
            ArrayList<CardContentDataSet>> detailData) {
        super.uploadNewData(newData, detailData);

//        for (var key : detailData.keySet()){
//            var array = new ArrayList<Integer>();
//
//            for (var data : detailData.get(key)){
//                if (newData.get(key).equals(data)){
//                    array.add(detailData.get(key).indexOf(data));
//                }
//            }
//            System.out.println(array+"lista indeksow");
//            choserCard.getGameSelectedCard(key).setAddedIndexes(array);
//        }

//        for (var content : )
//        System.out.println(detailData+"hahahah");
        uploadNewChoserCardData(newData, detailData);
    }

    public void uploadNewChoserCardData(LinkedHashMap<CardTypes, CardContentDataSet> newData, HashMap<CardTypes,
            ArrayList<CardContentDataSet>> detailData) {
//        System.out.println(newData+"  "+detailData);
//        System.out.println(detailData+"  "+newData+"uaasdjasjdjasdjasjda");
        choserCard.uploadNewData(newData, detailData);
        for (var key : detailData.keySet()) {
            choserCard.setCurrentType(key);
            var array = new ArrayList<Integer>();

            for (var data : detailData.get(key)) {
                for (var data2 : allCards.get(key).getDetailData()) {
                    if (data.equals(data2) && !array.contains(detailData.get(key).indexOf(data))) {
                        array.add(detailData.get(key).indexOf(data));
                    }
                }
            }
//            System.out.println(array + "lista indeksow");
//            choserCard.setCurrentType(key);
            choserCard.getGameSelectedCard(key).setAddedIndexes(array);
            choserCard.getGameSelectedCard(key).reset();
//            System.out.println(choserCard.getCurrentData()
//            +"hahahahhahahahhahahahhahahahhahahahhahahahhahahahhahahahhahahahhahahahhahahahhahahahhahahahhahahahhahahahhahahahhahahahhahahahhahahahhahahahhahahahs");
            allCards.get(key).initializeCardData(choserCard.getCurrentData(),
                    choserCard.getCurrentDetailData());
        }
        updateContent();
        choserCard.updateContent();
    }

    @Override
    protected AttributesCard createAttributeCard() {
        return new EntriesAttributesCard(factory);
    }

    @Override
    protected AttributesCard createDetailItemCard() {
        return new LabelAttributeCard(factory);
    }


    @Override
    protected void updateTitle() {
        super.updateTitle();

        if (activeCard == allCards.get(CardTypes.OVERALL)) {
            rightTitleComponent.setVisible(false);
            rightEntryTitleComponent.setVisible(true);
        } else {
            rightEntryTitleComponent.setVisible(false);
            rightTitleComponent.setVisible(true);
        }
//        System.out.println("foreground " + rightEntryTitleComponent.getForeground() + "  " +
//        rightEntryTitleComponent.getBackground());
    }

    @Override
    public void initializeTitle() {
        super.initializeTitle();
        textComponentTitle = factory.createTextField();
    }

//    @Override
//    public ComponentPanelMenager<? extends IContentCustomUICmp> getRightTitleComponent() {
//        return rightEntryTitleComponent;
//    }

}
