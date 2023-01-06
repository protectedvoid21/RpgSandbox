package game.board;

import java.util.List;

public class RoundManager {
    private final Board board;
    private List<GameObject> activeGameObjects;
    
    private int currentTurn = 1;
    private int currentIndex;
    
    public RoundManager(Board board) {
        this.board = board;
    }
    
    public GameObject getGameObjectWithTurn() {
        GameObject currentObject = activeGameObjects.get(currentIndex);
        currentObject.applyNewRound();
        
        while(!currentObject.creature.getStatistics().isAbleToPlay()) {
            moveToNextObject();
            currentObject = activeGameObjects.get(currentIndex);
        }
        return currentObject;
    }
    
    private void moveToNextObject() {
        currentIndex++;
        
        if(currentIndex >= activeGameObjects.size()) {
            currentIndex = 0;
            startNewTurn();
        }
    }
    
    public void startNewTurn() {
        currentTurn++;
        activeGameObjects = board.getAllGameObjects();
    }
    
    public int getCurrentTurn() {
        return currentTurn;
    }
}
