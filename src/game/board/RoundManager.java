package game.board;

import java.util.*;

import game.generals.Vector2;
import game.interfaceWarhammer.ActionsWarhammer;
import game.interfaces.Actions;

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
        while (!getGameObjectWithTurn().creature.getStatistics().isAbleToPlay()) {
            currentIndex++;
        }
        getGameObjectWithTurn().applyNewRound();

        if (currentIndex >= activeGameObjects.size()) {
            currentIndex = 0;
            startNewTurn();
        }
    }

    private Actions initializeActions() {
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

    public Board getBoard() {
        return board;
    }
}
