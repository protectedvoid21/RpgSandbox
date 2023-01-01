package gui.card;

import gui.customComponents.CustomButton;
import gui.customComponents.CustomLabel;
import gui.customComponents.ITextCustomUICmp;
import gui.customUI.customUIStyles.borderStrategies.AverageBorderStartegy;
import gui.customUI.interfaces.ICustomUI;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;

public class Card {
    final private String EMPTY_DATA_CONTENT = "";
    private DefaultCustomMenuMenager<CustomLabel> menager =
            new DefaultCustomMenuMenager<>(ComponentsSeries.ComponentsDimension.HORIZONTAL,
                    ComponentsSeries.ComponentsDimension.VERTICAL);

    private DoubleArrowPanel leftArrows;
    private DoubleArrowPanel rightArrows;

    private ComponentPanelMenager seriesPanel;
    private GuiFactory factory;
    private int currentAttrSide = 0;
    private AbstractMap.SimpleEntry<String, String> titleIconPathName;
    private ArrayList<AbstractMap.SimpleEntry<String, String>> dataMap;
    private int maximumElementNumber = 5;

    public Card(AbstractMap.SimpleEntry<String, String> titleIconPathName, ArrayList<AbstractMap.SimpleEntry<String,
            String>> dataMap, GuiFactory factory) {
        this.factory = factory;
        this.titleIconPathName = titleIconPathName;
        this.dataMap = dataMap;

        var panel = new ComponentsSeries<>(ComponentsSeries.ComponentsDimension.VERTICAL);
        panel.addOption(menager.getCmp(), 9);
        panel.addOption(createArrowComponentSeries(), 2);
        seriesPanel = new ComponentPanelMenager(panel);

        menager.addMainComponent(10);
        menager.addMainComponent(10);
        seriesPanel.setBorderData(Color.RED, new AverageBorderStartegy(), 8);
    }

    private ComponentsSeries createArrowComponentSeries() {
        var arrowsManager = new ComponentsSeries<>(ComponentsSeries.ComponentsDimension.HORIZONTAL);
        leftArrows = new DoubleArrowPanel(factory);
        leftArrows.setSpace(5);
        rightArrows = new DoubleArrowPanel(factory);
        rightArrows.setSpace(5);
        leftArrows.setListener(DoubleArrowPanel.Side.RIGHT, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchSide(DoubleArrowPanel.Side.RIGHT);
            }
        });
        leftArrows.setListener(DoubleArrowPanel.Side.LEFT, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchSide(DoubleArrowPanel.Side.LEFT);
            }
        });
        arrowsManager.addOption(leftArrows.getPanel(), 5);
        arrowsManager.addOption(rightArrows.getPanel(), 5);
        return arrowsManager;
    }

    private boolean isSwitchForwardSidePossible() {
        return dataMap.size() > maximumElementNumber * currentAttrSide;
    }

    private boolean isSwitchBackSidePossible() {
        return currentAttrSide > 0;
    }

    public void initializeTitle() {
        factory.setLabelType(GuiFactory.LabelType.ICON);
        menager.addMiddleComponent(factory.createLabel(titleIconPathName.getKey()), 0, 30);
        menager.getMiddleComponent(0, 0).addSpace(6, ComponentPanelMenager.Side.LEFT, ComponentPanelMenager.Side.TOP);

        factory.setLabelType(GuiFactory.LabelType.NORMAL);
        menager.getMiddleComponent(0, 0).addSpace(1, ComponentPanelMenager.Side.RIGHT);
        menager.getMiddleComponent(0, 0).addSpace(2, ComponentPanelMenager.Side.BOTTOM);

        menager.addMiddleComponent(factory.createLabel(titleIconPathName.getValue()), 1, 30);
        menager.getMiddleComponent(1, 0).addSpace(6, ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.TOP,
                ComponentPanelMenager.Side.BOTTOM);
        menager.getMiddleComponent(1, 0).addSpace(1, ComponentPanelMenager.Side.LEFT);

    }

    public void switchSide(DoubleArrowPanel.Side side) {
        if (isSwitchingSidePossible(side)) {
            switch (side) {
                case LEFT -> currentAttrSide--;
                case RIGHT -> currentAttrSide++;
            }
            updateContent();
            setCorrectBlockStatus();
        }
    }

    private void setCorrectBlockSideStatus(DoubleArrowPanel.Side side){
        if (!isSwitchingSidePossible(side)) {
            blockButton(side);
        } else {
            unblockButton(side);
        }
    }

    private void setCorrectBlockStatus(){
        setCorrectBlockSideStatus(DoubleArrowPanel.Side.LEFT);
        setCorrectBlockSideStatus(DoubleArrowPanel.Side.RIGHT);
    }

    private void blockButton(DoubleArrowPanel.Side side) {
        leftArrows.turnOffButton(side);
    }

    private void unblockButton(DoubleArrowPanel.Side side) {
        leftArrows.turnOnButton(side);
    }

    private boolean isSwitchingSidePossible(DoubleArrowPanel.Side side) {
        boolean status = false;
        switch (side) {
            case LEFT -> status = currentAttrSide > 0;
            case RIGHT -> status = getSideMaximumElementsNumber() < dataMap.size();
        }
        return status;
    }

    private int getSideMaximumElementsNumber() {
        return maximumElementNumber * (currentAttrSide + 1);
    }


    private void updateContent() {
        int maxSideIndex = getSideMaximumElementsNumber();
        int dataSize = dataMap.size();

        var sublist = dataMap.subList(currentAttrSide * maximumElementNumber, maxSideIndex > dataSize ? dataSize :
                maxSideIndex);
        while (sublist.size() < maximumElementNumber) {
            sublist.add(new AbstractMap.SimpleEntry<>(EMPTY_DATA_CONTENT, EMPTY_DATA_CONTENT));
        }
        int currentIndex = 1;
        setContentVisible(false);
        for (var key : sublist) {
            menager.getMiddleComponent(0, currentIndex).getComponent().setText(key.getKey());
            menager.getMiddleComponent(1, currentIndex).getComponent().setText(key.getValue());
            currentIndex++;
        }
         new java.util.Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                setContentVisible(true);
            }
        }, 200);

