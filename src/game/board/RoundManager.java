package game.board;

import java.util.Collections;
import java.util.Comparator;

import game.generals.Vector2;
import game.interfaceWarhammer.ActionsWarhammer;
import game.interfaces.Actions;
import java.util.List;

public class RoundManager {
    private final Board board;
    private List<GameObject> activeGameObjects;

    private Actions actions;
    
    private int currentTurn = 1;
    private int currentIndex;
    
    public RoundManager(Board board) {
        this.board = board;
        this.actions = initializeActions();

    }
    
    public GameObject getGameObjectWithTurn() {
        return activeGameObjects.get(currentIndex);
    }

    public Vector2 getGameObjectWithTurnPosition(){
        Vector2 vector2 = null;

        for(int i = 0; i<getBoard().getHeigt();i++){
            for(int j = 0; j<getBoard().getWidth();i++){
                if(getBoard().getPlace(new Vector2(j,i)).getGameObject().getCreature().equals(getGameObjectWithTurnPosition())){
                    vector2 = new Vector2(j,i);
                }
            }
        }

        return vector2;

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

    private Actions initializeActions(){
        Actions actions = new ActionsWarhammer();
        return actions;
    }

    public void startNewTurn() {
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

    public Actions getActions(){
        return actions;
    }

    public Board getBoard() {
        return board;
    }
}
