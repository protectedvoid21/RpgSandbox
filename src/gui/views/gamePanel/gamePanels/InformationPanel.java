package gui.views.gamePanel.gamePanels;

import gui.customComponents.AbstractCustomButton;
import gui.customComponents.AbstractCustomLabel;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;
import gui.views.BackgroundView;
import gui.views.PanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;

public class InformationPanel extends BackgroundView implements PanelContainer {
    private ComponentPanelMenager mainCmp;

    private DefaultCustomMenuMenager<JComponent> managerActions =
            new DefaultCustomMenuMenager<JComponent>(ComponentsSeries.ComponentsDimension.VERTICAL,
                    ComponentsSeries.ComponentsDimension.VERTICAL);

    private AbstractCustomButton button;
    private ArrayList<AbstractCustomLabel> informationLabels;
    private AbstractCustomLabel titleLabel;

    @Override
    public ComponentPanelMenager getPanel() {
        return mainCmp;
    }



    public InformationPanel(GuiFactory factory){
        factory.setButtonType(GuiFactory.ButtonType.NORMAL);
        factory.setLabelType(GuiFactory.LabelType.NORMAL);
        managerActions.getCmp().setHasUniqueColor(true);
        managerActions.getCmp().setBackground(new Color(0x329D44));
        mainCmp = new ComponentPanelMenager(managerActions.getCmp());
        mainCmp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        button = factory.createButton("OK", e->mainCmp.setVisible(false));
        button.getCustomUI().setOffSet(12);
        titleLabel = factory.createLabel("RESULT");
        titleLabel.getCustomUI().setOffSet(8);
        informationLabels = new ArrayList<>();
        for (int i = 0; i<6; i++){
            var label = factory.createLabel("");
            label.getCustomUI().setOffSet(8);
            informationLabels.add(label);
        }

        managerActions.addMainComponent(8);
        managerActions.addMainComponent(20);
        managerActions.addMainComponent(6);
        managerActions.addMiddleComponent(titleLabel, 0, 10);
        for (int i = 0; i<6; i++){
            managerActions.addMiddleComponent(informationLabels.get(i), 1, 10);

            managerActions.getMiddleComponent(1, i).addSpace(1);
        }
        managerActions.addMiddleComponent(button, 2, 10);
        managerActions.getMiddleComponent(0, 0).addSpace(3);
//        managerActions.getMiddleComponent(1, 0).addSpace(2);
        managerActions.getMiddleComponent(2, 0).addSpace(10, ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.LEFT);
        managerActions.getMiddleComponent(2, 0).addSpace(2, ComponentPanelMenager.Side.TOP, ComponentPanelMenager.Side.BOTTOM);
    }

    public void setNewLabelContent(ArrayList<String> content){
        for (int i = 0; i<6; i++){
            managerActions.getMiddleComponent(1, i).setVisible(false);
        }
        int index = 0;
        for (var pair : content){
            informationLabels.get(index).setContent(pair);
            managerActions.getMiddleComponent(1, index).setVisible(true);
        }
        mainCmp.setVisible(true);
    }


    @Override
    protected DefaultCustomMenuMenager getMenager() {
        return managerActions;
    }
}
