package game.generals;

import java.util.Objects;

public class Vector2 {
    public int x = -1;
    public int y = -1;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Vector2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vector2 vector2 = (Vector2) o;
        return x == vector2.x && y == vector2.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public boolean isOutOfRange(int sizeX, int sizeY) {
        return x < 0 || x >= sizeX || y < 0 || y >= sizeY;
    }

}