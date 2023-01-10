package gui.views.gamePanel;

import gui.card.SharedCmpsFont;
import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.AbstractCustomButton;
import gui.customComponents.AbstractCustomLabel;
import gui.customUI.customUIStyles.borderStrategies.AverageBorderStartegy;
import gui.factories.GuiFactory;
import gui.factories.customFactories.buttonFactories.BasicButton;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class OptionsPanel {
    private GuiFactory factory;
    private ComponentPanelMenager cmp;
    private DefaultCustomMenuMenager customPanelAttackChoser;
    private ArrayList<AbstractCustomButton> buttons = new ArrayList<>();
    private ArrayList<AbstractCustomLabel> labels = new ArrayList<>();
    private int size = 0;
    private int currentX = -1;
    private int currentY = -1;

    public OptionsPanel(GuiFactory factory) {
        this.factory = factory;
//        this.customPanelAttackChoser =
//                new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.HORIZONTAL,
//                        ComponentsSeries.ComponentsDimension.VERTICAL, weight);
//        cmp = new ComponentPanelMenager(customPanelAttackChoser.getCmp(), weight);
//        customPanelAttackChoser.getCmp().setBorderData(Color.RED, new AverageBorderStartegy(), 8);
//        customPanelAttackChoser.getCmp().addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//            }
//        });
//        setVisible(false);
    }

    public void setBorderColor(Color color) {
        customPanelAttackChoser.getCmp().setBorderData(color, new AverageBorderStartegy(), 8);
    }

    public void addOptionsPanelCommand(int index, ActionListener listener) {
        if (index < size) {
            buttons.get(index).addActionListener(listener);
        }
    }

    public void setCurrentIndexes(int x, int y) {
        currentX = x;
        currentY = y;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void initialize(int weight) {
        this.customPanelAttackChoser =
                new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.HORIZONTAL,
                        ComponentsSeries.ComponentsDimension.VERTICAL, weight);
        cmp = new ComponentPanelMenager(customPanelAttackChoser.getCmp(), weight);
//        customPanelAttackChoser.getCmp().setBorderData(Color.RED, new AverageBorderStartegy(), 8);
        customPanelAttackChoser.getCmp().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        setVisible(false);
    }

    public void setNonVisibleButtons(Integer... indexes) {
        setNonVisibleButtons(new ArrayList<>(Arrays.asList(indexes)));
    }


    public void setNonVisibleButtons(ArrayList<Integer> indexesList) {
        for (int i =0; i<size; i++){
            customPanelAttackChoser.getMainComponent(i).setVisible(!indexesList.contains(i));
        }
    }

    public double getPercentFilledSize(){
        int ilosc = 0;
        for (int i = 0; i<size; i++){
            if (customPanelAttackChoser.getMainComponent(i).isVisible()){
                ilosc++;
            }
        }
        return ilosc/(double)size;
    }

    public void initializeData(ArrayList<AbstractMap.SimpleEntry<String, String>> dataMap) {
        size = dataMap.size();
        factory.setButtonFactory(new BasicButton());
        factory.setButtonType(GuiFactory.ButtonType.ICON);
        factory.setLabelType(GuiFactory.LabelType.NORMAL);
        int i = 0;
        for (var data : dataMap) {
            customPanelAttackChoser.addMainComponent(10, 20);//cos sie pieprzy
            var button = factory.createButton(data.getKey(), null);
            buttons.add(button);
            button.setHasDisabledColor(true);
            button.setSecondDisabledColor(Color.BLACK);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cmp.setVisible(false);
                    setCurrentIndexes(-1, -1);
                }
            });
//            button.setEnabled(false);
            var label = factory.createLabel(data.getValue());
            labels.add(label);
            customPanelAttackChoser.addMiddleComponent(button, i, 10);
            customPanelAttackChoser.addMiddleComponent(label, i, 10);
            customPanelAttackChoser.getMainComponent(i).addSpace(1);
            i++;
        }
        customPanelAttackChoser.setHasUniqueColor(true);
        customPanelAttackChoser.setBackground(Color.BLUE);
        SharedCmpsFont.setUniformFont(labels);
//        customPanelAttackChoser.getCmp().setOpaque(true);
    }

    public void setDisabledIndexes(ArrayList<Integer> indexes) {
        for (int i = 0; i < size; i++) {
            buttons.get(i).setEnabled(true);
        }
        for (var index : indexes) {
            if (index < size) {
                buttons.get(index).setEnabled(false);
            }
        }

    }

    public void setDisabledIndexes(Integer... indexes) {
        setDisabledIndexes(new ArrayList<>(Arrays.asList(indexes)));

    }

    public ComponentPanelMenager getPanel() {
        return cmp;
    }

    public void setVisible(boolean visibleStatus) {
        cmp.setVisible(visibleStatus);
        if (!visibleStatus) {
            setCurrentIndexes(-1, -1);
        }
    }
}
