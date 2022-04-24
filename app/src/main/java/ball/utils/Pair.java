package ball.utils;

import mergeballs.utilities.FullPair;

public class Pair<T, E> implements FullPair<T, E> {
    private T x;
    private E y;

    public Pair(T x, E y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return this.x;
    }

    public E getY() {
        return this.y;
    }

    public void setX(T value) {
        this.x = value;
    }

    public void setY(E value) {
        this.y = value;
    }

    @Override
    public String toString() {
        return "Pair(" + this.x + ", " + this.y + ")";
    }
}
