package utilities;

/**
 * Modeling a generic two dimensional position in space.
 */
public abstract class Pos2D<T> {
    private T x;
    private T y;

    public Pos2D(final T x, final T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public void setX(T value) {
        this.x = value;
    }

    public T getY() {
        return y;
    }

    public void setY(T value) {
        this.y = value;
    }

    @Override
    public String toString() {
        return "Pos(" + this.x + ", " + this.y + ")";
    }
}