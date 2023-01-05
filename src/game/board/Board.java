package game.board;

import game.utils.MathHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Board {
    private final Place[][] places;
    
    public Board(int width, int height) {
        places = new Place[height][width];
        
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                places[y][x] = new Place(x, y);
            }
        }
    }
    
    private Place getPlace(Vector2 vector) {
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
        getPlace(currentPos).setGameObject(null);
    }
    
    public void removeGameObject(Vector2 position) {
        getPlace(position).setGameObject(null);
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
}
