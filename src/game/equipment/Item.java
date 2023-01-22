package game.equipment;

import game.interfaces.IStatistics;
import game.interfaces.Statistics;

public abstract class Item {
    private String name = "Unnamed";
    private String itemPathPicture ="";
    
    public abstract boolean isValid();
    
    public Item(String name) {
        this.name = name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public String getItemPathPicture() {
        return itemPathPicture;
    }

    public void setItemPathPicture(String itemPathPicture) {
        this.itemPathPicture = itemPathPicture;
    }
}
