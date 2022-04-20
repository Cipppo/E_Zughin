package ball.physics;
/**
 * Modeling a sphere that occupies a place in 2 dimensional space
 * with the specified {@link ball.physics.Dimensions}, and a 
 * specific diameter.  
 */
public class SpherePos2D extends Pos2D<Double> {
    private int diameter;
    private Dimensions dimension;

    public SpherePos2D(final double x, final double y, final Dimensions dimension, final int diameter) {
        super(x, y);
        this.dimension = dimension;
        this.diameter = (int)(diameter * dimension.getValue());
    }
 
    public int getDiameter() {
        return this.diameter;
    }

    public Dimensions getDimension() {
        return this.dimension;
    }
}
