package gui.card;

import java.util.ArrayList;
import java.util.Arrays;

public class CardContentDataSet {
    public enum DataType {BOOLEAN, STRING}

    public String titlePath = "";
    public String titleContent= "";
    public ArrayList<ArrayList<String>> content = new ArrayList<>();

    public ArrayList<DataType> dataType = new ArrayList<>();

    public CardContentDataSet(String titlePath, String titleContent) {
        this.titlePath = titlePath;
        this.titleContent = titleContent;
    }

    public CardContentDataSet() {
    }

    public void setFullStringDataContent(){
        for (int i = 0; i < content.size(); i++) {
            dataType.add(CardContentDataSet.DataType.STRING);
        }
    }

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

    public CardContentDataSet clone(){
        var cnt = new CardContentDataSet();
        for (var array : this.content){
            cnt.content.add((ArrayList<String>) array.clone());
        }
        cnt.titleContent = this.titleContent;
        cnt.titlePath = this.titlePath;
        return cnt;
    }
}
