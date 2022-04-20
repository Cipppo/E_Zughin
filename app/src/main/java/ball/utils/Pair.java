package ball.utils;

public class Pair<T> {
    private T x;
    private T y;

    public Pair(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return this.x;
    }

    public T getY() {
        return this.y;
    }

    public void setX(T value) {
        this.x = value;
    }

    public void setY(T value) {
        this.y = value;
    }

    @Override
    public String toString() {
        return "Pair(" + this.x + ", " + this.y + ")";
    }
}
