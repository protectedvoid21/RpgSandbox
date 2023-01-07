package gui.card.contentCards.detailCards;

import gui.card.CardContentDataSet;
import gui.card.fullCards.abstractCards.Card;
import gui.card.SharedCmpsFont;
import gui.customComponents.booleanComponents.CustomIconBooleanButton;
import gui.factories.GuiFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class AddingButtonCard extends NormalDetailButtonsCard {
    protected ArrayList<CustomIconBooleanButton> selectList;

    private ArrayList<Integer> addedIndexes = new ArrayList<>();


    public AddingButtonCard(GuiFactory factory) {
        super(factory);
    }

//    @Override
//    protected ArrayList<? extends IContentCustomUICmp> getContentList() {
//        return selectList;
//    }


//    public AbstractCustomButton getSelectButton(int index) {
//        return selectList.get(index);
//    }
//
//    public void setSelectedIndex(int value){
//        selectedIndex = value;
//    }

    public ArrayList<CardContentDataSet> getDetailOnlyAddedIndexesData() {
        var newData = new ArrayList<CardContentDataSet>();
//        System.out.println(detailData);
        for (var index : addedIndexes) {
            newData.add(detailData.get(index));
        }
        return newData;
    }

    public CardContentDataSet getOnlyAddedIndexesData() {
        var newData = new CardContentDataSet();
        newData.titleContent = data.titleContent;
        newData.titlePath = data.titlePath;
        newData.content = new ArrayList<>();
        for (var index : addedIndexes) {
            newData.content.add(data.content.get(index));

        }
        return newData;
    }

    public ArrayList<Integer> getAddedIndexes() {
        return addedIndexes;
    }

    public void setAddedIndexes(ArrayList<Integer> addedIndexes) {
        this.addedIndexes = addedIndexes;
    }


    @Override
    protected void updateContent() {
        super.updateContent();
        int maxSideIndex = getSideMaximumElementsNumber();
        int dataSize = data.content.size();
        var sublist = data.content.subList(currentAttrSide * maximumElementNumber, maxSideIndex > dataSize ? dataSize :
                maxSideIndex);
        int currentIndex = 0;


        for (int i = currentAttrSide * maximumElementNumber; i < getSideMaximumElementsNumber(); i++) {
            if (addedIndexes.contains(i)) {
                selectList.get(i % maximumElementNumber).setContent("");
            } else {
                selectList.get(i % maximumElementNumber).setContent("es");
            }

        }
        Card.setAspectVisible(selectList, true);
        for (int i = data.content.size(); i < getSideMaximumElementsNumber(); i++) {
            selectList.get(i % maximumElementNumber).setVisible(false);
        }
    }

    @Override
    protected void initializeContent() {

        super.initializeContent();
        selectList = new ArrayList<>();
        for (int i = 0; i < maximumElementNumber; i++) {
            factory.setButtonType(GuiFactory.ButtonType.ICON);
            var but = factory.createButton("src/gui/plus.png", "src/gui/remove.png", true, true);
            selectList.add(but);
            but.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    var ind = currentAttrSide * maximumElementNumber + selectList.indexOf(but);
                    if (addedIndexes.contains(ind)) {

                        addedIndexes.remove(addedIndexes.indexOf(ind));
                    } else {
                        addedIndexes.add(ind);
                    }
                }

            });
            menager.addMiddleComponent(but, 3, 20);
            menager.getMainComponent(3).getComponent().getLastComponent().addSpace(4);
        }

    }


    @Override
    protected void initializeCard(int maximumElementNumber) {
        super.initializeCard(maximumElementNumber);
        getContentMenager().addMainComponent(10);

    }

    @Override
    public void setUniformForm() {
        super.setUniformForm();
        SharedCmpsFont.setUniformFont(selectList);
    }

}