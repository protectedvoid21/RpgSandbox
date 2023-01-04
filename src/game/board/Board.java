package game.board;

import game.utils.MathHelper;

import java.util.ArrayList;
import java.util.List;

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
    
    public boolean canMoveTo(Place placeDestination) {
        return placeDestination.isEmpty();
    }

    public void move(Place place, Place placeDest) {
        if(!canMoveTo(placeDest)) {
            return;
        }

        placeDest.setGameObject(place.getGameObject());
        place.setGameObject(null);
    }
    
    public void removeGameObject(Place place) {
        place.setGameObject(null);
    }
    
    public List<Place> getNeighborPlaces(Place place, int range) {
        int xStart = place.x;
        int yStart = place.y;
        
        int width = places[0].length;
        int height = places.length;

        List<Integer[]> gridCircle = MathHelper.getGridCircle(range);
        for(var element : gridCircle) {
            element[0] += xStart;
            element[1] += yStart;
        }
        
        gridCircle = gridCircle.stream()
                .filter(g -> g[0] >= 0 && g[0] < width && g[1] >= 0 && g[1] < height)
                .toList();
        
        List<Place> neighborPlaces = new ArrayList<>();
        
        for(var element : gridCircle) {
            neighborPlaces.add(places[element[1]][element[0]]);
        }
        
        return neighborPlaces;
    }
    
    public List<Place> getEmptyPlaces(Place place, int range) {
        return getNeighborPlaces(place, range)
                .stream().filter(p -> p.isEmpty()).toList();
    }
}
