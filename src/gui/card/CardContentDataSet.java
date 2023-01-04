package gui.card;

import java.util.ArrayList;
import java.util.Arrays;

public class CardContentDataSet {
    public String titlePath;
    public String titleContent;
    public ArrayList<ArrayList<String>> content;

    public ArrayList<CardContentDataSet> eqData = new ArrayList<>(Arrays.asList(this));
}
