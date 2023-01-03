package game.board;

public class Place {
    private Transform transform;
    
    public final int x;
    public final int y;
    
    public Place(int x, int y) {
        transform = null;
        this.x = x;
        this.y = y;
    }
    
    public Place(int x, int y, Transform transform) {
        this(x, y);
        this.transform = transform;
    }
    
    public boolean isEmpty() {
        return transform == null;
    }
    
    public Transform getTransform() {
        return transform;
    }
    
    public void setTransform(Transform transform) {
        this.transform = transform;
    }
}
