package gui.card;

import java.util.ArrayList;
import java.util.Arrays;

public class CardContentDataSet {
    public enum DataType {BOOLEAN, STRING, INTEGER}

    public String titlePath;
    public String titleContent;
    public ArrayList<ArrayList<String>> content;

//    public ArrayList<CardContentDataSet> eqData = new ArrayList<>(Arrays.asList(this));

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
//        for (var list : content) {
//            var helpCondition = false;
//            for (var secondList : secondData.content) {
//                if (list.size() == secondList.size()) {
//                    for (int i = 0; i < list.size(); i++) {
//                        if (!list.get(i).equals(secondList.get(i))) {
//                            break;
//                        }
//                    }
//
//                }
//
//            }
//        }
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
