package gui.views.gamePanel;

import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.AbstractCustomButton;
import gui.customComponents.AbstractCustomLabel;
import gui.factories.GuiFactory;
import gui.factories.customFactories.buttonFactories.BasicButton;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;
import java.awt.*;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class OptionsPanel {
    private GuiFactory factory;
    private ComponentPanelMenager cmp;
    private DefaultCustomMenuMenager customPanelAttackChoser;
    private ArrayList<AbstractCustomButton> buttons;
    private ArrayList<AbstractCustomLabel> labels;

    public OptionsPanel(GuiFactory factory, int weight) {
        this.factory = factory;
        this.customPanelAttackChoser =
                new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.HORIZONTAL,
                        ComponentsSeries.ComponentsDimension.VERTICAL, weight);
        cmp = new ComponentPanelMenager(customPanelAttackChoser.getCmp(), weight);

    }

    public void initialize(ArrayList<String> dataMap) {
        factory.setButtonFactory(new BasicButton());
        factory.setButtonType(GuiFactory.ButtonType.ICON);
        factory.setLabelType(GuiFactory.LabelType.NORMAL);
        int i = 0;
        for (var string : dataMap) {
            customPanelAttackChoser.addMainComponent(10);
            var button = factory.createButton(string, null);
            button.setHasDisabledColor(true);
            button.setSecondDisabledColor(Color.BLACK);
            var label = factory.createLabel(Card.EMPTY_DATA_CONTENT);
            customPanelAttackChoser.addMiddleComponent(button, i, 10);
            customPanelAttackChoser.addMiddleComponent(label, i, 10);

            customPanelAttackChoser.getMainComponent(i).addSpace(1);
            i++;
        }
        customPanelAttackChoser.setHasUniqueColor(true);
        customPanelAttackChoser.setBackground(Color.BLUE);
    }

    public ComponentPanelMenager getPanel() {
        return cmp;
    }
}
