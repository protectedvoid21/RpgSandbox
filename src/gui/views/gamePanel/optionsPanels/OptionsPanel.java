package gui.views.gamePanel.optionsPanels;

import game.generals.Vector2;
import gui.customComponents.AbstractCustomButton;
import gui.customUI.customUIStyles.borderStrategies.AverageBorderStartegy;
import gui.factories.GuiFactory;
import gui.factories.customFactories.buttonFactories.BasicButton;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;
import gui.views.BackgroundView;
import gui.views.PanelContainer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class OptionsPanel extends BackgroundView implements PanelContainer {
    protected GuiFactory factory;
    private ComponentPanelMenager cmp;
    protected DefaultCustomMenuMenager customPanelAttackChoser;
    protected ArrayList<AbstractCustomButton> buttons = new ArrayList<>();
    protected int size = 0;
    protected int maximumSize  =10;
    private Vector2 currentPoint = new Vector2(-1, -1);

    public OptionsPanel(GuiFactory factory) {
        this.factory = factory;
    }

//    public void setBorderColor(Color color) {
//        customPanelAttackChoser.getCmp().setBorderData(color, new AverageBorderStartegy(), 15);
//    }

    public void addOptionsPanelCommand(int index, ActionListener listener) {
        if (index < size) {
            buttons.get(index).addActionListener(listener);
        }
    }

    public void setCurrentIndexes(int x, int y) {
        currentPoint = new Vector2(x, y);
    }

    public Vector2 getCurrentPoint() {
        return currentPoint;
    }

    public void initialize(int weight) {
        this.customPanelAttackChoser =
                new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.HORIZONTAL,
                        ComponentsSeries.ComponentsDimension.VERTICAL, weight);
        initializeCustomPanel();
        cmp = new ComponentPanelMenager(customPanelAttackChoser.getCmp(), weight);
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
        for (int i = 0; i < maximumSize; i++) {
            customPanelAttackChoser.addMainComponent(10, 50);//cos sie pieprzy
            customPanelAttackChoser.getMainComponent(i).addSpace(1);

        }
        customPanelAttackChoser.setHasUniqueColor(true);
        customPanelAttackChoser.setBackground(Color.BLUE);
    }

    public void setPotentialSize(int potentialSize){
        size = size>potentialSize?size>maximumSize?10:size:potentialSize;
    }

    public void initializeButtonsData(ArrayList<String> dataMap) {
//        factory.setButtonFactory(new BasicButton());
        factory.setButtonType(GuiFactory.ButtonType.ICON);
        int i = 0;
        size = size>dataMap.size()?size>maximumSize?10:size:dataMap.size();
        for (var data : dataMap) {
//            if (i < size) {
            var button = factory.createButton(data, null);
            buttons.add(button);
            button.setHasDisabledColor(true);
            button.setSecondDisabledColor(Color.BLACK);
            customPanelAttackChoser.addMiddleComponent(button, i, 10);
//            }
            i++;
        }
        setCorrectVisibility();
//        int space = (int)((100-size*10)/(double)2);
//        System.out.println(space);
//        customPanelAttackChoser.getCmp().addSpace(space, ComponentPanelMenager.Side.LEFT, ComponentPanelMenager.Side.RIGHT);
    }

    protected void setCorrectVisibility(){
        for (int j = 0; j<maximumSize; j++){
            customPanelAttackChoser.getMainComponent(j).setVisible(j<size?true:false);
        }
    }
    public void applyUnivibilityAfterClicked() {
        for (var button : buttons) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cmp.setVisible(false);
                    setCurrentIndexes(-1, -1);
                }
            });
        }
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

    public void setUniqueColor(boolean value) {
        customPanelAttackChoser.setHasUniqueColor(value);
    }

    @Override
    protected DefaultCustomMenuMenager getMenager() {
        return customPanelAttackChoser;
    }
}
