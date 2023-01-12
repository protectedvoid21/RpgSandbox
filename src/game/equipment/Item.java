package game.equipment;

import game.interfaces.IStatistics;
import game.interfaces.Statistics;

public abstract class Item {
    //public Item() {}
    private String itemPathPicture ="";
    public abstract boolean isValid();

    public String getItemPathPicture() {
        return itemPathPicture;
    }

    public void setItemPathPicture(String itemPathPicture) {
        this.itemPathPicture = itemPathPicture;
    }
}
