package pangGuy.utilities;

import utilities.FullPair;

public class Pair<T, E> implements FullPair<T, E>{

    private T x;
    private E y;

    public Pair(T x, E y) {
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

    @Override
    public String toString() {
        return "Pair(" + this.x + ", " + this.y + ")";
    }
}