//        int freeCmpsNumber = maxSideIndex - dataSize;
//        for (int i = maximumElementNumber - freeCmpsNumber; i < maximumElementNumber; i++) {
//            menager.getMiddleComponent(0, i + 1).getComponent().setVisible(false);
//            menager.getMiddleComponent(1, i + 1).getComponent().setVisible(false);
//        }
    }

    public void initializeContent() {
        int maxSideIndex = (currentAttrSide + 1) * (maximumElementNumber);
        int dataSize = dataMap.size();
        var sublist = dataMap.subList(currentAttrSide * maximumElementNumber, maxSideIndex > dataSize ? dataSize :
                maxSideIndex);

        for (var key : sublist) {
            menager.addMiddleComponent(factory.createLabel(key.getKey()), 0, 10);
            menager.getMainComponent(0).getComponent().getLastComponent().addSpace(2, ComponentPanelMenager.Side.LEFT
                    , ComponentPanelMenager.Side.BOTTOM, ComponentPanelMenager.Side.TOP);

            menager.addMiddleComponent(factory.createLabel(key.getValue()), 1, 10);
            menager.getMainComponent(1).getComponent().getLastComponent().addSpace(2,
                    ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.BOTTOM,
                    ComponentPanelMenager.Side.TOP);
        }
        setCorrectBlockStatus();
    }


    public void setBackgroundImage(String path) throws IOException {
        seriesPanel.setBackgroundImage(path);
    }

    public void setBackgroundColor(Color color) {
        seriesPanel.setBackground(color);
    }

    public JPanel getPanel() {
        return seriesPanel;
    }

    public void setUniformFont() {
        ArrayList<ITextCustomUICmp> cmpsUIs = new ArrayList<>();
        var mngrLst = menager.getComponentsList();
        var firstNo = menager.getMiddleComponent(0, 0).getComponent();
        var secondNo = menager.getMiddleComponent(1, 0).getComponent();

        for (var cmp : mngrLst) {
            if (cmp != firstNo && cmp != secondNo) {
                cmpsUIs.add(cmp);
            }
        }
        var sharecmpfont = new SharedCmpsFont(cmpsUIs);
        for (var cmpUI : cmpsUIs) {
            cmpUI.getCustomUI().setSharedComponentSize(sharecmpfont);
        }
    }

    public void setContentVisible(boolean status) {
        var firstNo = menager.getMiddleComponent(0, 0).getComponent();
        var secondNo = menager.getMiddleComponent(1, 0).getComponent();
        for (var cmp : menager.getComponentsList()) {
            if (cmp != firstNo && cmp != secondNo) {
                if (status){
                    cmp.getCustomUI().setRelevantFont(cmp.getText());//meh slabe
                }
                cmp.setVisible(cmp.getText() == "" ? false : status);//jesli border panela to pewnie problem ale niech bedzie
            }
        }
    }

}
