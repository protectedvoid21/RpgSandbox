package game.board;

import java.util.Collections;
import java.util.Comparator;
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
        return activeGameObjects.get(currentIndex);
    }
    
    public void moveToNextObject() {
        while(!getGameObjectWithTurn().creature.getStatistics().isAbleToPlay()) {
            currentIndex++;
        }
        getGameObjectWithTurn().applyNewRound();
        
        if(currentIndex >= activeGameObjects.size()) {
            currentIndex = 0;
            startNewTurn();
        }
    }
    
    private void startNewTurn() {
        currentTurn++;
        activeGameObjects = board.getAllGameObjects();
        sortByMovePriority(activeGameObjects);
    }
    
    private void sortByMovePriority(List<GameObject> gameObjects) {
        gameObjects.sort(Comparator.comparingInt(g -> g.creature.getStatistics().getMovePriority()));
        Collections.reverse(gameObjects);
    }
    
    public int getCurrentTurn() {
        return currentTurn;
    }
}
