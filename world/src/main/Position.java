package main;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Boolean isEqual(Position otherPosition) {
        return x == otherPosition.x && y == otherPosition.y;
    }

    @Override
    public String toString() {
        return x + ":" + y;
    }
}

