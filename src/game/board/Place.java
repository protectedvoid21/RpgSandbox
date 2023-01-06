package game.board;

public class Place {
    private GameObject gameObject;
    
    public Place() {
        gameObject = null;
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
