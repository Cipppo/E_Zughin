package ball.physics;

/**
 * Got to implement space occupation by this entity 
 *  (maybe creating an interface "Entity" for the 
 *  main character, bird and this ball);
 */
public abstract class EntityPos2D<T> {
    private T x;
    private T y;

    public EntityPos2D(final T x, final T y) {
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