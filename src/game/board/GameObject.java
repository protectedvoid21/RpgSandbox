package game.board;

public class GameObject {
    protected String name;
    
    protected GameObject() {
        
    }
    
    public GameObject(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
