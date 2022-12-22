package game.equipment;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private ArrayList<Item> itemList;
    
    public Inventory() {
        itemList = new ArrayList<>();
    }
    
    public ArrayList<Item> getItems() {
        return itemList;
    }
    
    public void addItem(Item item) {
        itemList.add(item);
    }

    public void removeItem(Item item) {
        itemList.remove(item);
    }
    public void removeItemIfNotValid(Item item){
        if (!item.isValid()){
            removeItem(item);
        }
    }
    public void removeEachItemIfNotValid(){//this method will be
        for (var item: itemList){
            removeItemIfNotValid(item);
        }
    }
}
