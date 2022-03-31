package ball.physics;

/**
 * Got to implement space occupation by this entity 
 *  (maybe creating an interface "Entity" for the 
 *  main character, bird and this ball);
 *  TODO: modify to private fields please
 *  TODO: add a copy-of method for avoiding verbose creation in factory
 *  TODO: add a mehod for having area occupied by this entyty (could be useful for
 *  view (checking borders) and for checking collisions beetween balls and charachter);
 */
public class Pos2D {
    public double x;
    public double y;
    private final Dimensions dimension;
    private int radius;

    public Pos2D(final double x, final double y, Dimensions dimension, int radius) {
        this.x = x;
        this.y = y;
        this.dimension = dimension;
        this.radius = radius;
    }

    public Pos2D(final double x, final double y, Dimensions dimension) {
        this(x, y, dimension, 0);
    }

    public Dimensions getDimension() {
    	return this.dimension;
    }

    public void setDimensions(final Dimensions dim) {
    }

    @Override
    public String toString() {
        return "Pos(" + this.x + ", " + this.y + ")";
    }

    /**
     * Dimension Based on PNGs dimensions
     * @return
     *      the size of the ball
     */
    private int getDiamterFromDimension() {
        switch (this.dimension) {
            case FATHER:
                this.radius = 50;
                return 50;
            case SON:
                this.radius = 41;
                return 41;
            case GRANDSON:
                this.radius = 25;
                return 25;
            default:
                return 0;
        }
    }

    public int getRadius() {
        if (this.radius == 0) {
            return this.getDiamterFromDimension();
        }
        return this.radius;
    }
}
