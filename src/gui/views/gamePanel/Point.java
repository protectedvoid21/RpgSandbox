package gui.views.gamePanel;

public class Point {

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x = -1;
    public int y = -1;

    public boolean isOutOfRange(int sizeX, int sizeY) {
        return x < 0 || x >= sizeX || y < 0 || y >= sizeY;
    }
}