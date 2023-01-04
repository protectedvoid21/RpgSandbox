package game.board;

import game.utils.MathHelper;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Place[][] places;
    
    public Board(int width, int height) {
        places = new Place[height][width];
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
    
    public List<Place> getEmptyPlaces(Place place, int range) {
        List<Place> emptyPlaces = new ArrayList<>();
        
        int xStart = place.x;
        int yStart = place.y;
        
        if(place.isEmpty()) {
            emptyPlaces.add(place);
        }
        
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
        
        for(var element : gridCircle) {
            emptyPlaces.add(places[element[1]][element[0]]);
        }
        
        return emptyPlaces;
    }
}
