package ball.utils;

import mergeballs.utilities.FullPair;

/**
 * Utility Pair for storing and modify two values of different type.
 */
public class SettablePair<T, E> implements FullPair<T, E> {
    private T x;
    private E y;

    public SettablePair(T x, E y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public T getX() {
        return this.x;
    }

    @Override
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
