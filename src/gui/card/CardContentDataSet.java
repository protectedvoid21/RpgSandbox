package gui.card;

import java.util.ArrayList;
import java.util.Arrays;

public class CardContentDataSet {
    public enum DataType {BOOLEAN, STRING, INTEGER}

    public String titlePath = "";
    public String titleContent= "";
    public ArrayList<ArrayList<String>> content = new ArrayList<>();

    public ArrayList<DataType> dataType = new ArrayList<>();

    public boolean equals(CardContentDataSet secondData) {

        if (!(titlePath.equals(secondData.titlePath))) {
            return false;
        }
        if (!(titleContent.equals(secondData.titleContent))) {
            return false;
        }
        if (!content.equals(secondData.content)){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return content+"  "+titlePath+"  "+titleContent;
    }

    private boolean isContained(ArrayList<String> array1, ArrayList<ArrayList<String>> array2) {
        for (var list : array2) {
            if (list.size() == array1.size()) {
                for (int i = 0; i <list.size(); i++){

                }
            }
        }
        return false;
    }

}
