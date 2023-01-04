package game.board;

import java.util.List;

public class Place {
    private GameObject gameObject;
    
    public final int x;
    public final int y;
    
    public Place(int x, int y) {
        gameObject = null;
        this.x = x;
        this.y = y;
    }
    
    public boolean isEmpty() {
        return gameObject == null;
    }
    
    public GameObject getGameObject() {
        return gameObject;
    }
    
    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }
}
