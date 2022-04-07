package ball.physics;

/**
 * Modeling a sphere that occupies a place in 2 dimensional space
 * and a size in space described by it's diameter
 */
public class SpherePos2D extends Pos2D {
    private int diameter;

    public SpherePos2D(final double x, final double y, final Dimensions dimension, final int diameter) {
        super(x, y, dimension);
        this.diameter = (int)(diameter * super.getDimension().getValue());
    }

    public SpherePos2D(final double x, final double y, final Dimensions dimension) {
        super(x, y, dimension);
    }

    public int getDiameter() {
        return this.diameter;
    }

}
