package game.board;

public class GameObject {
    protected Board board;
    protected String name;
    
    protected GameObject(Board board) {
        this.board = board;
    }
    
    public GameObject(Board board, String name) {
        this(board);
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
