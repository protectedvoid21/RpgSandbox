package game.board;

import game.generals.Vector2;
import game.utils.MathHelper;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final Place[][] places;
    private final int height;
    private final int width;

    public Board(Scenario scenario) {
        places = new Place[scenario.getHeight()][scenario.getWidth()];
        height = scenario.getHeight();
        width = scenario.getWidth();

        for(int x = 0; x < scenario.getWidth(); x++) {
            for(int y = 0; y < scenario.getHeight(); y++) {
                places[y][x] = new Place();
            }
        }
        
        for(var scenarioData : scenario.getScenarioDataList()) {
            getPlace(scenarioData.position).setGameObject(new GameObject(scenarioData.creature));
        }
    }
    
    public Place getPlace(Vector2 vector) {
        if(vector.x < 0 || vector.x >= places[0].length || vector.y < 0 || vector.y >= places.length) {
            throw new IllegalArgumentException();
        }
        return places[vector.y][vector.x];
    }
    
    public boolean canMoveTo(Vector2 position) {
        return getPlace(position).isEmpty();
    }

    public void move(Vector2 currentPos, Vector2 destPos) {
        if(!canMoveTo(destPos)) {
            return;
        }

        getPlace(destPos).setGameObject(getPlace(destPos).getGameObject());
        removeGameObject(currentPos);
    }
    
    public void removeGameObject(Vector2 position) {
        getPlace(position).setGameObject(null);
    }
    
    public List<GameObject> getAllGameObjects() {
        List<GameObject> gameObjects = new ArrayList<>();
        
        for(int i = 0; i < places.length; i++) {
            for(int j = 0; j < places[i].length; j++) {
                if(!places[i][j].isEmpty()) {
                    gameObjects.add(places[i][j].getGameObject());
                }
            }
        }
        
        return gameObjects;
    }
    
    public List<Vector2> getNeighborPlaces(Vector2 position, int range) {
        int width = places[0].length;
        int height = places.length;

        List<Vector2> gridCircle = MathHelper.getGridCircle(range);
        List<Vector2> movedCircle = new ArrayList<>();
        
        for(var vector : gridCircle) {
            movedCircle.add(new Vector2(vector.x + position.x, vector.y + position.y));
        }
        
        return movedCircle.stream()
                .filter(v -> v.x >= 0 && v.x < width && v.y >= 0 && v.y < height)
                .toList();
    }
    
    public List<Vector2> getEmptyPlaces(Vector2 position, int range) {
        return getNeighborPlaces(position, range)
                .stream()
                .filter(n -> getPlace(n).isEmpty())
                .toList();
    }

    public int getHeigt() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    private void sort(){

    }
}
