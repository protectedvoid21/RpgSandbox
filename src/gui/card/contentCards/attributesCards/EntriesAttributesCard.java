package gui.card.contentCards.attributesCards;

import gui.card.CardContentDataSet;
import gui.card.fullCards.abstractCards.Card;
import gui.card.SharedCmpsFont;
import gui.customComponents.booleanComponents.CustomBooleanButton;
import gui.customComponents.IContentCustomUICmp;
import gui.customComponents.customTextComponents.CustomTextComponent;
import gui.customUI.customUIStyles.borderStrategies.DependantHeightBorderStrategy;
import gui.factories.GuiFactory;
import gui.menu.ComponentsSeries;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Time;
import java.util.ArrayList;

public class EntriesAttributesCard extends AttributesCard {
    private final ArrayList<CustomTextComponent> entriesList = new ArrayList<>();
    private final ArrayList<CustomBooleanButton> buttonBooleanList = new ArrayList<>();

    public EntriesAttributesCard(GuiFactory factory) {
        super(factory);
    }

    public CardContentDataSet generateContentData() {
        for (int i = 0; i < data.content.size(); i++) {
            if (data.dataType.get(i) == CardContentDataSet.DataType.BOOLEAN && !data.content.get(i).isEmpty()) {
                data.content.get(i).set(1, "1");
            }
        }
        return data;
    }
    @Override
    protected JComponent createSecondContentComponent() {
        var series = new ComponentsSeries<>(ComponentsSeries.ComponentsDimension.VERTICAL);
        var x = factory.createButton("YES", "NO", true);
        x.getCustomUI().changeBorderStrategy(new DependantHeightBorderStrategy());
        buttonBooleanList.add(x);
        var y = factory.createTextField();
        x.addActionListener(e -> {
            var index = getSideMaximumElementsNumber() - getMaximumElementNumber() + buttonBooleanList.indexOf(x);
            data.content.get(index).set(1, !x.getStatus() ? "1" : Card.EMPTY_DATA_CONTENT);
        });
        entriesList.add(y);
        y.getTextComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                var index = getSideMaximumElementsNumber() - getMaximumElementNumber() + entriesList.indexOf(y);
                data.content.get(index).set(1, y.getContent());
            }


        });
        series.addOption(y, 10);
        series.addOption(x, 10);
        return series;
    }

    @Override
    public void initializeCardData(CardContentDataSet data, ArrayList detailData) {
        while (data.dataType.size() < maximumElementNumber) {
            data.dataType.add(CardContentDataSet.DataType.STRING);
        }
        super.initializeCardData(data, detailData);
        for (int i = 0; i < data.content.size() && i < data.dataType.size(); i++) {
            if (data.dataType.get(i) == CardContentDataSet.DataType.BOOLEAN) {
                if (!data.content.get(i).get(1).isEmpty()) {
                    data.content.get(i).set(1, "1");
                }
            }
        }
    }

    @Override
    protected ArrayList<? extends IContentCustomUICmp> getSecondContentList() {
        var array = new ArrayList<IContentCustomUICmp>();
        for (int i = currentAttrSide * maximumElementNumber; i < getSideMaximumElementsNumber(); i++) {
            if (i >= data.dataType.size() ||data.dataType.get(i) == CardContentDataSet.DataType.STRING) {
                array.add(entriesList.get(i % 5));
            } else {
                array.add(buttonBooleanList.get(i % 5));
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
    private void setEntryListVisibilty(int index,boolean condiition, boolean condition2){
        entriesList.get(index).setVisible(condiition);
        buttonBooleanList.get(index).setVisible(condition2);
    }

    @Override
    protected void updateContent() {
        super.updateContent();
        for (int i = currentAttrSide * maximumElementNumber; i < getSideMaximumElementsNumber(); i++) {
            var condition = i >= data.dataType.size() || data.dataType.get(i) == CardContentDataSet.DataType.STRING;
            setEntryListVisibilty(i%maximumElementNumber, condition, !condition);
        }
        for (int i = data.content.size(); i < getSideMaximumElementsNumber(); i++) {
            setEntryListVisibilty(i % maximumElementNumber, false, false);
        }
    }

    public void setEntryIncorrect(int index, int timePeriod) {

        var i = index % getMaximumElementNumber();
        if (data.dataType.get(index) == CardContentDataSet.DataType.STRING) {
            var previousBG = entriesList.get(i).getBackground();
            entriesList.get(i).setBackground(new Color(0x570606));
            entriesList.get(i).getTextComponent().setEnabled(false);
            var timer = new Timer(timePeriod, e -> {
                entriesList.get(i).setBackground(previousBG);
                entriesList.get(i).getTextComponent().setEnabled(true);
            });
            timer.setRepeats(false);
            timer.start();
        }
    }
}
