package pangGuy.utilities;

public class Pair<T, E> {

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

    @Override
    public String toString() {
        return "Pair(" + this.x + ", " + this.y + ")";
    }
}
