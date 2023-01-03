package game.board;

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

        placeDest.setTransform(place.getTransform());
        place.setTransform(null);
    }
}
