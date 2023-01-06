package gui.card.contentCards.attributesCards;

import gui.card.CardContentDataSet;
import gui.card.fullCards.abstractCards.Card;
import gui.card.SharedCmpsFont;
import gui.customComponents.CustomBooleanButton;
import gui.customComponents.IContentCustomUICmp;
import gui.customComponents.customTextComponents.CustomTextComponent;
import gui.customUI.customUIStyles.borderStrategies.DependantHeightBorderStrategy;
import gui.factories.GuiFactory;
import gui.menu.ComponentsSeries;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class EntriesAttributesCard extends AttributesCard {
    private ArrayList<CustomTextComponent> entriesList = new ArrayList<>();
    private ArrayList<CustomBooleanButton> buttonBooleanList = new ArrayList<>();

    public EntriesAttributesCard(GuiFactory factory) {
        super(factory);
    }

    @Override
    protected JComponent createSecondContentComponent() {
//        factory.set(GuiFactory.LabelType.NORMAL);
        var series = new ComponentsSeries<JComponent>(ComponentsSeries.ComponentsDimension.VERTICAL);
        var x = factory.createButton("YES", "NO", true);
        x.getCustomUI().changeBorderStrategy(new DependantHeightBorderStrategy());
        buttonBooleanList.add(x);
        var y = factory.createTextField();
        entriesList.add(y);
        series.addOption(y, 10);
        series.addOption(x, 10);
        System.out.println(series.getComponentsList());
        return series;
    }


    @Override
    protected ArrayList<? extends IContentCustomUICmp> getSecondContentList() {
        var array = new ArrayList<IContentCustomUICmp>();
        for (int i = currentAttrSide*maximumElementNumber; i<getSideMaximumElementsNumber(); i++){
            if (data.dataType.get(i)== CardContentDataSet.DataType.STRING){
                array.add(entriesList.get(i%5));
//                entriesList.get(i%5).setVisible(true);
//                buttonBooleanList.get(i%5).setVisible(false);
            }else{
                array.add(buttonBooleanList.get(i%5));
//                entriesList.get(i%5).setVisible(false);
//                buttonBooleanList.get(i%5).setVisible(true);
            }
        }
        return array;
    }

    @Override
    public void setUniformForm() {
        super.setUniformForm();
        SharedCmpsFont.setUniformFont(entriesList);
        SharedCmpsFont.setUniformFont(buttonBooleanList);
    }

    @Override
    protected void updateContent() {
        super.updateContent();
        for (int i = currentAttrSide*maximumElementNumber; i<getSideMaximumElementsNumber(); i++){
            if (data.dataType.get(i)== CardContentDataSet.DataType.STRING){
//                array.add(entriesList.get(i%5));
                entriesList.get(i%maximumElementNumber).setVisible(true);
                buttonBooleanList.get(i%maximumElementNumber).setVisible(false);
            }else{
//                array.add(buttonBooleanList.get(i%5));
                entriesList.get(i%maximumElementNumber).setVisible(false);
                buttonBooleanList.get(i%maximumElementNumber).setVisible(true);
            }
        }
        for (int i = data.content.size();i< getSideMaximumElementsNumber(); i++){
            entriesList.get(i%maximumElementNumber).setVisible(false);
            buttonBooleanList.get(i%maximumElementNumber).setVisible(false);
        }
//        java.awt.Color[r=128,g=128,b=128]
//        javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
//        java.awt.Color[r=0,g=0,b=255]
//        for (int i = )
//        Card.setAspectVisible(entriesList, true);
//        Card.setAspectVisible(buttonBooleanList, true);
    }
}
