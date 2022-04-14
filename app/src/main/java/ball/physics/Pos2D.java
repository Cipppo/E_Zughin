package ball.physics;

/**
 * Got to implement space occupation by this entity 
 *  (maybe creating an interface "Entity" for the 
 *  main character, bird and this ball);
 */
public abstract class Pos2D {
    public double x;
    public double y;
    private final Dimensions dimension;

    public Pos2D(final double x, final double y, Dimensions dimension) {
        this.x = x;
        this.y = y;
        this.dimension = dimension;
    }

    public Dimensions getDimension() {
    	return this.dimension;
    }

    @Override
    public String toString() {
        return "Pos(" + this.x + ", " + this.y + ")";
    }
}