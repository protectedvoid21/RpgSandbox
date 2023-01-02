package gui.card;

import gui.factories.GuiFactory;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class IOverallFactory {
    protected GuiFactory factory = new GuiFactory();

    public abstract Card createCard(AbstractMap.SimpleEntry<String, String> titleIconPathName,
                                    ArrayList<ArrayList<String>> dataMap);
}
