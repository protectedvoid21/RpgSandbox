package gui.views.gamePanel.optionsPanels;

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
import gui.views.gamePanel.Point;

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

public abstract class OptionsPanel {
    protected GuiFactory factory;
    private ComponentPanelMenager cmp;
    protected DefaultCustomMenuMenager customPanelAttackChoser;
    private ArrayList<AbstractCustomButton> buttons = new ArrayList<>();
//    private ArrayList<AbstractCustomLabel> labels = new ArrayList<>();
    protected int size = 0;
    private gui.views.gamePanel.Point currentPoint = new gui.views.gamePanel.Point(-1, -1);

    public OptionsPanel(GuiFactory factory, int size) {
        this.size = size;
        this.factory = factory;
    }

    public void setBorderColor(Color color) {
        customPanelAttackChoser.getCmp().setBorderData(color, new AverageBorderStartegy(), 15);
    }

    public void addOptionsPanelCommand(int index, ActionListener listener) {
        if (index < size) {
            buttons.get(index).addActionListener(listener);
        }
    }

    public void setCurrentIndexes(int x, int y) {
        currentPoint = new gui.views.gamePanel.Point(x, y);
    }

    public Point getCurrentPoint() {
        return currentPoint;
    }

    public void initialize(int weight) {
        this.customPanelAttackChoser =
                new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.HORIZONTAL,
                        ComponentsSeries.ComponentsDimension.VERTICAL, weight);
        initializeCustomPanel();
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
        for (int i = 0; i < size; i++) {
            customPanelAttackChoser.getMainComponent(i).setVisible(!indexesList.contains(i));
        }
    }

    public double getPercentFilledSizeX() {
        int ilosc = 0;
        for (int i = 0; i < size; i++) {
            if (customPanelAttackChoser.getMainComponent(i).isVisible()) {
                ilosc++;
            }
        }
        return ilosc / (double) 5;
    }

    public abstract double getPercentFilledSizeY();

    private void initializeCustomPanel() {
//        size = dataMap.size();
//        factory.setButtonFactory(new BasicButton());
//        factory.setButtonType(GuiFactory.ButtonType.ICON);
//        factory.setLabelType(GuiFactory.LabelType.NORMAL);
        for (int i = 0; i < size; i++) {
            customPanelAttackChoser.addMainComponent(10, 50);//cos sie pieprzy
            customPanelAttackChoser.getMainComponent(i).addSpace(1);

        }
        customPanelAttackChoser.setHasUniqueColor(true);
        customPanelAttackChoser.setBackground(Color.BLUE);
//        for (var data : dataMap) {
//            customPanelAttackChoser.addMainComponent(10, 50);//cos sie pieprzy
//            var button = factory.createButton(data.getKey(), null);
//            buttons.add(button);
//            button.setHasDisabledColor(true);
//            button.setSecondDisabledColor(Color.BLACK);
//            button.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    cmp.setVisible(false);
//                    setCurrentIndexes(-1, -1);
//                }
//            });
////            button.setEnabled(false);
//            var label = factory.createLabel(data.getValue());
//            labels.add(label);
//            customPanelAttackChoser.addMiddleComponent(button, i, 10);
//            customPanelAttackChoser.addMiddleComponent(label, i, 10);
//            customPanelAttackChoser.getMainComponent(i).addSpace(1);
//            i++;
//        }
//        customPanelAttackChoser.setHasUniqueColor(true);
//        customPanelAttackChoser.setBackground(Color.BLUE);
//        SharedCmpsFont.setUniformFont(labels);
//        customPanelAttackChoser.getCmp().setOpaque(true);
    }

//    public void initializeLabelsData(ArrayList<String> dataMap) {
////        var newSize = dataMap.size();
//        factory.setLabelType(GuiFactory.LabelType.NORMAL);
//        int i = 0;
//        for (var data : dataMap) {
//            if (i < size) {
//                var label = factory.createLabel(data);
//                labels.add(label);
//                customPanelAttackChoser.addMiddleComponent(label, i, 10);
//            }
//            i++;
//        }
//        SharedCmpsFont.setUniformFont(labels);
//    }

    public void initializeButtonsData(ArrayList<String> dataMap) {
        factory.setButtonFactory(new BasicButton());
        factory.setButtonType(GuiFactory.ButtonType.ICON);
        int i = 0;
        for (var data : dataMap) {
            if (i < size) {
                var button = factory.createButton(data, null);
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
                customPanelAttackChoser.addMiddleComponent(button, i, 10);
            }
            i++;
        }
    }

    public void setDisabledIndexes(ArrayList<Integer> indexes) {
        System.out.println(size);
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
