package gui.card;

import gui.customUI.customUIStyles.borderStrategies.AverageBorderStartegy;
import gui.customUI.customUIStyles.borderStrategies.DefaultBorderStrategy;
import gui.factories.GuiFactory;
import gui.factories.customFactories.buttonFactories.ArrowButtonFactory;
import gui.factories.customFactories.buttonFactories.CardDownPanelButtonFactory;
import gui.factories.customFactories.buttonFactories.WinterClickedButtonFactory;
import gui.factories.customFactories.labelFactories.GameGreenLabelFactory;
import gui.factories.customFactories.labelFactories.TitleCardLabelFactory;
import gui.factories.customFactories.labelFactories.WinterDarkerBackgroundLabelFactory;
import gui.factories.customFactories.textComponentFactory.TextFieldFactory;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;

public class WarHammerFactory extends IOverallFactory {

    @Override
    public Card createCard(AbstractMap.SimpleEntry<String, String> titleIconPathName, ArrayList<AbstractMap.SimpleEntry<String, String>> dataMap
        ) {
        factory.setTextFactory(new TextFieldFactory());
        factory.setButtonFactory(new WinterClickedButtonFactory());
        factory.setBorderStrategy(new AverageBorderStartegy());
//        factory.setCurrentSize(size);
        var card = new Card(titleIconPathName, dataMap, factory);
        card.initializeTitle();
//        factory.setLabelFactory(new GameGreenLabelFactory());
        card.initializeContent();
//        card.initializeDownPanel();
        card.setUniformFont();
//        card.getPanel().setBorder(BorderFactory.createLineBorder(new Color(0x570303),
//                (int) (GuiFactory.getSizeIndex(size) * 12), true));

        try {
            card.setBackgroundImage("src/gui/aaa.png");
        } catch (IOException e) {
            card.setBackgroundColor(new Color(0x935D3A));
        }
        return card;
    }
}
