package game.board;

import java.util.*;

import game.creature.Creature;
import game.generals.Vector2;
import game.interfaceWarhammer.ActionsWarhammer;
import game.interfaces.Actions;

public class RoundManager {
    private final Board board;
    private List<GameObject> activeGameObjects;

    private Actions actions;

    private int currentTurn = 0;
    private int currentIndex;

    public RoundManager(Board board) {
        this.board = board;
        this.actions = initializeActions();
        currentTurn++;
        starGame();
    }

    public GameObject getGameObjectWithTurn() {
        return activeGameObjects.get(currentIndex);
    }

    public Vector2 getGameObjectWithTurnPosition() {
        for (int i = 0; i < getBoard().getHeight(); i++) {
            for (int j = 0; j < getBoard().getWidth(); j++) {
                if (getBoard().getPlace(new Vector2(j, i)).getGameObject() == getGameObjectWithTurn()) {
                    return new Vector2(j, i);
                }
            }
        }

        return null;
    }

    public Vector2 getGameObjectPosition(GameObject gameObject) {
        for (int i = 0; i < getBoard().getHeight(); i++) {
            for (int j = 0; j < getBoard().getWidth(); j++) {
                if (getBoard().getPlace(new Vector2(j, i)).getGameObject() == gameObject) {
                    return new Vector2(j, i);
                }
            }
        }

        return null;
    }

    public void moveToNextObject() {
        do  {
            currentIndex++;
            if (currentIndex >= activeGameObjects.size()) {
                currentIndex = 0;
                startNewTurn();
            }
        } while (!getGameObjectWithTurn().creature.getStatistics().isAbleToPlay());
        getGameObjectWithTurn().applyNewRound();


    }

    private Actions initializeActions() {
        Actions actions = new ActionsWarhammer();
        return actions;
    }

    private void starGame(){
        activeGameObjects = board.getAllGameObjects();
        sortByMovePriority(activeGameObjects);
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

    public Actions getActions() {
        return actions;
    }

    public ArrayList<AbstractMap.SimpleEntry<Vector2, String>> boardToList() {
        ArrayList<AbstractMap.SimpleEntry<Vector2, String>> result = new ArrayList<AbstractMap.SimpleEntry<Vector2,
                String>>();

        for (int i = 0; i < activeGameObjects.size(); i++) {
            result.add(new AbstractMap.SimpleEntry<>(getGameObjectPosition(activeGameObjects.get(i)),
                    activeGameObjects.get(i).getCreature().getObjectPathPicture()));
        }

        return result;


    }
    public void removeDead(){
        for(int i = 0; i < activeGameObjects.size();i++){
            if(!activeGameObjects.get(i).getCreature().getStatistics().isAlive()){
                board.removeGameObject(getGameObjectPosition(activeGameObjects.get(i)));
                activeGameObjects.remove(activeGameObjects.get(i));
                i--;
            }

        }

    }

    public Board getBoard() {
        return board;
    }
}
