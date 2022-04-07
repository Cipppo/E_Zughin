package ball.testing;

import ball.physics.Dimensions;
import ball.physics.Entity;
import ball.physics.SpherePos2D;

public class Enemy implements Entity {

    private final SpherePos2D position;
    private final int size;

    public Enemy(double x, double y, int size) {
        this.position = new SpherePos2D(x, y, Dimensions.STD, size);
        this.size = size;
    }

    @Override
    public SpherePos2D getPosition() {
        return this.position;
    }

    @Override
    public int getSize() {
        return this.size;
    }
    
}
